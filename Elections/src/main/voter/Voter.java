package main.voter;

import main.City;
import main.candidate.Candidate;
import main.util.Validator;

import java.util.*;

public abstract class Voter {
    private String name;
    private boolean isMan;
    private City city;
    private Candidate candidate;
    private boolean isItBribed;
    private boolean isTheBallotValid;

    public Voter(String name, boolean isMan, Candidate candidate, boolean isItBribed, City city) {
        if(Validator.validName(name)) {
            this.name = name;
        }
        else{
            this.name = "Ivan Ivanov";
        }
        this.isMan = isMan;
        this.candidate = candidate;
        this.isItBribed = isItBribed;
        this.city = city;
        this.isTheBallotValid= false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voter voter = (Voter) o;
        return isMan == voter.isMan &&
                isItBribed == voter.isItBribed &&
                Objects.equals(name, voter.name) &&
                city == voter.city;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, isMan, city, isItBribed);
    }

    public City getCity() {
        return city;
    }

    public boolean isTheBallotValid() {
        return isTheBallotValid;
    }
    public Candidate vote(ArrayList<Candidate> listOfCandidate){
        if(new Random().nextInt(10)+1 <= this.getChance() ){
            this.isTheBallotValid = true;
            return null;
        }
        if( new Random().nextInt(100)+1 <= this.isItVoteRate()){
            return null;
        }
        if(new Random().nextInt(100)+1 <= this.VoteForSomeOneElse()){
            return listOfCandidate.get(new Random().nextInt(listOfCandidate.size()));
        }
        return this.candidate;
    }

    public boolean isItBribed() {
        return isItBribed;
    }

    protected abstract int VoteForSomeOneElse();

    protected abstract int isItVoteRate();

    protected abstract int getChance();
}
