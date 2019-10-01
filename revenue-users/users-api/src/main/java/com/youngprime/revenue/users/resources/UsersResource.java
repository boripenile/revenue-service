package com.youngprime.revenue.users.resources;

import com.kumuluz.ee.logs.cdi.Log;
import com.youngprime.revenue.users.Users;
import com.youngprime.revenue.users.cdi.UsersBean;
import com.youngprime.revenue.users.dtos.UserDto;
import com.youngprime.revenue.users.mappers.UserMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

import org.eclipse.microprofile.metrics.annotation.Metered;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Api(value = "Users", description = "Resource for managing users data.")
@RequestScoped
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Log
public class UsersResource {

    @Inject
    private UsersBean usersBean;

    @Context
    protected UriInfo uriInfo;

    @Inject
	UserMapper userMapper;
	
    
    @GET
    @ApiOperation(value = "Get users", notes = "Returns a list of all users.", 
    	response = UserDto.class, authorizations= { @Authorization(value="authorization") })
    @RolesAllowed({"users:view"})
    public Response getUsers() {
		
        List<UserDto> users = userMapper.fromUsers(usersBean.getUsers());

        return Response.ok(users).build();
    }

    @GET
    @Path("/filtered")
    public Response getUsersFiltered() {

        List<Users> users;

        users = usersBean.getUsersFilter(uriInfo);

        return Response.status(Response.Status.OK).entity(userMapper.fromUsers(users)).build();
    }

    @GET
    @ApiOperation(value = "Get a user", notes = "Returns a user with provided id.", response = UserDto.class)
    @Path("/{userId}")
    @RolesAllowed("user")
    public Response getUser(@PathParam("userId") String userId) {

        Users user = usersBean.getUser(userId);

        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.status(Response.Status.OK).entity(userMapper.fromUser(user)).build();
    }

    @POST
    public Response createUser(UserDto dto) {

        if ((dto.firstName == null || dto.firstName.isEmpty()) || (dto.lastName == null
                || dto.lastName.isEmpty())) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } 

        Users user = usersBean.createUser(userMapper.toUser(dto));
        if (user.getId() != null) {
            return Response.status(Response.Status.CREATED).entity(userMapper.fromUser(user)).build();
        } else {
            return Response.status(Response.Status.CONFLICT).entity(userMapper.fromUser(user)).build();
        }
    }

    @PUT
    @ApiOperation(value = "Update a user", notes = "Returns an updated user", response = UserDto.class)
    @Path("{userId}")
    public Response putZavarovanec(@PathParam("userId") String userId, UserDto dto) {

        Users user = usersBean.putUser(userId, userMapper.toUser(dto));

        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            if (user.getId() != null)
                return Response.status(Response.Status.OK).entity(userMapper.fromUser(user)).build();
            else
                return Response.status(Response.Status.NOT_MODIFIED).build();
        }
    }

    @DELETE
    @Path("{userId}")
    @RolesAllowed("admin")
    @Metered(name = "delete-requests")
    public Response deleteUser(@PathParam("userId") String userId) {

        boolean deleted = usersBean.deleteUser(userId);

        if (deleted) {
            return Response.status(Response.Status.GONE).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}