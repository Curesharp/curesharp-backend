package com.curesharp.controller;

import com.curesharp.dto.Health;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/health")
public class HealthController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Health statusAplicacao(){
        Health health = new Health("health");
        return health;
    }
}
