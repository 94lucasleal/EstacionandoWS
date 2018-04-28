package com.lucas.senac.rn;

import com.lucas.senac.bd.CartaoBD;
import com.lucas.senac.bean.Cartao;
import com.lucas.senac.rnval.CartaoRNVAL;
import java.util.List;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("cartao/")
public class CartaoRN {
    
    private final CartaoBD cartaoBD;
    private final CartaoRNVAL cartaoRNVal;

    public CartaoRN() {
        cartaoBD = new CartaoBD();
        cartaoRNVal = new CartaoRNVAL();
    }
    
    @POST
    @Consumes({"application/json"})
    @Path("inserir")
    public void inserir(@WebParam(name = "id") String id,
                        @WebParam(name = "value") Double value,
                        @WebParam(name = "token") String token,
                        @WebParam(name = "parcels") int parcels) {

        Cartao cartao = new Cartao(id,value,token,parcels);
        
        System.out.println("Chegou aqui:"+cartao);
        //cartaoRNVal.validarInserirCartao(cartao);
        //cartaoBD.inserirCartao(cartao);
    }

       @DELETE
    @Path("excluir/{id}")
    public void excluir(@WebParam(name = "id") String id) {
        Cartao cartao = new Cartao(id,null,null,0);
        //cartaoRNVal.validarExcluirCartao(cartao);
        //cartaoBD.excluirCartao(cartao);
    }
    
    @GET
    @Produces("application/json")
    @Path("consultar/{id}")
    public Cartao consultar(@WebParam(name = "id") String id) {
        Cartao cartao = new Cartao(id,null,null,0);
        //cartaoRNVal.validarConsultarCartao(cartao);
        return cartaoBD.consultarCartao(cartao);
    }
    
    @PUT
    @Consumes({"application/json"})
    @Path("alterar")
    public void alterar(@WebParam(name = "id") String id,
                        @WebParam(name = "value") Double value,
                        @WebParam(name = "token") String token,
                        @WebParam(name = "parcels") int parcels) {
        
        Cartao cartao = new Cartao(id,value,token,parcels);
        cartaoRNVal.validarAlterarCartao(cartao);
        cartaoBD.alterarCartao(cartao);
    }
    
    @GET
    @Produces("application/json")
    @Path("pesquisar/{pesquisa}")
    public List<Cartao> pesquisar(@WebParam(name = "pesquisa") String pesquisa) {
        return cartaoBD.pesquisarCartao(pesquisa);
    }
    
    @GET
    @Produces("application/json")
    @Path("buscarTodos")
    public List<Cartao> buscarTodos() {
        return cartaoBD.buscarTodosCartao();
    }

}
