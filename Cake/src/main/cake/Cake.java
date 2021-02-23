package main.cake;

import main.util.RandomMethods;
import main.util.Validator;

public abstract class Cake {

    private String name;
    private String description;
    private double price;
    private int pieces;
    private IType type;

    public Cake(String name, String description, double price, int pieces, IType type) {
        if(Validator.validString(name)) {
            this.name = name;
        }
        else {
            this.name = RandomMethods.randomName();
        }
        if(Validator.validString(description)) {
            this.description = description;
        }
        else {
            this.description = RandomMethods.randomDescription();
        }
        if(Validator.validPrice(price)) {
            this.price = price;
        }
        else {
            this.price = RandomMethods.randomMoney();
        }
        if(Validator.validPieces(pieces)) {
            this.pieces = pieces;
        }
        else {
            this.price = RandomMethods.randomNumber(6,100);
        }
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public int getPieces() {
        return pieces;
    }
    public int typeComparing(Cake o){
        if(this.compareByType() == o.compareByType()){
           return this.compareTo(o);
        }
        return this.compareByType()-o.compareByType();
    }


    public abstract int compareTo(Cake o);

    protected abstract int compareByType();

    @Override
    public String toString() {
        String kind;
        switch (this.compareByType()){
            case 1: kind ="Standart Cake";
            break;
            case 2: kind = "Wedding Cake";
            break;
            case 3: kind = "Special Cake";
            break;
            default: kind = "Kid Cake";
        }
        return kind +" "+ type +" price is:"+ price + "and this cake have "+ pieces+" pieces";
    }
}
