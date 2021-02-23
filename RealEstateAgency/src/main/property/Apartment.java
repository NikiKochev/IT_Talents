package main.property;

public class Apartment extends Property {

    public enum TypeOfApartment implements Type{
        Studio,
        OneBedroom,
        TwoBedrooms,
        ThreeBedrooms,
        Penthouse;
    }

    private TypeOfConstruction typeOfConstruction;


    public Apartment(String description, String address, double price, int area, TypeOfApartment type,
                     TypeOfConstruction typeOfConstruction) {
        super(description, address, price, area, type);

       this.typeOfConstruction = typeOfConstruction;
    }

    @Override
    protected int type() {
        return 0;
    }


}
