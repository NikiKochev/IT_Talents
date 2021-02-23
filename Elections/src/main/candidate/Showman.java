package main.candidate;

import main.electionCampaign.ElectionCampaign;
import main.electionCampaign.NormalCampaign;

public class Showman extends Candidate{
    public Showman(String name, int moneyForCampaign, IEducation education) {
        super(name, moneyForCampaign, education);
    }

    @Override
    protected ElectionCampaign returnTypeCampaing(int days, int moneyForCampaign) {
        return new NormalCampaign(days,moneyForCampaign);
    }
}
