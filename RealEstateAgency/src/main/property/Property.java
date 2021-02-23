package main.property;
import main.person.Agent;
import main.person.Person;
import main.util.Validator;


public abstract class Property implements Comparable<Property> {

    private String description;
    private String address;
    private double price;
    private int area;
    private Type type;
    private Agent agent;
    private Person owner;

    public Property(String description, String address, double price, int area, Type type) {
        if(Validator.validAddress(description)){
            this.description = description;
        }
        else{
            this.description = "mngo qk";
        } if(Validator.validAddress(address)){
            this.address = address;
        }
        else{
            this.description = "Sofia";
        }
        if(Validator.validPrice(price)){
            this.price = price;
        }
        else{
            this.price =1000;
        }
        if (Validator.validInt(area)){
            this.area = area;
        }
        else {
            this.area =50;
        }
        this.type = type;

    }


    public void addAgents(Agent agent){
        if(agent!= null){
            this.agent =agent;
        }
    }

    @Override
    public int compareTo(Property o) {
        if(this.type() == o.type()){
            return Double.compare(this.price,o.price);
        }
        return Integer.compare(o.type(), this.type());
    }

    protected abstract int type();

    public double getPrice() {
        return this.price;
    }

    public Person getOwner() {
        return this.owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return  this.type()+" " +price + "  "+ this.agent ;
    }
}
