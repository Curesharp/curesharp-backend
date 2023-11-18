package com.curesharp.controller;

import com.curesharp.business.LoginBusiness;
import com.curesharp.dto.DadosLoginUsuario;
import com.curesharp.model.Usuario;
import com.curesharp.util.ErrorResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")
public class LoginController {
    LoginBusiness business = new LoginBusiness();
    ErrorResponse error = new ErrorResponse();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response busca(DadosLoginUsuario dados){
        try{
            Usuario usuarioLogado = business.logar(dados);
            return Response.status(Response.Status.OK).entity(usuarioLogado).build();
        }catch (Exception e){
            error.setErro(e.getMessage());
            return Response.status(Response.Status.FORBIDDEN).entity(error).build();
        }
    }


}
