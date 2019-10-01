package com.youngprime.revenue.users.exceptionmappers;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.youngprime.revenue.users.dtos.Error;

@Provider
@ApplicationScoped
public class BadRequestExceptionMapper implements ExceptionMapper<BadRequestException> {

    @Override
    public Response toResponse(BadRequestException e) {

        Error error = new Error();
        error.setStatus(400);
        error.setCode("resource.bad.request");
        error.setMessage(e.getMessage());

        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(error)
                .build();
    }
}