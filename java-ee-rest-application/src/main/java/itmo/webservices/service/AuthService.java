package itmo.webservices.service;


import itmo.webservices.model.Credentials;
import itmo.webservices.model.UserAccount;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@RequestScoped
@Path("/auth")
@Produces({MediaType.APPLICATION_JSON})
public class AuthService {
    private final UsersService usersService = UsersService.getInstance();

    @POST
    @Path("login")
    public Response login(Credentials creds) {
        // imagine that username & password is correct
        UserAccount newUser = new UserAccount(creds.getUsername(), creds.getToken());
        usersService.addUser(newUser);
        System.out.println("login user: " + newUser.getUsername());

        return Response.ok(newUser.getToken()).build();
    }

    @POST
    @Path("logout")
    public void logout(@Context SecurityContext context) {
        String name = context.getUserPrincipal().getName();
        System.out.println("login user: " + name);
//        usersService.deleteUser();
    }
}
