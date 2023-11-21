package com.curesharp.controller;

import com.curesharp.business.TokenBusiness;
import com.curesharp.dto.DadosResponseUsuario;
import com.curesharp.util.ErrorResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/token/user")
public class TokenController {

    TokenBusiness business = new TokenBusiness();
    ErrorResponse error = new ErrorResponse();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response userPeloToken(ContainerRequestContext requestContext) throws Exception {
        try {
            DadosResponseUsuario usuario = business.pegarUsuarioPeloToken(requestContext.getHeaders().getFirst(HttpHeaders.AUTHORIZATION));
            return Response.status(Response.Status.OK).entity(usuario).build();
        } catch (Exception e) {
            error.setErro(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
        }
    }
}
