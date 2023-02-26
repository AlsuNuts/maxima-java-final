package exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super("Ошибка. Вы ввели неверные данные авторизации");
    }
}
