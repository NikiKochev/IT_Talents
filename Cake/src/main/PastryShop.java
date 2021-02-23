package main;

import main.cake.Cake;
import main.person.Deliver;
import main.util.RandomMethods;
import main.util.Validator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class PastryShop {

    private String name;
    private String address;
    private String phoneNumber;
    private double money;
    private ArrayList<Cake> cakes = new ArrayList();
    private HashSet<Deliver> delivers = new HashSet();


    public PastryShop(String name, String address, String phoneNumber) {
        if(Validator.validString(name)) {
            this.name = name;
        }
        else{
            this.name = RandomMethods.randomName();
        }
        if(Validator.validString(address)) {
            this.address = address;
        }
        else {
            this.address = RandomMethods.randomAddress();
        }
        if(Validator.validPhone(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        }
        else{
            this.phoneNumber = RandomMethods.randomPhoneNumber();
        }
        this.createACakes();
        this.hireDelivers();
        this.money = 0;
    }

    private void createACakes() {
        for (int i = 0; i < 30; i++) {
            cakes.add(RandomMethods.createRandomCake());
        }
        cakes.sort(Cake::typeComparing);
    }
    private void hireDelivers(){
        for (int i = 0; i < 5; i++) {
            delivers.add(RandomMethods.createRandomDelivery());
        }
    }

    public ArrayList<Cake> haveThisCake(ArrayList<Cake> cakes) {


        this.cakes.removeAll(cakes);
        return cakes;
    }

    public Deliver sendRandomDeliver() {
        ArrayList<Deliver> x = new ArrayList<>();
        x.addAll(this.delivers);
        return x.get(new Random().nextInt(x.size()));
    }

    public void takePayment(double priceForAll) {
        this.money+=priceForAll;
    }

    public void printCakes() {
        cakes.sort(Cake::typeComparing);
        for (Cake x:cakes) {
            System.out.println(x);
        }
    }

    public double getMoney() {
        return this.money;
    }

    public HashSet<Deliver> getDelivers() {
        return delivers;
    }
}
