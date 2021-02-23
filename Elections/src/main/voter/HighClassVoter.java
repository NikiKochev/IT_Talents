package main.voter;

import main.City;
import main.candidate.Candidate;

public class HighClassVoter extends Voter{
    public HighClassVoter(String name, boolean isMan, Candidate candidate, boolean isItBribed, City city) {
        super(name, isMan, candidate, isItBribed, city);
    }

    @Override
    protected int VoteForSomeOneElse() {
        return 50;
    }

    @Override
    protected int isItVoteRate() {
        return 50;
    }

    @Override
    protected int getChance() {
        return 0;
    }
}
