package com.lucas.senac.rn;

import com.google.gson.Gson;
import com.lucas.senac.bd.CartaoBD;
import com.lucas.senac.bean.Cartao;
import com.lucas.senac.rnval.CartaoRNVAL;
import com.mercadopago.MP;
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
    public boolean inserir(String content){
        System.out.println(content);
        Cartao cartao = (Cartao) gson.fromJson(content, Cartao.class);
        System.out.println("Chegou aqui:"+cartao);
        PagarMe.init("ak_test_U9HHME9pST6E6ZDv0cBWeVfd3UoVLG");
        Map<String, Object> metadata = new HashMap<String, Object>();
        metadata.put("id", cartao.getId());
        String value = cartao.getValue() * 100 + "";
        try {
            Transaction tx = new Transaction();
            tx.setAmount(Integer.parseInt(value));
            tx.setCardHash(cartao.getToken());
            tx.setPaymentMethod(PaymentMethod.CREDIT_CARD);
            tx.setMetadata(metadata);
            tx.save();
            return true;
        } catch (Exception e) {
            return false;
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
