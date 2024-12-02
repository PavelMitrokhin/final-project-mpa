package by.fixprice.api.responses;

public class LoginResponse {
    public static final String ERROR_INVALID_LOGIN_OR_PASSWORD = "Неверный логин или пароль. Проверьте введённые данные и попробуйте снова. Осталось попыток:";
    public static final String WARNING_LOGIN_LIMITS_EXCEEDED = "Лимит попыток превышен. Повторите попытку входа через 10 мин. или восстановите пароль.";
    public static final String ERROR_VALIDATION = "Ошибка валидации";
    public static final String ERROR_EMAIL_OR_PHONE_REQUIRED = "Требуется указать телефон или email";
    public static final String ERROR_PASSWORD_REQUIRED = "Требуется указать пароль";
    public static final String ERROR_EMAIL_REQUIRED = "Требуется указать email";
    public static final String ERROR_PHONE_REQUIRED = "Требуется указать телефон";
    public static final String ERROR_ENTER_CORRECT_PHONE = "Укажите корректный номер телефона";
    public static final String ERROR_ENTER_CORRECT_EMAIL = "Укажите корректный email";
    public static final String ERROR_FUNCTIONALITY_UNAVAILABLE = "Функционал недоступен. Пожалуйста, обновите приложение";
    public static final String ERROR_TOO_MANY_QUERIES = "Слишком много запросов";

}