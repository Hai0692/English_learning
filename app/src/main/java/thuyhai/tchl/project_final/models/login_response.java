package thuyhai.tchl.project_final.models;

public class login_response {
    private String message;
    private User_info user;

    public login_response(String message, User_info user) {
        this.message = message;
        this.user = user;
    }

    public  User_info getUser() {
        return user;
    }

    public void setUser(User_info user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "login_response{" +
                "message='" + message + '\'' +
                ", user=" + user +
                '}';
    }
}
