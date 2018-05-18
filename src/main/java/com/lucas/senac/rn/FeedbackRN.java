package com.lucas.senac.rn;

import com.google.gson.Gson;
import com.lucas.senac.bd.FeedbackBD;
import com.lucas.senac.bean.Feedback;
import javax.ws.rs.*;


@Path("feedback/")
public class FeedbackRN {

    private final FeedbackBD feedbackBD;
    private final Gson gson;
    
    public FeedbackRN() {
        feedbackBD = new FeedbackBD();
        gson = new Gson();
    }

    @POST
    @Consumes({"application/json"})
    @Path("inserir")
    public void inserir(String content) {
        Feedback feedback = (Feedback) gson.fromJson(content, Feedback.class);
        feedbackBD.inserir(feedback);
    }

    @DELETE
    @Path("excluir/{idfeedback}")
    public void excluir(@PathParam("idfeedback") int idfeedback) {
        Feedback feedback = new Feedback();
        feedback.setIdfeedback(idfeedback);
        feedbackBD.excluir(feedback);
    }

    @GET
    @Produces("application/json")
    @Path("consultar/{idfeedback}")
    public String consultar(@PathParam("idfeedback") int idfeedback) {
        Feedback feedback = new Feedback();
        feedback.setIdfeedback(idfeedback);
        return gson.toJson(feedbackBD.consultar(feedback));
    }

    @PUT
    @Consumes({"application/json"})
    @Path("alterar")
    public void alterar(String content) {
        Feedback feedback = (Feedback) gson.fromJson(content, Feedback.class);
        feedbackBD.alterar(feedback);
    }
    
    @GET
    @Produces("application/json")
    @Path("pesquisar/{idestabelecimento}")
    public String pesquisar(@PathParam("idestabelecimento") int idestabelecimento) {
        Feedback feedback = new Feedback();
        feedback.setIdestabelecimento(idestabelecimento);
        return gson.toJson(feedbackBD.pesquisar(feedback));
    }

}
