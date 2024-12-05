package by.fixprice.utils;

public class User {
    private String password;
    private String email;
    private String phone;
    private String login;

    public User(String password, String email, String phone) {
        if (password != null) {
            this.password = "\"" + password + "\"";
        } else this.password = null;

        if (email != null) {
            this.email = "\"" + email + "\"";
        } else this.email = null;

        if (phone != null) {
            this.phone = "\"" + phone + "\"";
        } else this.phone = null;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public String toString() {
        return "ApiUser{" +
                "password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
