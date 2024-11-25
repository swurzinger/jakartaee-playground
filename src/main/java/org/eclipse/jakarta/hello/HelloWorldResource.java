package org.eclipse.jakarta.hello;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@Path("hello")
public class HelloWorldResource {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @APIResponse(
            responseCode = "404",
            description = "dummy",
            content = @Content(mediaType = "application/json"))
    @APIResponseSchema(value = Hello.class,
            responseDescription = "Greeter info.",
            responseCode = "200")
    @Operation(
            summary = "Get greeter info",
            description = "More greeter info details description.")
    public Hello hello(
            @QueryParam("name")
            @Parameter(description = "The name whom to greet",
                    required = false,
                    example = "Stefan",
                    schema = @Schema(type = SchemaType.STRING))
            String name
    ) {
        if ((name == null) || name.trim().isEmpty()) {
            name = "world";
        }

        return new Hello(name);
    }
}
