package main.candidate;

import main.electionCampaign.CriminalCampaign;
import main.electionCampaign.ElectionCampaign;

public class CriminalBoss extends Candidate {
    public CriminalBoss(String name, int moneyForCampaign, Education education) {
        super(name, moneyForCampaign, education);
    }

    @Override
    protected ElectionCampaign returnTypeCampaing(int days, int moneyForCampaign) {
        return new CriminalCampaign(days,moneyForCampaign);
    }
}
