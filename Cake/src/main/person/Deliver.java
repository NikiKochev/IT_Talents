package main.person;

import main.Order;

import java.util.HashSet;

public class Deliver extends Person {

    HashSet<Order> orders = new HashSet();
    private double money;

    public Deliver(String name, String phone) {
        super(name, phone);
        this.money = 0;
    }

    public void addOrder(Order currentOrder) {
        this.orders.add(currentOrder);
    }

    public void takeATip(double tip) {
        this.money+=tip;
    }

    public double getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return this.getName() + " "+this.getMoney();
    }
}
