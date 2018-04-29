package com.lucas.senac.rn;

import com.google.gson.Gson;
import com.lucas.senac.bd.CartaoBD;
import com.lucas.senac.bean.Cartao;
import com.lucas.senac.bean.Pagamento;
import com.lucas.senac.rnval.CartaoRNVAL;
import com.mercadopago.MP;
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
import java.util.HashMap;
import java.util.Map;
import me.pagar.model.Address;
import me.pagar.model.Customer;
import me.pagar.model.PagarMeException;
import me.pagar.model.Phone;
import me.pagar.model.Recipient;

@Path("cartao/")
public class CartaoRN {
    
    private final CartaoBD cartaoBD;
    private final CartaoRNVAL cartaoRNVal;
    private final Gson gson;

    public CartaoRN() {
        cartaoBD = new CartaoBD();
        cartaoRNVal = new CartaoRNVAL();
        gson = new Gson();
    }
    
    @POST
    @Consumes({"application/json"})
    @Path("inserir")
    public String inserir(String content){
        System.out.println(content);
        Cartao cartao = (Cartao) gson.fromJson(content, Cartao.class);
        PagarMe.init("ak_test_U9HHME9pST6E6ZDv0cBWeVfd3UoVLG");
        Phone phone = new Phone();
        phone.setDdd("11");
        phone.setDdi("55");
        phone.setNumber("99999999");

        String street = "Avenida Brigadeiro Faria Lima";
        String streetNumber = "1811";
        String neighborhood = "Jardim Paulistano";
        String zipcode = "01451001";
        Address address = new Address(street, streetNumber, neighborhood, zipcode);

        String name = "Aardvark Silva";
        String email = "aardvark.silva@pagar.me";
        String documentNumber = "18152564000105";
        Customer customer = new Customer(name, email);
        customer.setDocumentType("corporation");
        customer.setAddress(address);
        customer.setPhone(phone);
        customer.setDocumentNumber(documentNumber);

        Map<String, Object> metadata = new HashMap<String, Object>();
        metadata.put("IdProduto", 13933139);

        Double value = cartao.getValue() * 100;
        try {
        Transaction tx = new Transaction();
        tx.setCustomer(customer);
        tx.setAmount(100);
        tx.setPaymentMethod(PaymentMethod.BOLETO);
        tx.setMetadata(metadata);
        tx.setPostbackUrl("http://requestb.in/pkt7pgpk");
        tx.save();
            System.out.println(gson.toJson(tx));
            Pagamento pagamento = new Pagamento();
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
            return gson.toJson(tx);
        } catch (Exception e) {
            System.out.println(e);
            return gson.toJson(e);
        }          
        /*
        System.out.println(content);
        Cartao cartao = (Cartao) gson.fromJson(content, Cartao.class);
        PagarMe.init("ak_test_U9HHME9pST6E6ZDv0cBWeVfd3UoVLG");
        Map<String, Object> metadata = new HashMap<String, Object>();
        metadata.put("id", cartao.getId());
        Double value = cartao.getValue() * 100;
        try {
            Transaction tx = new Transaction();
            tx.setAmount(value.intValue());
            tx.setCardHash(cartao.getToken());
            tx.setPaymentMethod(PaymentMethod.CREDIT_CARD);
            tx.setMetadata(metadata);
            tx.save();
            System.out.println(gson.toJson(tx));
            Pagamento pagamento = new Pagamento();
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
            return gson.toJson(tx);
        } catch (Exception e) {
            System.out.println(e);
            return gson.toJson(e);
        }          
        */
    }
    
    @GET
    @Consumes({"application/json"})
    @Path("pagamento/{id}/{value}/{token}/{parcels}")
    public String pagamento(@PathParam("id") String id,
                            @PathParam("value") Double value,
                            @PathParam("token") String token,
                            @PathParam("parcels") int parcels){
        
        Cartao cartao = new Cartao(id, value, token, parcels);
        System.out.println(cartao);
        PagarMe.init("ak_test_U9HHME9pST6E6ZDv0cBWeVfd3UoVLG");
        Map<String, Object> metadata = new HashMap<String, Object>();
        metadata.put("id", cartao.getId());
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
        Cartao cartao = new Cartao(id,null,null,0);
        //cartaoRNVal.validarExcluirCartao(cartao);
        //cartaoBD.excluirCartao(cartao);
    }
    
    @GET
    @Produces("application/json")
    @Path("consultar/{id}")
    public Cartao consultar(@PathParam("id") String id) {
        Cartao cartao = new Cartao(id,null,null,0);
        //cartaoRNVal.validarConsultarCartao(cartao);
        return cartaoBD.consultarCartao(cartao);
    }
    
    @PUT
    @Consumes({"application/json"})
    @Path("alterar")
    public void alterar(String content) {
        System.out.println(content);
        Cartao cartao = (Cartao) gson.fromJson(content, Cartao.class);
        System.out.println("Chegou aqui:"+cartao);
    }
    
    @GET
    @Produces("application/json")
    @Path("pesquisar/{pesquisa}")
    public String pesquisar(@PathParam("pesquisa")  String pesquisa) {
        return gson.toJson(cartaoBD.pesquisarCartao(pesquisa));
    }
    
    @GET
    @Produces("application/json")
    @Path("buscarTodos")
    public String buscarTodos() {
        return gson.toJson(cartaoBD.buscarTodosCartao());
    }

}
