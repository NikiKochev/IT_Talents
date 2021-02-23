package main.readingMater;

import main.Library;

import java.time.Duration;

public class TextBook extends ReadingMater{

    private String writer;

    public TextBook(String name, String writer, String publisher, String dateOfIssue, TextbookType type, Library library) {
        super(name, publisher, dateOfIssue, type, library);
        this.writer =writer;
    }

    @Override
    public Duration getRentDuration() throws CantTakeException {
        return Duration.ofSeconds(3);
    }

    @Override
    public double taxForRent() {
        return 2;
    }

    @Override
    public String getKind() {
        return "Textbook";
    }
}
