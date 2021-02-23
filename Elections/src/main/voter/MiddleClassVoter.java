package main.voter;

import main.City;
import main.candidate.Candidate;

public class MiddleClassVoter extends Voter{
    public MiddleClassVoter(String name, boolean isMan, Candidate candidate, boolean isItBribed, City city) {
        super(name, isMan, candidate, isItBribed, city);
    }

    @Override
    protected int VoteForSomeOneElse() {
        return 30;
    }

    @Override
    protected int isItVoteRate() {
        return 30;
    }

    @Override
    protected int getChance() {
        return 1;
    }
}
