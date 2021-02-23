package main.util;

public abstract class Validator {

    public static boolean validPhone(String phone) {
        if(phone.matches("^(?=(?:[08]){2})(?=[0-9]{10}).*")){
            return true;
        }
        return false;
    }

    public static boolean validString(String name) {
        if(name != null && name.length()>0){
            return true;
        }
        return false;
    }

    public static boolean validPrice(double price) {
        if(price > 0 && price < 5000){
            return true;
        }
        return false;
    }

    public static boolean validPieces(int pieces) {
        if(pieces > 0 && pieces < 100){
            return true;
        }
        return false;
    }
}
