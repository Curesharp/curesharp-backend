package com.curesharp.config.filters;

import com.curesharp.util.ErrorResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.SignatureException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter("/*")
public class MainFilter implements Filter {

    private static final String SECRET_KEY = "RJY4rJL6Mq3pgxY0aBZVf/kwVqT6JvPCvHb5ORX8YQg=";

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse httpResponse = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;

        // Configuração do CORS
        configureCORS(httpResponse);

        //Configuração JWT
//        if(isRotaLiberada(request)){
//            chain.doFilter(req, res);
//            return;
//        }
//
//        String token = extractToken(request.getHeader(HttpHeaders.AUTHORIZATION));
//
//        try {
//            validateToken(token);
//        } catch (SignatureException e) {
//            handleInvalidToken(httpResponse);
//            return;
//        }

        chain.doFilter(req, res);
    }

    private void configureCORS(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Vary", "Origin");

    }

    private boolean isRotaLiberada(HttpServletRequest request) {
        String rota = request.getRequestURI();

        return rota.endsWith("login") ||
                rota.endsWith("health") ||
                rota.endsWith("cadastro") ||
                rota.endsWith("token/user");
    }

    private String extractToken(String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.substring(7).trim();
        }
        return null;
    }

    private void validateToken(String token) throws SignatureException {
        Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
    }

    private void handleInvalidToken(HttpServletResponse response) throws IOException {
        ErrorResponse error = new ErrorResponse();
        error.setErro("Não autorizado");

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write(error.toString());
        response.getWriter().flush();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

}