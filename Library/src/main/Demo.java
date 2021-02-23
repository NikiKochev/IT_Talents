package main;

import main.readingMater.Book;
import main.readingMater.BookType;
import main.readingMater.ReadingMater;

public class Demo {
    public static void main(String[] args) {
        Library library = new Library(100);
        ReadingMater book = new Book("ohop", "gogo","izida","1990", BookType.ФЕНТАЗИ,library);
        //ToDo add Books to Library
        Person x =new Person(100,library);
        x.rentABook("ohop","izida");

    }
}
