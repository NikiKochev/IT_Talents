package main.readingMater;

import main.Library;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.TreeMap;

public abstract class ReadingMater {
    private Library library;
    private String name;
    private String publisher;
    private String dateOfIssue;
    private Type type;
    private Thread checker;
    private TreeMap<LocalDateTime, LocalDateTime> register; //-> регистър <взимане, връщане>

    public ReadingMater(String name, String publisher, String dateOfIssue, Type type, Library library) {
        this.name = name;
        this.publisher = publisher;
        this.dateOfIssue = dateOfIssue;
        this.type = type;
        this.register = new TreeMap<>();
        this.library = library;
    }

    public Type getType() {
        return type;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getName() {
        return this.name;
    }

    public void taken() {
        register.put(LocalDateTime.now(),null);
        checker = new Thread(()->{
            try {
                Thread.sleep(getRentDuration().getSeconds());
                while(true){
                    if(Thread.currentThread().isInterrupted()) {
                        return;
                    }
                    Thread.sleep(1000);
                    library.increaseTax(this);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            } catch (CantTakeException e) {
                e.printStackTrace();
                return;
            }
        });
        checker.start();
    }

    public void returned(){
        register.put(register.lastKey(),LocalDateTime.now());
        checker.interrupt();
    }

    public abstract Duration getRentDuration ()throws CantTakeException;
    public abstract double taxForRent();
    public abstract String getKind();


}
