package by.fixprice.utils;

public class User {
    private String email;
    private String phoneNumber;
    private String password;

    public User(String password, String email, String phoneNumber) {
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;

    }

    public User(String password, String email) {
        this.password = password;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }
}
