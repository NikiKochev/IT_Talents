package main.person;

public class CorporateClient extends Client {

    public static final int DISCOUNT_RATE = 15;

    public CorporateClient(String name, String phone, String address) {
        super(name, phone, address);
    }

    @Override
    protected int tip() {
        return 5;
    }

    @Override
    protected double calculateDiscount(double priceForAll) {
        return priceForAll-= priceForAll/100 * DISCOUNT_RATE;
    }

    @Override
    protected boolean validationNumOfCakes(int size) {
        if(size > 2 && size < 6){
            return true;
        }
        return false;
    }
}
