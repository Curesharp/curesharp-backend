package com.curesharp.controller;

import com.curesharp.business.UsuarioBusiness;
import com.curesharp.model.Usuario;
import com.curesharp.util.ErrorResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/usuario")
public class UsuarioController {

    private UsuarioBusiness business = new UsuarioBusiness();
    ErrorResponse error = new ErrorResponse();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Usuario> lista() throws Exception {
        return business.listarUsuarios();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscaPorId(@PathParam("id") Long id) throws Exception {
        try {
            var usuario = business.bucarUsuarioPorId(id);
            return Response.status(Response.Status.OK).entity(usuario).build();
        }catch (Exception e){
            error.setErro(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
    }

    @GET
    @Path("/email/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscaPorEmail(@PathParam("email") String email) throws Exception {
        try {
            var usuario = business.bucarUsuarioPorEmail(email);
            return Response.status(Response.Status.OK).entity(usuario).build();
        }catch (Exception e){
            error.setErro(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualiza(@PathParam("id") Long id, Usuario usuario) throws Exception {
        try {
            business.atualizarUsuario(id, usuario);
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
            business.deletarUsuario(id);
            return Response.noContent().build();
        } catch (Exception e) {
            error.setErro(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
    }

}
