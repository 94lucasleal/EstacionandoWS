package com.lucas.senac.rn;

import com.google.gson.Gson;
import com.lucas.senac.bd.ServicoBD;
import com.lucas.senac.bean.Servico;
import com.lucas.senac.rnval.ServicoRNVAL;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("servico/")
public class ServicoRN {

    private final ServicoBD servicoBD;
    private final ServicoRNVAL servicoRNVal;
    private final Gson gson;

    public ServicoRN() {
        servicoBD = new ServicoBD();
        servicoRNVal = new ServicoRNVAL();
        gson = new Gson();
    }

    @POST
    @Consumes({"application/json"})
    @Path("inserirServico")
    public void inserirServico(String content) {
        Servico servico = (Servico) gson.fromJson(content, Servico.class);
        servicoRNVal.validarInserirServico(servico);
        servicoBD.inserirServico(servico);
    }

    @DELETE
    @Path("excluirServico/{idservico}")
    public void excluirServico(@PathParam("idservico") String idservico) {
        Servico servico = new Servico(Integer.parseInt(idservico), null, null, null, 0);
        servicoRNVal.validarExcluirServico(servico);
        servicoBD.excluirServico(servico);
    }

    @GET
    @Produces("application/json")
    @Path("consultarServico/{idestabelecimento}")
    public String consultarServico(@PathParam("idestabelecimento") int idestabelecimento) {
        Servico servico = new Servico(null, idestabelecimento, null, null, 0);
        servicoRNVal.validarConsultarServico(servico);
        return gson.toJson(servicoBD.consultarServico(servico));
    }

    @PUT
    @Consumes({"application/json"})
    @Path("alterarServico")
    public void alterarServico(String content) {
        Servico servico = (Servico) gson.fromJson(content, Servico.class);
        servicoRNVal.validarAlterarServico(servico);
        servicoBD.alterarServico(servico);
    }

    @GET
    @Produces("application/json")
    @Path("buscarTodosServicos")
    public String buscarTodosServicos() {
        return gson.toJson(servicoBD.buscarTodosServicos());
    }

}
