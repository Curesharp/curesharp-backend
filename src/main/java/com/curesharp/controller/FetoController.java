package com.curesharp.controller;

import com.curesharp.business.FetoBusiness;
import com.curesharp.model.Feto;
import com.curesharp.util.ErrorResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/feto")
public class FetoController {

    private FetoBusiness business = new FetoBusiness();
    ErrorResponse error = new ErrorResponse();


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastra(Feto feto){
        try {
            business.inserirFeto(feto);
            return Response.status(Response.Status.CREATED).build();
        }catch (Exception e){
            error.setErro(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Feto> lista() throws Exception {
        return business.listarFetos();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscaPorId(@PathParam("id") Long id){
        try {
            Feto feto = business.bucarFetoPorId(id);
            return Response.status(Response.Status.OK).entity(feto).build();
        }catch (Exception e){
            error.setErro(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
    }

    @GET
    @Path("/rg-da-gestante/{rg}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscaPorRgDaMae(@PathParam("rg") String rg){
        try {
            ArrayList<Feto> feto = business.bucarFetoPorRGDaGestante(rg);
            return Response.status(Response.Status.OK).entity(feto).build();
        }catch (Exception e){
            error.setErro(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualiza(@PathParam("id") Long id, Feto feto){
        try {
            business.atualizarFeto(id, feto);
            return Response.accepted().build();
        }catch (Exception e){
            error.setErro(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleta(@PathParam("id") Long id){
        try {
            business.deletarFeto(id);
            return Response.noContent().build();
        } catch (Exception e) {
            error.setErro(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
    }

}
