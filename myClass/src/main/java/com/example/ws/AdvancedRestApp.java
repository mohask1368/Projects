package com.example.ws;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/person")
public class AdvancedRestApp {

    private static Map <String,Person> staff  = new HashMap<>();

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/{param}")
    public String get(@PathParam("param") String msg){

        StringBuilder sb = new StringBuilder();
        for (Person p : staff.values())
        sb.append("first name = ").append(p.getFirstName()).append(",lastName = ").append(p.getLastName()).append("<br/>");

        return sb.toString();

    }
    @POST
    public Response post(@FormParam("fName") String fName , @FormParam("lName") String lName){

    if (staff.containsKey(fName))
        return Response.serverError().build();
        staff.put(fName,new Person(fName,lName));
    return Response.ok().build();
    }

    @PUT
    public Response put(@FormParam("fName") String fName , @FormParam("lName") String lName){

    Person p = staff.get(fName);
    if (p==null)
        return Response.serverError().build();
    p.setLastName(lName);
    return Response.ok().build();

    }

    @DELETE
    public Response delete(@FormParam("fName") String fName ){
        if (staff.remove(fName) == null)
            return Response.serverError().build();
        return Response.ok().build();
    }
}
