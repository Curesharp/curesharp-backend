package com.curesharp.config.security;

import com.curesharp.util.ErrorResponse;
import io.jsonwebtoken.Jwts;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class JwtFilter implements ContainerRequestFilter {

    ErrorResponse error = new ErrorResponse();

    private static final String SECRET_KEY = "RJY4rJL6Mq3pgxY0aBZVf/kwVqT6JvPCvHb5ORX8YQg=";

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        if (isLoginEndpoint(requestContext)) {
            return;
        }

        String token = extrairToken(requestContext.getHeaders().getFirst(HttpHeaders.AUTHORIZATION));
        try {
            validarToken(token);
        } catch (Exception e) {
            error.setErro("Não autorizado");
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                    .entity(error)
                    .build());
        }
    }

    private boolean isLoginEndpoint(ContainerRequestContext requestContext) {
        String rota = requestContext.getUriInfo().getPath();
        String metodo = requestContext.getMethod();

        if(rota.equals("login") || rota.equals("") || rota.equals("cadastro") || rota.equals("token/user")){
            return true;
        }else{
            return false;
        }
    }

    private String extrairToken(String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.substring(7).trim();
        }
        return null;
    }

    private void validarToken(String token) {
        Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
    }
}
