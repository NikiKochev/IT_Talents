package main.util;

public abstract class Validator {

    public static boolean validName(String name) {
        if(name != null && name.length() > 0){
            return true;
        }
        return false;
    }
}
