package by.fixprice.utils;

public class ApiUser {
    private String password;
    private String email;
    private String phone;

    public ApiUser(String password, String email, String phone) {
        if (password != null) {
            this.password = "\"" + password + "\"";
        } else this.password = null;

        if (email != null) {
            this.email = "\"" + email + "\"";
        } else this.password = null;

        if (phone != null) {
            this.phone = "\"" + phone + "\"";
        } else this.password = null;
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
}
