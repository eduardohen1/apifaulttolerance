package br.com.ehmf;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/api")
public class GreetingResource {

    @Inject
    @RestClient
    DemoraService demoraService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "API: " + demoraService.getDevagar();
    }
}
