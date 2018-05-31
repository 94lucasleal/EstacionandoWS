package com.lucas.senac.rn;

import com.google.gson.Gson;
import com.lucas.senac.bd.FavoritosBD;
import com.lucas.senac.bean.Estabelecimento;
import com.lucas.senac.bean.Favoritos;
import javax.ws.rs.*;

@Path("favoritos/")
public class FavoritosRN {

    private final FavoritosBD favoritosBD;
    //private final UsuarioRNVAL usuarioRNVal;
    private final Gson gson;

    public FavoritosRN() {
        favoritosBD = new FavoritosBD();
        //usuarioRNVal = new UsuarioRNVAL();
        gson = new Gson();
    }

    @POST
    @Consumes({"application/json"})
    @Path("inserir")
    public void inserir(String content) {
        Favoritos favoritos = (Favoritos) gson.fromJson(content, Favoritos.class);
        //usuarioRNVal.validarInserirUsuario(usuario);
        favoritosBD.inserir(favoritos);
    }

    @DELETE
    @Path("excluir/{idestabelecimento}/{idusuario}")
    public void excluir(@PathParam("idestabelecimento") int idestabelecimento, @PathParam("idusuario") int idusuario) {
        Favoritos favoritos = new Favoritos(idestabelecimento, idusuario, '0');
        //usuarioRNVal.validarExcluirUsuario(usuario);
        favoritosBD.excluir(favoritos);
    }

    @GET
    @Produces("application/json")
    @Path("consultar/{idestabelecimento}/{idusuario}")
    public String consultar(@PathParam("idestabelecimento") int idestabelecimento, @PathParam("idusuario") int idusuario) {
        Favoritos favoritos = new Favoritos(idestabelecimento, idusuario, '0');
        //usuarioRNVal.validarConsultarUsuario(usuario);
        return gson.toJson(favoritosBD.consultar(favoritos));
    }

    @PUT
    @Consumes({"application/json"})
    @Path("alterar")
    public void alterar(String content) {
        Favoritos favoritos = (Favoritos) gson.fromJson(content, Favoritos.class);
        //usuarioRNVal.validarAlterarUsuario(usuario);
        favoritosBD.alterar(favoritos);
    }

    @GET
    @Produces("application/json")
    @Path("pesquisar/{idusuario}")
    public String pesquisar(@PathParam("idusuario") int idusuario) {
        Favoritos favoritos = new Favoritos(0, idusuario, '0');
        return gson.toJson(favoritosBD.pesquisar(favoritos));
    }

}
