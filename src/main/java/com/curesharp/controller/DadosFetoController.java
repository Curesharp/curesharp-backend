package com.curesharp.controller;

import com.curesharp.business.DadosFetoBusiness;
import com.curesharp.dto.DadosSelecionarDadosFeto;
import com.curesharp.model.DadosFeto;
import com.curesharp.util.ErrorResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/dados/feto")
public class DadosFetoController {

    private DadosFetoBusiness business = new DadosFetoBusiness();
    ErrorResponse error = new ErrorResponse();


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastra(DadosFeto dadosFeto){
        try {
            return Response.status(Response.Status.CREATED)
                    .entity(business.inserirDadosFeto(dadosFeto))
                    .build();
        }catch (Exception e){
            error.setErro(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<DadosSelecionarDadosFeto> lista() throws Exception {
        return business.listarDadosFeto();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscaPorId(@PathParam("id") Long id){
        try {
            DadosSelecionarDadosFeto dadosFetoDTO = business.buscarDadosFetoPorId(id);
            return Response.status(Response.Status.OK).entity(dadosFetoDTO).build();
        }catch (Exception e){
            error.setErro(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
    }

    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscaPorIdDoFeto(@PathParam("id") Long id){
        try {
            ArrayList<DadosSelecionarDadosFeto> dadosFetoDTO = business.buscarDadosFetoPorIdDoFeto(id);
            return Response.status(Response.Status.OK).entity(dadosFetoDTO).build();
        }catch (Exception e){
            error.setErro(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
    }

    @GET
    @Path("/gestante/rg/{rg}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscaPorIdDoFeto(@PathParam("rg") String rg){
        try {
            ArrayList<DadosSelecionarDadosFeto> dadosFetoDTO = business.buscarDadosFetoPorRgDaMae(rg);
            return Response.status(Response.Status.OK).entity(dadosFetoDTO).build();
        }catch (Exception e){
            error.setErro(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response altera(@PathParam("id") Long id, DadosFeto dadosFeto){
        try {
            return Response.status(Response.Status.ACCEPTED)
                    .entity(business.alterarDadosFeto(id, dadosFeto))
                    .build();
        }catch (Exception e){
            error.setErro(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleta(@PathParam("id") Long id){
        try {
            business.deletarDadosFeto(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        }catch (Exception e){
            error.setErro(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
    }
}
