package itmo.webservices.service;

import itmo.webservices.model.UserAccount;

import java.util.HashSet;
import java.util.Set;

public class UsersService {
    private static UsersService service;
    private final Set<String> activeUsers = new HashSet<>();

    private UsersService() {
    }

    public static UsersService getInstance() {
        if (service == null) {
            service = new UsersService();
        }
        return service;
    }

    public String addUser(UserAccount user) {
        String token = user.getToken();
        activeUsers.add(token);
        return token;
    }

    public void deleteUser(String token) {
        activeUsers.remove(token);
    }

    public boolean userActive(String token) {
        return activeUsers.contains(token);
    }
}
