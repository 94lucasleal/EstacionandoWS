package com.lucas.senac.rn;

import com.google.gson.Gson;
import com.lucas.senac.bd.TransacaoBD;
import com.lucas.senac.bean.Carteira;
import com.lucas.senac.bean.Pagamento;
import com.lucas.senac.bean.utils.Customers;
import com.lucas.senac.bean.Usuario;
import com.lucas.senac.bean.Transacao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
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
import me.pagar.model.Address;
import me.pagar.model.Customer;
import me.pagar.model.Phone;

@Path("transacao/")
public class TransacaoRN {
    
    private final TransacaoBD transacaoBD;
    private final CarteiraRN carteiraRN;
    private final Gson gson;
    
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public TransacaoRN() {
        transacaoBD = new TransacaoBD();
        carteiraRN = new CarteiraRN();
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
        /*
        EstabelecimentoRN estabelecimentoRN = new EstabelecimentoRN();
        String aux2 = estabelecimentoRN.consultarEstabelecimento(pagamento.getIdestabelecimento());
        Estabelecimento estabelecimento = (Estabelecimento) gson.fromJson(aux2, Estabelecimento.class);
        */
        
        Address address = new Address(pagamento.getCustomer().getAddresses().get(0).getStreet(), 
                                      pagamento.getCustomer().getAddresses().get(0).getStreetNumber(), 
                                      pagamento.getCustomer().getAddresses().get(0).getNeighborhood(),
                                      pagamento.getCustomer().getAddresses().get(0).getZipcode());
        Collection<Address> addresses = new ArrayList<Address>();
        addresses.add(address);
        
        Phone phone = new Phone();
        phone.setDdd(pagamento.getCustomer().getPhones().get(0).getDdd());
        phone.setDdi(pagamento.getCustomer().getPhones().get(0).getDdi());
        phone.setNumber(pagamento.getCustomer().getPhones().get(0).getNumber());
        Collection<Phone> phones = new ArrayList<Phone>();
        phones.add(phone);

        Customer customer = new Customer();
        customer.setAddresses(addresses);
        customer.setPhones(phones);
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
            
            transacao.setDta_entrada(format.parse(pagamento.getDta_entrada()));
            transacao.setDta_saida(format.parse(pagamento.getDta_saida()));
            transacao.setIdusuario(pagamento.getIdusuario());
            transacao.setIdestabelecimento(pagamento.getIdestabelecimento());
                              
            transacaoBD.inserir(transacao);


            return gson.toJson(tx);
        } catch (Exception e) {
            System.out.println(e);
            return gson.toJson(e);
        }   
    }
    
    @POST
    @Consumes({"application/json"})
    @Path("inserirCartao")
    public String inserirCartao(String content){ 
        PagarMe.init("ak_test_U9HHME9pST6E6ZDv0cBWeVfd3UoVLG");
        System.out.println(content);
        Pagamento pagamento = (Pagamento) gson.fromJson(content, Pagamento.class);
        System.out.println(pagamento);
       
        /*
        UsuarioRN usuarioRN = new UsuarioRN();
        String aux1 = usuarioRN.consultar(pagamento.getIdusuario());
        Usuario user = (Usuario) gson.fromJson(aux1, Usuario.class);
        
        EstabelecimentoRN estabelecimentoRN = new EstabelecimentoRN();
        String aux2 = estabelecimentoRN.consultarEstabelecimento(pagamento.getIdestabelecimento());
        Estabelecimento estabelecimento = (Estabelecimento) gson.fromJson(aux2, Estabelecimento.class);
        */
               
        Double value = pagamento.getValue() * 100;
        
        try {
            Transaction tx = new Transaction();
            tx.setAmount(value.intValue());
            tx.setCardHash(pagamento.getToken());
            tx.setPaymentMethod(PaymentMethod.CREDIT_CARD);
            tx.save();
            System.out.println(gson.toJson(tx));
            
            Transacao transacao = carregaTransacao(tx);  
            transacao.setIdusuario(pagamento.getIdusuario());
            transacao.setIdestabelecimento(pagamento.getIdestabelecimento());
            transacao.setDta_entrada(format.parse(pagamento.getDta_entrada()));
            transacao.setDta_saida(format.parse(pagamento.getDta_saida()));
             
            transacaoBD.inserir(transacao);
            
                        
            ArrayList<Carteira> carteira = new ArrayList<Carteira>();
            System.out.println("TESTE1:");
            String a = carteiraRN.pesquisar(transacao.getIdusuario().toString());
            System.out.println("TESTE:       "+a);
            Carteira c = (Carteira) gson.fromJson(a, Carteira.class);
            System.out.println(c);
            
            /*
            if (transacao.getStatus().toLowerCase().equals("paid")) {
                c.setSaldo_disponivel();
            } else {
                c.setSaldo_pendente(0);   
            }
            
           
            
            carteiraRN.inserir(content);
            */

            return gson.toJson(tx);
        } catch (Exception e) {
            System.out.println(e);
            return gson.toJson(e);
        }   
    }
    
    public Transacao carregaTransacao(Transaction tx){
        Transacao transacao = new Transacao();
        transacao.setAmount(tx.getAmount());
        transacao.setRefunded_amount(tx.getRefundedAmount());
        transacao.setAuthorized_amount(tx.getAuthorizedAmount());
        transacao.setPaid_amount(tx.getPaidAmount());
        transacao.setInstallments(tx.getInstallments());
        transacao.setCost(tx.getCost());
        transacao.setTid(tx.getTid());
        transacao.setNsu(tx.getNsu());
        transacao.setBoleto_url(tx.getBoletoUrl());
        transacao.setBoleto_barcode(tx.getBoletoBarcode());
        transacao.setReferer(tx.getReferer());
        transacao.setIp(tx.getIp());
        transacao.setAcquirer_name(tx.getAcquirerName().name());
        transacao.setPayment_method(tx.getPaymentMethod().name());
        transacao.setStatus(tx.getStatus().name());
        transacao.setStatus_reason(tx.getStatusReason().name());
        transacao.setDate_updated(tx.getUpdatedAt().toString("dd/MM/yyyy HH:mm:ss"));

        Customers cus = new Customers();
        if (tx.getCustomer() != null) {
            transacao.setCustomers_document(tx.getCustomer().getDocumentNumber());
            transacao.setCustomers_email(tx.getCustomer().getEmail());
            transacao.setCustomers_name(tx.getCustomer().getName());
        }

        if (tx.getCard() != null){
            transacao.setCartao_brand(tx.getCard().getBrand().name());
            transacao.setCartao_first_digits(tx.getCard().getFirstDigits());
            transacao.setCartao_last_digits(tx.getCard().getLastDigits());
            transacao.setCartao_name(tx.getCard().getHolderName());
            transacao.setCartao_valid(tx.getCard().getValid());
        }
        
        transacao.setId(tx.getId());
        transacao.setDate_created(tx.getCreatedAt().toString("dd/MM/yyyy HH:mm:ss"));
        
        return transacao;
    }
    
    @DELETE
    @Path("excluir/{idtransacao}")
    public void excluir(@PathParam("idtransacao") int idtransacao) {
        Transacao transacao = new Transacao();
        transacao.setIdtransacao(idtransacao);
        transacaoBD.excluir(transacao);
    }
    
    @GET
    @Produces("application/json")
    @Path("consultar/{idtransacao}")
    public Transacao consultar(@PathParam("idtransacao") int idtransacao) {
        Transacao transacao = new Transacao();
        transacao.setIdtransacao(idtransacao);
        return transacaoBD.consultar(transacao);
    }
    
    @PUT
    @Consumes({"application/json"})
    @Path("alterar")
    public void alterar(String content) {
        System.out.println(content);
        Transacao transacao = (Transacao) gson.fromJson(content, Transacao.class);
        System.out.println("Chegou aqui:"+transacao);
    }
    
    @GET
    @Produces("application/json")
    @Path("pesquisar/{pesquisa}")
    public String pesquisar(@PathParam("pesquisa")  String pesquisa) {
        return gson.toJson(transacaoBD.pesquisar(pesquisa));
    }
    
    @GET
    @Produces("application/json")
    @Path("pesquisarHistoricoUsuario/{pesquisa}")
    public String pesquisarHistoricoUsuario(@PathParam("pesquisa")  String pesquisa) {
        return gson.toJson(transacaoBD.pesquisarHistoricoUsuario(pesquisa));
    }
    
    @GET
    @Produces("application/json")
    @Path("buscarTodos")
    public String buscarTodos() {
        return gson.toJson(transacaoBD.buscarTodos());
    }

}