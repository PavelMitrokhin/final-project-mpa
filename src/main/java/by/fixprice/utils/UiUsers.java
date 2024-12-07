package by.fixprice.utils;

public class UiUsers {
    public String randomPassword = GenerationDataUtil.generatePassword();
    public String randomPhone = GenerationDataUtil.generateBelarusMobilePhone();
    public String randomEmail = GenerationDataUtil.generateEmail();
    public String randomIncorrectLogin = GenerationDataUtil.generatePassword();

    public User getEmailAndPasswordUser(){
        return new User(randomEmail, randomPassword);
    }

    public User getPhoneAndPasswordUser(){
        return new User(randomPhone, randomPassword);
    }

    public User getIncorrectEmailUser(){
        return new User(randomIncorrectLogin, randomPassword);
    }
}
