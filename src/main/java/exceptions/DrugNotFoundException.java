package exceptions;


public class DrugNotFoundException extends RuntimeException{
    public DrugNotFoundException(String message) {
        super("нет в наличии:" + message);
    }
}
