package com.youngprime.revenue.users.exceptionmappers;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ServerErrorException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.youngprime.revenue.users.dtos.Error;

@Provider
@ApplicationScoped
public class ServerErrorExceptionMapper implements ExceptionMapper<ServerErrorException> {

    @Override
    public Response toResponse(ServerErrorException e) {

        Error error = new Error();
        error.setStatus(500);
        error.setCode("resource.server.error");
        error.setMessage(e.getMessage());

        return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(error)
                .build();
    }
}