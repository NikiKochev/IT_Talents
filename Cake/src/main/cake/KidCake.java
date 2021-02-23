package main.cake;

import main.util.RandomMethods;
import main.util.Validator;

public class KidCake extends Cake implements Comparable<Cake>{

    public enum KidType implements IType{
        FOR_A_BIRTHDAY,
        FOR_A_BAPTISM,
        FOR_A_FORERUNNER;

    }

    private String nameOfKid;

    public KidCake(String name, String description, double price, int pieces, KidType type, String nameOfKid) {
        super(name, description, price, pieces, type);
        if(Validator.validString(nameOfKid)){
            this.nameOfKid = nameOfKid;
        }
        else {
            this.nameOfKid = RandomMethods.randomName();
        }
    }

    @Override
    public int compareTo(Cake o) {
        return this.getPieces() - o.getPieces();
    }

    @Override
    protected int compareByType() {
        return 4;
    }
}
