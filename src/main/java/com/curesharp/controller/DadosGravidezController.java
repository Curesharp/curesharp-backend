package com.curesharp.controller;

import com.curesharp.business.DadosGravidezBusiness;
import com.curesharp.dto.DadosSelecionarDadosGravidez;
import com.curesharp.model.DadosGravidez;
import com.curesharp.util.ErrorResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/dados-gravidez")
public class DadosGravidezController {

    private DadosGravidezBusiness business = new DadosGravidezBusiness();
    ErrorResponse error = new ErrorResponse();


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastra(DadosGravidez dadosGravidez){
        try {
            return Response.status(Response.Status.CREATED)
                    .entity(business.inserirDadosGravidez(dadosGravidez))
                    .build();
        }catch (Exception e){
            error.setErro(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<DadosSelecionarDadosGravidez> lista() throws Exception {
        return business.listarDadosGravidez();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscaPorId(@PathParam("id") Long id){
        try {
            DadosSelecionarDadosGravidez dadosGravidez = business.bucarDadosGravidezPorId(id);
            return Response.status(Response.Status.OK).entity(dadosGravidez).build();
        }catch (Exception e){
            error.setErro(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
    }

    @GET
    @Path("/id-da-gestante/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscaPorIdDaGestante(@PathParam("id") Long id){
        try {
            ArrayList<DadosSelecionarDadosGravidez> dadosGravidez = business.bucarDadosGravidezPorIdDaGestante(id);
            return Response.status(Response.Status.OK).entity(dadosGravidez).build();
        }catch (Exception e){
            error.setErro(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
    }

    @GET
    @Path("/rg-da-gestante/{rg}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscaPorRGDaGestante(@PathParam("rg") String rg){
        try {
            ArrayList<DadosSelecionarDadosGravidez> dadosGravidez = business.bucarDadosGravidezPorRGDaGestante(rg);
            return Response.status(Response.Status.OK).entity(dadosGravidez).build();
        }catch (Exception e){
            error.setErro(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualiza(@PathParam("id") Long id, DadosGravidez dadosGravidez){
        try {
            business.atualizarDadosGravidez(id, dadosGravidez);
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
            business.deletarDadosGravidez(id);
            return Response.noContent().build();
        } catch (Exception e) {
            error.setErro(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
    }
}
