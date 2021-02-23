package main.person;

import main.Agency;
import main.property.Property;
import main.util.Validator;

public class Seller extends Client{

    private Property property;

    public Seller(String name, String phone, Property property, double money) {
        super(name, phone, money);
        if(property != null){
            this.property = property;
        }
        else {
            this.property = Validator.randomProperty();
        }
        property.setOwner(this);
    }

    public Property getProperty() {
        return property;
    }
// за тестване дали работи правилно
    @Override
    public String toString() {
        return super.toString() + property ;
    }

    @Override
    public void registration(Agency agency) {
        agency.registrationFormForSellers(this.property);
    }
}
