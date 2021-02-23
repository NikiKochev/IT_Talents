package main.property;


public class Plat extends Property{

    public enum TypeOfPlat implements Type {
        Forest,
        Niva,
        Field;
    }

    private boolean  isInRegulation;

    public Plat(String description, String address, double price, int area, TypeOfPlat type, boolean isInRegulation) {
        super(description, address, price, area, type);
        this.isInRegulation  = isInRegulation;
    }

    @Override
    protected int type() {
        return 2;
    }
}
