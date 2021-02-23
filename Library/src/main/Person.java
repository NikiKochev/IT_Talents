package main;

import main.readingMater.ReadingMater;

public class Person {

    private double money;
    private Library library;

    public Person(double money, Library library) {
        this.money = money;
        this.library = library;
    }

    public void rentABook(String name, String publisher){
        Thread rentBook = new Thread(()->{
            try {
                ReadingMater book = library.rentABook(name, publisher);
                Thread.sleep(1000);
                library.returnABook(book, this);
            }
            catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        });

    }

    public void payMoney(double tax) {
        this.money-=tax;
    }
}
