package main.electionCampaign;

import main.candidate.Candidate;
import main.util.Randomizer;
import main.voter.Voter;

import java.util.HashSet;
import java.util.Random;

public abstract class ElectionCampaign {
    private int numberOfDays;
    private int budget;
    private HashSet<Voter> voters;

    public ElectionCampaign(int numberOfDays, int budget) {
        if(numberOfDays>=20 && numberOfDays<=25) {
            this.numberOfDays = numberOfDays;
        }
        else {
            this.numberOfDays= 23;
        }
        if(budget >= 50000 && budget <=300000) {
            this.budget = budget;
        }
        else {
            this.budget = 200000;
        }
    }

    public void conductingAnElectionCampaign(Candidate candidate){
        this.voters = new HashSet<>();
        for (int i = 0; i < numberOfDays; i++) {
            this.findNewVoters(candidate);
        }
    }

    private void findNewVoters(Candidate candidate) {
        for (int i = 0; i < howManyVoltersCanFind(); i++) {
            voters.add(Randomizer.getRandomVolter(false,candidate));
        }
        if(this.canBuyVolters()){
            for (int i = 0; i < this.howManyCanBuy(); i++) {
                int bribery = new Random().nextInt(21)+30;
                if(this.budget >= bribery){
                    voters.add(Randomizer.getRandomVolter(true,candidate));
                    this.budget-=bribery;
                }
            }
        }
    }

    protected abstract int howManyCanBuy();

    protected abstract boolean canBuyVolters();

    protected abstract int howManyVoltersCanFind();

    public HashSet<Voter> getVoters() {
        HashSet<Voter> forCik = new HashSet<>();
        forCik.addAll(this.voters);
        return forCik;
    }
}
