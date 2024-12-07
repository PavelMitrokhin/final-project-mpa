package by.fixprice.utils;

public class ApiUsers {
    public String randomPassword = GenerationDataUtil.generatePassword();
    public String randomPhone = GenerationDataUtil.generateBelarusMobilePhone("+375");
    public String randomEmail = GenerationDataUtil.generateEmail();
    public String randomIncorrectLogin = GenerationDataUtil.generatePassword();

    public User getAllNullUser() {
        return new User(null, null, null);
    }

    public User getAllEmptyUser() {
        return new User("", "", "");
    }

    public User getEmptyEmailAndPasswordUser() {
        return new User("", "", null);
    }

    public User getEmptyPhoneAndPasswordUser() {
        return new User("", null, "");
    }

    public User getPhoneWithoutPasswordUser(){
        return new User("", null, randomPhone);
    }

    public User getEmailWithNullPasswordUser(){
        return new User(null, randomEmail, null);
    }

    public User getIncorrectEmailWithPasswordUser(){
        return new User(randomPassword, randomIncorrectLogin, null);
    }

    public User getIncorrectPhoneWithPasswordUser(){
        return new User(randomPassword, null, randomIncorrectLogin);
    }

    public User getValidEmailUser() {
        return new User(randomPassword, randomEmail, null);
    }

    public User getValidPhoneUser() {
        return new User(randomPassword, null, randomPhone);
    }

    public User getPasswordEmailPhoneUser(){
        return new User(randomPassword, randomEmail, randomPhone);
    }
}
