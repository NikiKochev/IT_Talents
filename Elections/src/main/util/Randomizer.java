package main.util;

import main.City;
import main.candidate.*;
import main.voter.HighClassVoter;
import main.voter.IgnorantVoter;
import main.voter.MiddleClassVoter;
import main.voter.Voter;

import java.awt.font.NumericShaper;
import java.util.Random;

public class Randomizer {
    public static final String[] NAMES ={"gogo","pesho","gosho"};
    public static Voter getRandomVolter(boolean b, Candidate candidate) {
        switch (new Random().nextInt(3)){
            case 1: return new HighClassVoter(randdomName(),new Random().nextBoolean(),candidate,b,randomCity());
            case 2: return new MiddleClassVoter(randdomName(),new Random().nextBoolean(),candidate,b,randomCity());
            default: return new IgnorantVoter(randdomName(),new Random().nextBoolean(),candidate,b,randomCity());
        }
    }

    private static City randomCity() {
        switch (new Random().nextInt(4)){
            case 1: return City.BURGAS;
            case 2: return City.PLOVDIV;
            case 3: return City.SOFIA;
            default: return City.VARNA;
        }
    }

    private static String randdomName() {
        return NAMES[new Random().nextInt(NAMES.length)];
    }

    public static Candidate randomCandidate() {
        switch (new Random().nextInt(3)){
            case 1:return new CriminalBoss(randdomName(),new Random().nextInt(250000)+50000,
                    new Random().nextBoolean() ? Education.PRIMARY_EDUCATION :Education.WITHOUT);
            case 2: return new Politician(randdomName(),new Random().nextInt(250000)+50000,
                    new Random().nextBoolean() ? HigherEducation.HIGH_SCHOOL:HigherEducation.UNIVERSITY);
            default: return new Showman(randdomName(),new Random().nextInt(250000)+50000,randomEdication());
        }
    }

    private static IEducation randomEdication() {
        switch (new Random().nextInt(4)){
            case 1: return  Education.PRIMARY_EDUCATION;
            case 2: return Education.WITHOUT;
            case 3: return HigherEducation.HIGH_SCHOOL;
            default: return HigherEducation.UNIVERSITY;
        }
    }


}
