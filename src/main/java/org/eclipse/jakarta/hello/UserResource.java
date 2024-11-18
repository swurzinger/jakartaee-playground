package org.eclipse.jakarta.hello;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.jakarta.hello.entities.User;
import org.eclipse.jakarta.hello.entities.UserRepository;

import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    @Inject
    private UserRepository userRepository;

    @GET
    @Path("")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GET
    @Path("/{id}")
    public User getUser(@PathParam("id") Long id) {
        return userRepository.get(id);
    }

    @POST
    @Transactional
    public User createUser(User user) {
        userRepository.create(user);
        return user;
    }
}
