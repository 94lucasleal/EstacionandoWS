package com.lucas.senac.rn;

import com.google.gson.Gson;
import com.lucas.senac.bd.PagamentoBD;
import com.lucas.senac.bean.Estabelecimento;
import com.lucas.senac.bean.Pagamento;
import com.lucas.senac.bean.utils.Customers;
import com.lucas.senac.bean.utils.Endereco;
import com.lucas.senac.bean.utils.Metadado;
import com.lucas.senac.bean.Historico;
import com.lucas.senac.bean.Usuario;
import com.lucas.senac.bean.utils.Telefone;
import com.lucas.senac.bean.utils.Transacao;
import com.lucas.senac.rnval.CartaoRNVAL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import me.pagar.model.PagarMe;
import me.pagar.model.Transaction;
import me.pagar.model.Transaction.PaymentMethod;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.pagar.model.Address;
import me.pagar.model.Customer;
import me.pagar.model.Phone;

@Path("pagamento/")
public class PagamentoRN {
    
    private final PagamentoBD cartaoBD;
    private final CartaoRNVAL cartaoRNVal;
    private final Gson gson;
    
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public PagamentoRN() {
        cartaoBD = new PagamentoBD();
        cartaoRNVal = new CartaoRNVAL();
        gson = new Gson();
    }
    
    @POST
    @Consumes({"application/json"})
    @Path("inserirBoleto")
    public String inserirBoleto(String content){ 
        PagarMe.init("ak_test_U9HHME9pST6E6ZDv0cBWeVfd3UoVLG");
        
        System.out.println(content);
        Pagamento pagamento = (Pagamento) gson.fromJson(content, Pagamento.class);
        System.out.println(pagamento);
        
        UsuarioRN usuarioRN = new UsuarioRN();
        String aux1 = usuarioRN.consultar(pagamento.getIdusuario());
        Usuario user = (Usuario) gson.fromJson(aux1, Usuario.class);
        
        EstabelecimentoRN estabelecimentoRN = new EstabelecimentoRN();
        String aux2 = estabelecimentoRN.consultarEstabelecimento(pagamento.getIdestabelecimento());
        Estabelecimento estabelecimento = (Estabelecimento) gson.fromJson(aux2, Estabelecimento.class);

        Customer customer = new Customer();
        customer.setAddresses(pagamento.getCustomer().getAddresses());
        customer.setPhones(pagamento.getCustomer().getPhones());
        customer.setName(user.getNome());
        customer.setEmail(user.getEmail());
        customer.setDocumentNumber(user.getCpf());
        
        Double value = pagamento.getValue() * 100;
        
        try {
            Transaction tx = new Transaction();
            tx.setCustomer(customer);
            tx.setAmount(value.intValue());
            tx.setPaymentMethod(PaymentMethod.BOLETO);
            tx.save();
            System.out.println(tx.toString());
            
            Transacao transacao = carregaTransacao(tx);
            
            Historico historico = new Historico();
            historico.setDta_entrada(format.parse(pagamento.getDta_entrada()));
            historico.setDta_saida(format.parse(pagamento.getDta_saida()));
            historico.setTrancasao(transacao);
            historico.setUsuario(user);
            historico.setEstabelecimento(estabelecimento);
                              
            cartaoBD.inserir(historico);

            return gson.toJson(tx);
        } catch (Exception e) {
            System.out.println(e);
            return gson.toJson(e);
        }   
        /*
        System.out.println(content);
        Cartao cartao = (Cartao) gson.fromJson(content, Cartao.class);
        
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        PagarMe.init("ak_test_U9HHME9pST6E6ZDv0cBWeVfd3UoVLG");
        
        
        Map<String, Object> metadata = new HashMap<String, Object>();
        metadata.put("id", cartao.getProduct_id());
        
        Double value = cartao.getValue() * 100;
        
        try {
            Transaction tx = new Transaction();
            tx.setAmount(value.intValue());
            tx.setCardHash(cartao.getToken());
            tx.setPaymentMethod(PaymentMethod.CREDIT_CARD);
            tx.setMetadata(metadata);
            tx.save();
            System.out.println(gson.toJson(tx));
            
            Calendar hoje = Calendar.getInstance();
           
            Pagamento pagamento = new Pagamento();
            pagamento.setDta_pagamento(hoje.getTime());
            pagamento.setDta_entrada(format.parse(cartao.getDta_entrada()));
            pagamento.setDta_saida(format.parse(cartao.getDta_saida()));
            pagamento.setIdestabelecimento(cartao.getIdestabelecimento());
            pagamento.setIdusuario(cartao.getIdusuario());
            pagamento.setProduct_id(cartao.getProduct_id());
            pagamento.setAmount(tx.getAmount());
            pagamento.setInstallments(tx.getInstallments());
            pagamento.setNsu(tx.getNsu());
            pagamento.setTid(tx.getTid());
            pagamento.setAuthorization_code(tx.getAuthorizationCode());
            pagamento.setAcquirer_name(tx.getAcquirerName().name());
            pagamento.setPayment_method(tx.getPaymentMethod().name());
            pagamento.setStatus(tx.getStatus().name());
            pagamento.setRefuse_reason(tx.getRefuseReason());
            pagamento.setStatus_reason(tx.getStatusReason().name());
            pagamento.setCard_brand(tx.getCard().getBrand().name());
            pagamento.setDate_updated(tx.getUpdatedAt().toString());
            pagamento.setDate_created(tx.getCreatedAt().toString());
            pagamento.setBoleto_url(tx.getBoletoUrl());
            pagamento.setBoleto_barcode(tx.getBoletoBarcode());
            System.out.println(pagamento);
            
            cartaoBD.inserir(pagamento);

            return gson.toJson(tx);
        } catch (Exception e) {
            System.out.println(e);
            return gson.toJson(e);
        }   
    */
    }
    
    public Transacao carregaTransacao(Transaction tx){
        
        Transacao transacao = new Transacao();
        transacao.setAmount(tx.getAmount());
        transacao.setRefundedAmount(tx.getRefundedAmount());
        transacao.setAuthorizedAmount(tx.getAuthorizedAmount());
        transacao.setPaidAmount(tx.getPaidAmount());
        transacao.setInstallments(tx.getInstallments());
        transacao.setCost(tx.getCost());
        transacao.setTid(tx.getTid());
        transacao.setNsu(tx.getNsu());
        transacao.setBoletoUrl(tx.getBoletoUrl());
        transacao.setBoletoBarcode(tx.getBoletoBarcode());
        transacao.setReferer(tx.getReferer());
        transacao.setIp(tx.getIp());
        transacao.setAcquirerName(tx.getAcquirerName().name());
        transacao.setPaymentMethod(tx.getPaymentMethod().name());
        transacao.setStatus(tx.getStatus().name());
        transacao.setStatusReason(tx.getStatusReason().name());
        transacao.setDateUpdated(tx.getUpdatedAt().toString("dd/MM/yyyy HH:mm:ss"));

        Customers cus = new Customers();
        cus.setDocumentNumber(tx.getCustomer().getDocumentNumber());
        cus.setName(tx.getCustomer().getName());
        cus.setEmail(tx.getCustomer().getEmail());

        List<Telefone> tels = new ArrayList<Telefone>();
        for (Phone a : tx.getCustomer().getPhones()) {
            Telefone tel = new Telefone();
            tel.setDdi(a.getDdi());
            tel.setDdd(a.getDdd());
            tel.setNumber(a.getNumber());
            tels.add(tel);
        }
        cus.setPhones(tels);

        List<Endereco> ends = new ArrayList<Endereco>();
        for (Address a : tx.getCustomer().getAddresses()) {
            Endereco end = new Endereco();
            end.setStreet(a.getStreet());
            end.setStreetNumber(a.getStreetNumber());
            end.setNeighborhood(a.getNeighborhood());
            end.setZipcode(a.getZipcode());
            ends.add(end);
        }
        cus.setAddresses(ends);

        transacao.setCustomer(cus);
        transacao.setId(tx.getId());
        transacao.setDateCreated(tx.getCreatedAt().toString("dd/MM/yyyy HH:mm:ss"));
        
        return transacao;
    }
    
    /*
    
    @GET
    @Consumes({"application/json"})
    @Path("pagamento/{id}/{value}/{token}/{parcels}")
    public String pagamento(@PathParam("id") String id,
                            @PathParam("value") Double value,
                            @PathParam("token") String token,
                            @PathParam("parcels") int parcels){
        
        Pagamento cartao = new Pagamento(0,0,id, value, token, parcels,null,null);
        System.out.println(cartao);
        PagarMe.init("ak_test_U9HHME9pST6E6ZDv0cBWeVfd3UoVLG");
        Map<String, Object> metadata = new HashMap<String, Object>();
        metadata.put("id", cartao.getProduct_id());
        Double valor = cartao.getValue() * 100;
        try {
            Transaction tx = new Transaction();
            tx.setAmount(valor.intValue());
            tx.setCardHash(cartao.getToken());
            tx.setPaymentMethod(PaymentMethod.CREDIT_CARD);
            tx.setMetadata(metadata);
            tx.save();
            System.out.println(gson.toJson(tx));
            return gson.toJson(tx);
        } catch (Exception e) {
            System.out.println(e);
            return e.toString();
        }          
    }
    
    @DELETE
    @Path("excluir/{id}")
    public void excluir(@PathParam("id") String id) {
        Pagamento cartao = new Pagamento(0,0,id,null,null,0,null,null);
        //cartaoRNVal.validarExcluirCartao(cartao);
        //cartaoBD.excluirCartao(cartao);
    }
    
    @GET
    @Produces("application/json")
    @Path("consultar/{id}")
    public Pagamento consultar(@PathParam("id") String id) {
        Pagamento cartao = new Pagamento(0,0,id,null,null,0,null,null);
        //cartaoRNVal.validarConsultarCartao(cartao);
        return cartaoBD.consultarCartao(cartao);
    }
    
    @PUT
    @Consumes({"application/json"})
    @Path("alterar")
    public void alterar(String content) {
        System.out.println(content);
        Pagamento cartao = (Pagamento) gson.fromJson(content, Pagamento.class);
        System.out.println("Chegou aqui:"+cartao);
    }
    
    @GET
    @Produces("application/json")
    @Path("pesquisar/{pesquisa}")
    public String pesquisar(@PathParam("pesquisa")  String pesquisa) {
        return gson.toJson(cartaoBD.pesquisar(pesquisa));
    }
    
    @GET
    @Produces("application/json")
    @Path("buscarTodos")
    public String buscarTodos() {
        return gson.toJson(cartaoBD.buscarTodosCartao());
    }
*/
}
