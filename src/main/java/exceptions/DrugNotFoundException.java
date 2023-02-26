package exceptions;


public class DrugNotFoundException extends RuntimeException{
    public DrugNotFoundException(String message) {
        super("Данного препарата нет в наличии");
    }
}
