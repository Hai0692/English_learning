package thuyhai.tchl.project_final.models;

import java.io.Serializable;

public class login_response implements Serializable {
    private String message;
    private User_info user;
    private String token;

    public login_response( String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User_info getUser() {
        return user;
    }

    public void setUser(User_info user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "login_response{" +
                "message='" + message + '\'' +
                ", user=" + user +
                ", token='" + token + '\'' +
                '}';
    }
}
