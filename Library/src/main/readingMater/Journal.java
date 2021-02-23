package main.readingMater;

import main.Library;

import java.time.Duration;

public class Journal extends ReadingMater{

    private int number;
    public Journal(String name, int number, String publisher, String dateOfIssue, JournalType type, Library library) {
        super(name, publisher, dateOfIssue, type, library);
        this.number = number;
    }

    @Override
    public Duration getRentDuration() throws CantTakeException{
        throw new CantTakeException();
    }

    @Override
    public double taxForRent() {
        return 0;
    }

    @Override
    public String getKind() {
        return "Journal";
    }
}
