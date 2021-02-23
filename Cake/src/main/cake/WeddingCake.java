package main.cake;

import main.util.RandomMethods;

public class WeddingCake extends Cake implements Comparable <Cake> {

    public enum WeddingType implements IType{
        BIG,
        MEDIUM,
        SMALL;
    }

    private int floors;

    public WeddingCake(String name, String description, double price, int pieces, WeddingType type, int floors) {
        super(name, description, price, pieces, type);
        if(floors > 0 && floors <5){
            this.floors = floors;
        }
        else {
            this.floors = RandomMethods.randomNumber(1,5);
        }
    }


    @Override
    public int compareTo(Cake o) {
        return this.getPieces() - o.getPieces();
    }

    @Override
    protected int compareByType() {
        return 2;
    }

}
