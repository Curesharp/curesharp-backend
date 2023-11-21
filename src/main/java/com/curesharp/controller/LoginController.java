package com.curesharp.controller;

import com.curesharp.config.security.AuthenticationService;
import com.curesharp.dto.DadosLoginUsuario;
import com.curesharp.dto.Token;
import com.curesharp.util.ErrorResponse;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")
public class LoginController {

    ErrorResponse error = new ErrorResponse();

    @POST
    @PermitAll
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response logar(DadosLoginUsuario dados) throws Exception {
        try {
            AuthenticationService authenticationService = new AuthenticationService();
            Token token = new Token(authenticationService.generateToken(dados));

            return Response.status(Response.Status.OK).entity(token).build();
        } catch (Exception e) {
            error.setErro(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
        }
    }


}
