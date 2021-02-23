package main;

public class MissingException extends Exception {

    MissingException(){
        super("Book Not Found");
    }
}
