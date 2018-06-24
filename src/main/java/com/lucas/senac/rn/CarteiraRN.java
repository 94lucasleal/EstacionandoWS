package com.lucas.senac.rn;

import com.google.gson.Gson;
import com.lucas.senac.bd.CarteiraBD;
import com.lucas.senac.bean.Carteira;
import javax.ws.rs.*;

@Path("carteira/")
public class CarteiraRN {

    private final CarteiraBD carteiraBD;
    private final Gson gson;

    public CarteiraRN() {
        carteiraBD = new CarteiraBD();
        gson = new Gson();
    }

    @POST
    @Consumes({"application/json"})
    @Path("inserir")
    public void inserir(String content) {
        System.out.println(content);
        Carteira carteira = (Carteira) gson.fromJson(content, Carteira.class);
        carteiraBD.inserir(carteira);
    }

    @DELETE
    @Path("excluir/{idcarteira}")
    public void excluir(@PathParam("idcarteira") int idcarteira) {
        Carteira carteira = new Carteira();
        carteira.setIdcarteira(idcarteira);
        carteiraBD.excluir(carteira);
    }

    @GET
    @Produces("application/json")
    @Path("consultar/{idusuario}")
    public String consultar(@PathParam("idusuario") int idusuario) {
        Carteira carteira = new Carteira();
        carteira.setIdusuario(idusuario);
        return gson.toJson(carteiraBD.consultar(carteira));
    }

    @PUT
    @Consumes({"application/json"})
    @Path("alterar")
    public void alterar(String content) {
        Carteira carteira = (Carteira) gson.fromJson(content, Carteira.class);
        carteiraBD.alterar(carteira);
    }

    @GET
    @Produces("application/json")
    @Path("pesquisar/{pesquisa}")
    public String pesquisar(@PathParam("pesquisa") String pesquisa) {
        System.out.println(pesquisa);
        return gson.toJson(carteiraBD.pesquisar(pesquisa));
    }

    @GET
    @Produces("application/json")
    @Path("buscarTodos")
    public String buscarTodos() {
        return gson.toJson(carteiraBD.buscarTodos());
    }

}
