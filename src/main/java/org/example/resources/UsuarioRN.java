/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.resources;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Lucas Leal
 */
@Path("generic")
public class UsuarioRN {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UsuarioRN
     */
    public UsuarioRN() {
    }

    /**
     * Retrieves representation of an instance of ws.UsuarioRN
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {

        return "teste";
    }

    /**
     * PUT method for updating or creating an instance of UsuarioRN
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
