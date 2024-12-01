package by.fixprice.utils;

public class ApiUsers {
    public String randomPassword = GenerationDataUtil.generatePassword();
    public String randomPhone = GenerationDataUtil.generateBelarusMobilePhone();
    public String randomEmail = GenerationDataUtil.generateEmail();
    public String randomIncorrectLogin = GenerationDataUtil.generatePassword();

    public ApiUser getAllNullUser() {
        return new ApiUser(null, null, null);
    }

    public ApiUser getAllEmptyUser() {
        return new ApiUser("", "", "");
    }

    public ApiUser getEmptyEmailAndPasswordUser() {
        return new ApiUser("", "", null);
    }

    public ApiUser getEmptyPhoneAndPasswordUser() {
        return new ApiUser("", null, "");
    }

    public ApiUser getPhoneWithoutPasswordUser(){
        return new ApiUser("", null, randomPhone);
    }

    public ApiUser getEmailWithNullPasswordUser(){
        return new ApiUser(null, randomEmail, null);
    }

    public ApiUser getIncorrectEmailWithPasswordUser(){
        return new ApiUser(randomPassword, randomIncorrectLogin, null);
    }

    public ApiUser getIncorrectPhoneWithPasswordUser(){
        return new ApiUser(randomPassword, null, randomIncorrectLogin);
    }

    public ApiUser getValidEmailUser() {
        return new ApiUser(randomPassword, randomEmail, null);
    }

    public ApiUser getValidPhoneUser() {
        return new ApiUser(randomPassword, null, randomPhone);
    }

    public ApiUser getPasswordEmailPhoneUser(){
        return new ApiUser(randomPassword, randomEmail, randomPhone);
    }
}
