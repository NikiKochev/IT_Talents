package main;

import main.person.Agent;
import main.person.Buyer;
import main.property.Property;
import java.time.LocalDate;


public class Inspection {
    private Property property;
    private Agent agent;
    private Buyer buyer;
    private LocalDate date;


    public Inspection(Property property, Agent agent,Buyer buyer) {
        this.property = property;
        this.agent = agent;
        this.buyer = buyer;
        this.date = LocalDate.now();
    }




}
