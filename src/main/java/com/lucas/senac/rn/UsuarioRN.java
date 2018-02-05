package com.lucas.senac.rn;

import com.google.gson.Gson;
import com.lucas.senac.bd.UsuarioBD;
import com.lucas.senac.bean.Usuario;
import com.lucas.senac.rnval.UsuarioRNVAL;
import java.util.List;
import javax.jws.WebParam;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;


@Path("usuario")
public class UsuarioRN {

    private final UsuarioBD usuarioBD;
    private final UsuarioRNVAL usuarioRNVal;
    private final Gson gson;
    
    @Context
    private UriInfo context;
    
    
    public UsuarioRN() {
        usuarioBD = new UsuarioBD();
        usuarioRNVal = new UsuarioRNVAL();
        gson = new Gson();
    }

    @POST
    @Consumes({"application/json"})
    @Path("/inserirUsuario")
    public void inserirUsuario(String content) {
        Usuario usuario = (Usuario) gson.fromJson(content, Usuario.class);
        usuarioRNVal.validarInserirUsuario(usuario);
        usuarioBD.inserirUsuario(usuario);
    }

    @DELETE
    @Path("/excluirUsuario/{idusuario}")
    public void excluirUsuario(@PathParam("idusuario") String idUsuario) {
        Usuario usuario = new Usuario(Integer.parseInt(idUsuario), null, null, null, null, null, null, 0);
        usuarioRNVal.validarExcluirUsuario(usuario);
        usuarioBD.excluirUsuario(usuario);
    }

    @GET
    @Produces("application/json")
    @Path("/consultarUsuario/{email}/{senha}")
    public String consultarUsuario(@PathParam("email") String email,
            @PathParam("senha") String senha) {
        Usuario usuario = new Usuario(null, null, null, null, email, senha, null, 0);
        usuarioRNVal.validarConsultarUsuario(usuario);
        return gson.toJson(usuarioBD.consultarUsuario(usuario));
    }

    @PUT
    @Consumes({"application/json"})
    @Path("/alterarUsuario")
    public void alterarUsuario(String content) {
        Usuario usuario = (Usuario) gson.fromJson(content, Usuario.class);
        usuarioRNVal.validarAlterarUsuario(usuario);
        usuarioBD.alterarUsuario(usuario);
    }
    /*
    @GET
    @Produces("application/json")
    @Path("/pesquisarUsuario/{pesquisa}")
    public String pesquisarUsuario(@PathParam("pesquisa") String pesquisa) {
        System.out.println(pesquisa);
        return gson.toJson(usuarioBD.pesquisarUsuario(pesquisa));
    }
    
    @GET
    @Produces("application/json")
    @Path("/buscarTodosUsuario")
    public String buscarTodosUsuario() {
        /*Usuario usuario = new Usuario(27, "aa", "aa", "aa", "aa", "aa", 1, 1111);
        String json = gson.toJson(usuario);
        inserirUsuario(json);
        return gson.toJson(usuarioBD.buscarTodosUsuario());
    }*/

}
