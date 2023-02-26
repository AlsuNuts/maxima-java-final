package exceptions;


public class PharmacyNotFoundException extends RuntimeException{
    public PharmacyNotFoundException(String message) {
        super("В данную аптеку нельзя доставить заказ");
    }
}
