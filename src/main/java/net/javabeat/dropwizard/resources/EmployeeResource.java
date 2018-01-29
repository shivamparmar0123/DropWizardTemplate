package net.javabeat.dropwizard.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;

import net.javabeat.dropwizard.api.Representation;

@Path("/emp-details")
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {
    private final String message;
    private final String defaultText1;
    private final String defaultText2;

    public EmployeeResource(String message, String defaultText1, String defaultText2) {
        this.message = message;
        this.defaultText1 = defaultText1;
        this.defaultText2 = defaultText2;
    }

    @GET
    @Timed
    public Representation sayHello(@QueryParam("param1") Optional<String> param1,
                                   @QueryParam("param2") Optional<String> param2) {
        final String value = String.format(message, param1.or(defaultText1),
                param2.or(defaultText2));
        return new Representation(value);
    }


    @GET
    @Path("{isbn}")
    @Timed
    public Representation getBook(@PathParam("isbn") String isbn) {
        final String value = String.format(message, isbn,
                isbn);
        return new Representation(value);
    }
}