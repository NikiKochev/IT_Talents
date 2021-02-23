package main.electionCampaign;

public class CriminalCampaign extends ElectionCampaign{

    public static final int VOTERS_PER_DAY = 120;

    public CriminalCampaign(int numberOfDays, int budget) {
        super(numberOfDays, budget);
    }

    @Override
    protected int howManyCanBuy() {
        return VOTERS_PER_DAY/2;
    }

    @Override
    protected boolean canBuyVolters() {
        return true;
    }

    @Override
    protected int howManyVoltersCanFind() {
        return VOTERS_PER_DAY/2;
    }

    //генерира по 60 човека на ден + 60 човека ако може да плати(цена на човек 30-50)
}
