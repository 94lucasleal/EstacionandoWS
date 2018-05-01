package com.lucas.senac.rn;

import com.google.gson.Gson;
import com.lucas.senac.bd.CartaoBD;
import com.lucas.senac.bean.Cartao;
import com.lucas.senac.bean.Pagamento;
import com.lucas.senac.rnval.CartaoRNVAL;
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

  import com.mercadopago.*;
  import com.mercadopago.exceptions.MPConfException;
  import com.mercadopago.exceptions.MPException;
  import com.mercadopago.resources.Payment;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.preference.Item;
import com.mercadopago.resources.datastructures.preference.Payer;

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
    public void inserir(String content) throws MPException{
        System.out.println(content);
        MercadoPago.SDK.configure("TEST-5932925008911488-042718-876ba434b898faaf69a929436bc55479-317543512");
        
        Preference preference = new Preference();
        System.out.println(preference.toString());

        Item item = new Item();
        item.setId("1234")
            .setTitle("Aerodynamic Wooden Table")
            .setQuantity(7)
            .setCategoryId("BRL")
            .setUnitPrice((float)51.34);
        System.out.println(item.toString());

        Payer payer = new Payer();
        payer.setEmail("telly@bol.com.br");
        System.out.println(payer.toString());

        preference.setPayer(payer);
        preference.appendItem(item);
        System.out.println(preference.toString());
        preference.save();
        System.out.println(preference.toString());
        /*
        MercadoPago.SDK.configure("ENV_ACCESS_TOKEN");
        
        Preference preference = new Preference();

        Item item = new Item();
        item.setId("1234")
            .setTitle("Aerodynamic Wooden Table")
            .setQuantity(7)
            .setCategoryId("BRL")
            .setUnitPrice((float)51.34);

        Payer payer = new Payer();
        payer.setEmail("telly@bol.com.br");

        preference.setPayer(payer);
        preference.appendItem(item);
        preference.save();
        
        
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
