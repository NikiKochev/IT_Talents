package main.cake;

public class StandardCake extends Cake implements Comparable<Cake>{

    public enum StandardType implements IType{
        BISCUIT,
        ECLAIR,
        FRUIT,
        CHOCOLATE;
    }

    private boolean isItSyrup;

    public StandardCake(String name, String description, double price, int pieces, StandardType type, boolean isItSyrup) {
        super(name, description, price, pieces, type);
    }

    @Override
    public int compareTo(Cake o) {
        return Double.compare(o.getPrice(),this.getPrice());
    }

    @Override
    protected int compareByType() {
        return 1;
    }

}
