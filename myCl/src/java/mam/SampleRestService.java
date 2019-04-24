package mam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class SampleRestService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response sayHello(){

        return Response.status(200).entity("hello mohammad").build();


    }
}
