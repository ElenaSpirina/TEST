package data;

import model.RequestToken;

public class AuthData {

    public static RequestToken validAuth() {
        return new RequestToken(
                "admin",
                "password123"
        );
    }
}