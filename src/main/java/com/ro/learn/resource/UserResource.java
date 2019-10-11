package com.ro.learn.resource;

import com.ro.learn.model.User;
import com.ro.learn.service.UserService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    private static final Logger LOGGER = Logger.getLogger(UserResource.class.getName());

    @Inject
    UserService userService;

    @GET
    public List<User> list() {
        LOGGER.info("Get request received for user service.");
        return userService.getUsers();
    }

    @POST
    public User add(@Valid User user) {
        userService.createUser(user);
        return user;
    }
}
