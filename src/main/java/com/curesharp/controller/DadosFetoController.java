package com.curesharp.controller;

import com.curesharp.business.DadosFetoBusiness;
import com.curesharp.dto.DadosSelecionarDadosFeto;
import com.curesharp.model.DadosFeto;
import com.curesharp.util.ErrorResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("dados-feto")
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
}
