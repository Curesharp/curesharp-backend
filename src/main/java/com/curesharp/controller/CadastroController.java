package com.curesharp.controller;

import com.curesharp.business.UsuarioBusiness;
import com.curesharp.model.Usuario;
import com.curesharp.util.ErrorResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cadastro")
public class CadastroController {

    private UsuarioBusiness business = new UsuarioBusiness();
    ErrorResponse error = new ErrorResponse();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastra(Usuario usuario){
        try {
            business.inserirUsuario(usuario);
            return Response.status(Response.Status.CREATED)
                    .build();
        }catch (Exception e){
            error.setErro(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
        }

    }
}
