package main.candidate;

import main.electionCampaign.CriminalCampaign;
import main.electionCampaign.ElectionCampaign;
import main.electionCampaign.NormalCampaign;

import java.util.Random;

public class Politician extends Candidate{

    public Politician(String name, int moneyForCampaign, HigherEducation education) {
        super(name, moneyForCampaign, education);
    }

    @Override
    protected ElectionCampaign returnTypeCampaing(int days, int moneyForCampaign) {
        if(new Random().nextBoolean()){
            return new NormalCampaign(days,moneyForCampaign);
        }
        return new CriminalCampaign(days,moneyForCampaign);
    }
}
