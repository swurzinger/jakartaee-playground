package org.eclipse.jakarta.hello;

import jakarta.ejb.Stateless;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.stream.Collectors;

// TODO: does not work yet
@Provider
@Stateless
public class ValidationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        String errors = exception.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(", "));

        return Response.status(Response.Status.BAD_REQUEST)
                .entity("{\"errors\": \"" + errors + "\"}")
                .build();
    }
}
