package main;

import main.person.Agent;
import main.person.Buyer;
import main.property.Property;
import main.util.Validator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class Agency {

    private String name;
    private String phoneNumber;
    private String address;
    private double money;
    private HashSet<Agent> agents = new HashSet();
    private TreeSet<Property> properties = new TreeSet();

    public Agency(String name, String phoneNumber, String address) {
        if(Validator.validAddress(name)){
            this.name = name;
        }
        else {
            this.name = " talant";
        }
        if(Validator.validAddress(address)){
            this.address= address;
        }
        else {
            this.address = "plovdiv";
        }
        this.phoneNumber = Validator.validPhone(phoneNumber);

        for (int i = 0; i < 5 ; i++) {
            agents.add(new Agent("agent "+i,"089912332"+i,0));
        }
        this.money =0;
    }


    public void registrationFormForSellers(Property property) {
        properties.add(property);
    }

    public Agent registrationFormForBuyers(Buyer buyer) {
        Agent random = this.takeRandomAgent();
        random.addBuyer(buyer);
        return random;
    }

    private Agent takeRandomAgent() {
        ArrayList<Agent> current= new ArrayList();
        current.addAll(agents);
        return current.get(Validator.randomInt(0,current.size()-1));
    }

    public void getMoneyForProperty(double payment, Property property, Agent agent) {
        double agentCommission = (payment - (payment*0.97))/2;
        double agencyCommission = (payment - (payment*0.97))/2;
        agent.takePayment(agentCommission);
        this.resivePayment(agencyCommission);
        payment -= agencyCommission + agentCommission;
        property.getOwner().takePayment(payment*0.97);
        payment -= payment*0.97;
        agent.takePayment(payment/2);
        this.resivePayment(payment/2);
        agent.addSeller(property.getOwner());
        properties.remove(property);

    }

    private void resivePayment(double payment) {
        this.money += payment;
    }

    public TreeSet<Property> getProperties() {
        return properties;
    }

    public Property randomPropertyFromCataloge() {
        ArrayList<Property> current = new ArrayList<>();
        current.addAll(this.properties);
        return current.get(Validator.randomInt(0,current.size()-1));
    }

    public double getMoneyBalance() {
        return this.money;
    }

    public void getMoneyBalanceForAgents() {
        TreeSet<Agent> wild = new TreeSet<>((o1, o2) -> Double.compare(o2.getMoney(),o1.getMoney()));
        wild.addAll(agents);
        for (Agent a :wild) {
            System.out.println(a);
        }
    }
}
