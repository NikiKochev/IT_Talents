package main.cake;

import main.util.Validator;

public class SpecialCake extends Cake implements Comparable<Cake>{

    public enum SpecialType implements IType{
        ANNIVERSARY,
        COMPANY,
        ADVERTISING;
    }

    private String event;

    public SpecialCake(String name, String description, double price, int pieces, SpecialType type, String event) {
        super(name, description, price, pieces, type);
        if(Validator.validString(event)){
            this.event = event;
        }
        else {
            this.event = "ANNIVERSARY";
        }
    }

    @Override
    public int compareTo(Cake o) {
        return Double.compare(o.getPrice(),this.getPrice());
    }

    @Override
    protected int compareByType() {
        return 3;
    }


}
