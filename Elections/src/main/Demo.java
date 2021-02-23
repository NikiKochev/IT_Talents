package main;

import main.candidate.Candidate;
import main.util.Randomizer;

import java.util.Random;

public class Demo {
    public static void main(String[] args) {
        CenElComm cik = new CenElComm();
        Candidate[] candidates = new Candidate[10];
        for (int i = 0; i < candidates.length; i++) {
            candidates[i]= Randomizer.randomCandidate();
        }
        for (int i = 0; i < candidates.length; i++) {
            candidates[i].startCampaign(new Random().nextInt(6)+20);
        }
        for (int i = 0; i < candidates.length; i++) {
            candidates[i].registration(cik);
        }
        cik.votingBegins();
    }
}
