package main.voter;

import main.City;
import main.candidate.Candidate;

public class IgnorantVoter extends Voter {
    public IgnorantVoter(String name, boolean isMan, Candidate candidate, boolean isItBribed, City city) {
        super(name, isMan, candidate, isItBribed, city);
    }

    @Override
    protected int VoteForSomeOneElse() {
        return 10;
    }

    @Override
    protected int isItVoteRate() {
        return 10;
    }

    @Override
    protected int getChance() {
        return 4;
    }
}
