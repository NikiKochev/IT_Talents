package main.electionCampaign;

public class NormalCampaign extends ElectionCampaign{
    public static final int VOTERS_PER_DAY = 100;
    public NormalCampaign(int numberOfDays, int budget) {
        super(numberOfDays, budget);
    }

    @Override
    protected int howManyCanBuy() {
        return 0;
    }

    @Override
    protected boolean canBuyVolters() {
        return false;
    }

    @Override
    protected int howManyVoltersCanFind() {
        return VOTERS_PER_DAY;
    }

    // генерира по 100 човека на ден
}
