package main.person;

import main.Agency;
import main.Inspection;
import main.property.Property;
import main.util.Validator;

import java.util.ArrayList;
import java.util.HashMap;


public class Buyer extends Client{

    private HashMap<Inspection, Property> inspections = new HashMap();
    private Agent agent;

    public Buyer(String name, String phone, double money) {
        super(name, phone, money);
    }

    @Override
    public void registration(Agency agency) {
       this.agent = agency.registrationFormForBuyers(this);
    }

    public boolean inspectionView(Property property){
        if(this.getMoney() > property.getPrice()){
            Inspection forHome = new Inspection(property, this.agent, this);
            this.inspections.put(forHome,property);
            this.agent.addInspection(forHome);
            property.addAgents(agent);
            return true;
        }
       return false;
    }

    public void buyProperty(Property property, Agency agency){
        if(inspections.containsValue(property)){
            agency.getMoneyForProperty(this.pay(property.getPrice()),property,this.agent);
            property.setOwner(this);
// за проба:
//            System.out.println("купи жилище");
        }
    }

    private double pay(double price) {
        double payment = price*1.03;
        this.makePayment(payment);
        return payment;
    }

    // за тестване дали работи правилно
    public String getInspection() {
        return this.inspections.toString();
    }

    public Property randomProperty() {
        ArrayList<Property> wild = new ArrayList<>();
        wild.addAll(inspections.values());
        return wild.get(Validator.randomInt(0,wild.size()-1));
    }
}
