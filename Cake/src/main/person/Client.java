package main.person;

import main.Order;
import main.PastryShop;
import main.cake.Cake;

import java.util.ArrayList;

public abstract class Client extends Person {

    private String address;

    public Client(String name, String phone, String address) {
        super(name, phone);
    }

    public void makeAnOrder(ArrayList<Cake> cakes, PastryShop pastryShop){
        if(this.validationNumOfCakes(cakes.size())){
            cakes = pastryShop.haveThisCake(cakes);
            Deliver x= pastryShop.sendRandomDeliver();
            double priceForAll = 0 ;
            for (Cake current: cakes) {
                priceForAll += current.getPrice();
            }
            Order curentOrder = new Order(this,priceForAll,this.address,cakes);
            x.addOrder(curentOrder);
            priceForAll = this.calculateDiscount(priceForAll);
            double tip = priceForAll/100 * this.tip();
            pastryShop.takePayment(priceForAll);
            x.takeATip(tip);
        }
    }

    protected abstract int tip();

    protected abstract double calculateDiscount(double priceForAll);

    protected abstract boolean validationNumOfCakes(int size);
}
