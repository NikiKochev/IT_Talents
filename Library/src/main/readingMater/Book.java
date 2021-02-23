package main.readingMater;

import main.Library;

import java.time.Duration;

public class Book extends ReadingMater{

    private String writer;

    public Book(String name, String writer, String publisher, String dateOfIssue, BookType type, Library library) {
        super(name, publisher, dateOfIssue, type, library);
        this.writer = writer;
    }

    @Override
    public Duration getRentDuration() throws CantTakeException {
        return Duration.ofSeconds(2);
    }

    @Override
    public double taxForRent() {
        return 3;
    }

    @Override
    public String getKind() {
        return "Book";
    }
}
