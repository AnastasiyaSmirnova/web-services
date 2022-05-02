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

    public void addUser(UserAccount user) {
        activeUsers.add(user.getToken());
    }

    public void deleteUser(String token) {
        activeUsers.remove(token);
    }

    public boolean userActive(String token) {
        return activeUsers.contains(token);
    }
}
