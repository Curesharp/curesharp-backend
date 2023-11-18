package com.curesharp.controller;

import com.curesharp.business.GestanteBusiness;
import com.curesharp.model.Gestante;
import com.curesharp.util.ErrorResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/gestante")
public class GestanteController {

    private GestanteBusiness business = new GestanteBusiness();
    ErrorResponse error = new ErrorResponse();


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastra(Gestante gestante){
        try {
            business.inserirGestante(gestante);
            return Response.status(Response.Status.CREATED).build();
        }catch (Exception e){
            error.setErro(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
        }

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Gestante> lista() throws Exception {
        return business.listarGestantes();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscaPorId(@PathParam("id") Long id) throws Exception {
        try {
            Gestante usuario = business.bucarGestantePorId(id);
            return Response.status(Response.Status.OK).entity(usuario).build();
        }catch (Exception e){
            error.setErro(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
    }

    @GET
    @Path("/rg/{rg}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscaPorEmail(@PathParam("rg") String rg) throws Exception {
        try {
            Gestante usuario = business.bucarGestantePorRG(rg);
            return Response.status(Response.Status.OK).entity(usuario).build();
        }catch (Exception e){
            error.setErro(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualiza(@PathParam("id") Long id, Gestante gestante) throws Exception {
        try {
            business.atualizarGestante(id, gestante);
            return Response.accepted().build();
        }catch (Exception e){
            error.setErro(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleta(@PathParam("id") Long id) throws Exception {
        try {
            business.deletarGestante(id);
            return Response.noContent().build();
        } catch (Exception e) {
            error.setErro(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
    }

}
