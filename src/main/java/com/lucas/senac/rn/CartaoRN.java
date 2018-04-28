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
import me.pagar.model.PagarMeException;


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
    public void inserir(String content) throws Exception {
        System.out.println(content);
        Cartao cartao = (Cartao) gson.fromJson(content, Cartao.class);
        System.out.println("Chegou aqui:"+cartao);
        
        Map<String, Object> metadata = new HashMap<String, Object>();
        metadata.put("id", cartao);
        
            
        PagarMe.init("ak_test_U9HHME9pST6E6ZDv0cBWeVfd3UoVLG");
        Transaction tx = new Transaction();
        tx.setAmount(6990);
        System.out.println("1"+tx.getAmount());
        tx.setCardHash(cartao.getToken());
        System.out.println("2"+tx.cardHashKey().toString());
        tx.setPaymentMethod(PaymentMethod.CREDIT_CARD);
        System.out.println("3"+tx.getPaymentMethod());
        //tx.setMetadata(metadata);
        tx.save();
        
        System.out.println("Bombou"+tx.getAmount());

        /*
        MP mp = new MP("TEST-5932925008911488-042718-876ba434b898faaf69a929436bc55479-317543512");

        JSONObject payment = mp.post("/v1/payments", "{"+
                "'transaction_amount': 100,"+
                "'token': 'ff8080814c11e237014c1ff593b57b4d',"+
                "'description': 'Title of what you are paying for',"+
                "'installments': 1,"+
                "'payment_method_id': 'visa',"+
                "'payer': {"+
                        "'email': 'test_user_19653727@testuser.com'"+
                "}"+
        "}");
        */

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
