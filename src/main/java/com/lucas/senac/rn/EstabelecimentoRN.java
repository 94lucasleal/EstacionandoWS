package com.lucas.senac.rn;

import com.google.gson.Gson;
import com.lucas.senac.bean.Estabelecimento;
import com.lucas.senac.bd.EstabelecimetoBD;
import com.lucas.senac.rnval.EstabalecimentoRNVAL;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("estabelecimento/")
public class EstabelecimentoRN {

    private final EstabelecimetoBD estabelecimetoBD;
    private final EstabalecimentoRNVAL estabalecimentoRNVAL;
    private final Gson gson;

    public EstabelecimentoRN() {
        estabelecimetoBD = new EstabelecimetoBD();
        estabalecimentoRNVAL = new EstabalecimentoRNVAL();
        gson = new Gson();
    }

    @POST
    @Consumes({"application/json"})
    @Path("inserirEstabelecimento")
    public void inserirEstabelecimento(String content) {
        Estabelecimento estabelecimento = (Estabelecimento) gson.fromJson(content, Estabelecimento.class);
        estabalecimentoRNVAL.validarInserirEstabelecimento(estabelecimento);
        estabelecimetoBD.inserirEstabelecimento(estabelecimento);
    }

    @DELETE
    @Path("excluirEstabelecimento/{idestabelecimento}")
    public void excluirEstabelecimento(@PathParam("idestabelecimento") Integer idestabelecimento) {
        Estabelecimento estabelecimento = new Estabelecimento(idestabelecimento, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null);
        estabalecimentoRNVAL.validarExcluirEstabelecimento(estabelecimento);
        estabelecimetoBD.excluirEstabelecimento(estabelecimento);
    }

    @GET
    @Produces("application/json")
    @Path("consultarEstabelecimento/{idestabelecimento}")
    public Estabelecimento consultarEstabelecimento(@PathParam("idestabelecimento") String idestabelecimento) {
        Estabelecimento estabelecimento = new Estabelecimento(Integer.parseInt(idestabelecimento), null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null);
        estabalecimentoRNVAL.validarConsultarEstabelecimento(estabelecimento);
        return estabelecimetoBD.consultarEstabelecimento(estabelecimento);
    }

    @PUT
    @Consumes({"application/json"})
    @Path("alterarEstabelecimento")
    public void alterarEstabelecimento(String content) {
        Estabelecimento estabelecimento = (Estabelecimento) gson.fromJson(content, Estabelecimento.class);
        estabalecimentoRNVAL.validarAlterarEstabelecimento(estabelecimento);
        estabelecimetoBD.alterarEstabelecimento(estabelecimento);
    }

    @GET
    @Produces("application/json")
    @Path("pesquisarEstabelecimento/{pesquisa}")
    public String pesquisarEstabelecimento(@PathParam("pesquisa") String pesquisa) {
        return gson.toJson(estabelecimetoBD.pesquisarEstabelecimento(pesquisa));
    }

    @GET
    @Produces("application/json")
    @Path("buscarTodosEstabelecimento")
    public String buscarTodosEstabelecimento() {
        return gson.toJson(estabelecimetoBD.buscarTodosEstabelecimento());
    }

}
