package main.candidate;

import main.CenElComm;
import main.electionCampaign.ElectionCampaign;
import main.util.Validator;

import java.util.Objects;

public abstract class Candidate {

    private String name;
    private int moneyForCampaign;
    private ElectionCampaign electionCampaign;
    private IEducation education;

    public Candidate(String name, int moneyForCampaign, IEducation education) {
        if(Validator.validName(name)) {
            this.name = name;
        }
        else{
            this.name = "Jorge Ganchev";
        }
        if(moneyForCampaign >= 50000 && moneyForCampaign <= 300000) {
            this.moneyForCampaign = moneyForCampaign;
        }
        this.education = education;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return moneyForCampaign == candidate.moneyForCampaign &&
                Objects.equals(name, candidate.name) &&
                Objects.equals(education, candidate.education);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, moneyForCampaign, education);
    }

    public void startCampaign(int days){
        this.electionCampaign = this.returnTypeCampaing(days,moneyForCampaign);
        this.electionCampaign.conductingAnElectionCampaign(this);
    }

    public void registration(CenElComm cik){
        cik.gerstrationNewCandidate(this.electionCampaign.getVoters(),this);
    }

    protected abstract ElectionCampaign returnTypeCampaing(int days, int moneyForCampaign);

    public String getName() {
        return this.name;
    }
}
