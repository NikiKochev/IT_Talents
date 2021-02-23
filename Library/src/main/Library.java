package main;

import main.readingMater.CantTakeException;
import main.readingMater.ReadingMater;
import main.readingMater.Type;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class Library {

    private double money;
    private HashMap<String, HashMap<Type, TreeMap<String, ReadingMater>>> catalogue;
    private ConcurrentHashMap<ReadingMater, TreeMap<LocalDateTime, LocalDateTime>> chronology;
    private ConcurrentHashMap<ReadingMater, Double> taxes;


    public Library(double money) {
        this.money = money;
        catalogue = new HashMap<>();
        chronology = new ConcurrentHashMap<>();
        taxes = new ConcurrentHashMap<>();
    }

    public void addReadingMater(ReadingMater book){
        if(!this.catalogue.containsKey(book.getKind())){
            catalogue.put(book.getKind(), new HashMap<>());
        }
        if(!this.catalogue.get(book.getKind()).containsKey(book.getType())){
            catalogue.get(book.getKind()).put(book.getType(),new TreeMap<>());
        }
        catalogue.get(book.getKind()).get(book.getType()).put(book.getName(),book);
    }

    public synchronized ReadingMater rentABook (String name, String publisher) {
        try {
            ReadingMater book = null;
            for (String kind : catalogue.keySet()) {
                for (Type type : catalogue.get(kind).keySet()) {
                    for (String nameOfBook : catalogue.get(kind).get(type).keySet()) {
                        if (name.equalsIgnoreCase(nameOfBook)) {
                            if (publisher.equalsIgnoreCase(catalogue.get(kind).get(type).get(nameOfBook).getPublisher())) {
                                book = catalogue.get(kind).get(type).get(nameOfBook);
                            }
                        }
                    }
                }
            }
            if (book == null) {
                throw new MissingException();
            }
            catalogue.get(book.getKind()).get(book.getType()).remove(book.getName());
            if (!chronology.containsKey(book)) {
                chronology.put(book, new TreeMap<>());
            }
            try {
                chronology.get(book).put(LocalDateTime.now(), LocalDateTime.now().plus(book.getRentDuration()));
            } catch (CantTakeException e) {
                catalogue.get(book.getKind()).get(book.getType()).put(book.getName(), book);
                System.out.println(e.getMessage());
                return null;
            }
            taxes.put(book, book.taxForRent());
            book.taken();
            return book;
        }catch (MissingException m){
            System.out.println("book is not found");
         return null;
        }
    }
    public void increaseTax(ReadingMater book){
        taxes.put(book, taxes.get(book)*1.01);
    }

    public void returnABook(ReadingMater book, Person person){
        synchronized (this) {
            catalogue.get(book.getKind()).get(book.getType()).put(book.getName(), book);
        }
        double tax = taxes.get(book);
        person.payMoney(tax);
        this.resiveMoney(tax);
        book.returned();
    }

    private void resiveMoney(double tax) {
        this.money+=tax;
    }

}
