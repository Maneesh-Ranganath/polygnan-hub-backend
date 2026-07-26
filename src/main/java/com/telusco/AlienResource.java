package com.telusco;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Path("aliens")

public class AlienResource
{
    AlienRepository repo=new AlienRepository();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Alien> getAlien(){
        System.out.print("GetAlien Called....");

        return repo.getAliens();
    }

}
