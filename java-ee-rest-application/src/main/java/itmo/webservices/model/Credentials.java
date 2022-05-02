package itmo.webservices.model;

import java.util.Base64;

public class Credentials {
    private String username;
    private String password;

    public Credentials() {
    }

    public Credentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }


    public String getToken() {
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString((username + password).getBytes());
    }
}
