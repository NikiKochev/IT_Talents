package main.person;

import main.util.RandomMethods;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class PrivateClient extends Client{
    public static final int MAXIMUM_VOUCHERS = 4;
    Queue<Integer> vouchers = new LinkedList<>();

    public PrivateClient(String name, String phone, String address) {
        super(name, phone, address);
        this.randomVouchers();
    }

    @Override
    protected int tip() {
        return 2;
    }

    @Override
    protected double calculateDiscount(double priceForAll) {
        int voucherDiscount = 0;
        while (vouchers.peek()!=null){
            voucherDiscount += vouchers.poll();
        }
        return priceForAll-= voucherDiscount;
    }

    @Override
    protected boolean validationNumOfCakes(int size) {
        if(size>0 && size <4){
            return true;
        }
        return false;
    }

    private void randomVouchers() {
        int randomNumberOfVouchers = new Random().nextInt(MAXIMUM_VOUCHERS+1);
        for (int i = 0; i <randomNumberOfVouchers ; i++) {
            this.vouchers.add(RandomMethods.randomNumber(10,30));
        }
    }
}
