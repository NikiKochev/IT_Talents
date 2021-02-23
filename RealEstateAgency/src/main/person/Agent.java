package main.person;

import main.Inspection;
import java.util.HashSet;

public class Agent extends Person {

    private HashSet<Buyer> buyers =  new HashSet();
    private HashSet<Person> sellers = new HashSet();
    private HashSet<Inspection> inspections = new HashSet();



    public Agent(String name, String phone, double money) {
        super(name, phone, money);
    }

    public void addBuyer(Buyer buyer){
        buyers.add(buyer);
    }

    public void addSeller(Person seller){
        sellers.add(seller);
    }

    public void addInspection(Inspection inspection){
        inspections.add(inspection);
    }
}
