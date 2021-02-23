package main.property;

import main.util.Validator;

public class House extends Property {

    public enum TypeOfHouse implements Type{
        FlorOfHouse,
        AllHouse;
    }

    private int numberOfParkingPlaces;
    private TypeOfConstruction typeOfConstruction;
    private int areaOfYard;

    public House(String description, String address, double price, int area, TypeOfHouse type, TypeOfConstruction typeOfConstruction,
                 int numberOfParkingPlaces,int areaOfYard) {
        super(description, address, price, area, type);
        this.typeOfConstruction = typeOfConstruction;
        if(Validator.validInt(numberOfParkingPlaces)){
            this.numberOfParkingPlaces = numberOfParkingPlaces;
        }
        else {
            this.numberOfParkingPlaces = 0;
        }
        if(Validator.validInt(areaOfYard)){
            this.areaOfYard = areaOfYard;
        }
        else {
            this.areaOfYard = 1000;
        }
    }

    @Override
    protected int type() {
        return 1;
    }
}
