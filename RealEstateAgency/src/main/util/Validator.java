package main.util;
import main.property.*;

import java.util.ArrayList;
import java.util.Random;

public abstract class Validator {

    public static final String[] NAMES = {"gogo","tosho","mosho","ivan","dragan","petkan","grozdan"};

    public static boolean validAddress(String address){
        if(address != null && address.length()>0){
            return true;
        }
        return false;
    }

    public static boolean validPrice(double money){
        if(money>0){
            return true;
        }
        return false;
    }
    public static boolean validInt(int money){
        if(money>0){
            return true;
        }
        return false;
    }

    public static String validPhone(String phone){
        if(phone.length() == 10) {
            return phone;
        }
        return "0899558558";
    }

    public static Property randomProperty(){
        switch (Validator.randomInt(1,3)){
            case 1: return new Apartment(randomDescription(),
                    randomAddress(),
                    randomInt(70000,150000),
                    randomInt(50,150),
                    randomTypeOfApartment(),
                    randomTypeOfConstruction());
            case 2: return new House(randomDescription(),
                    randomAddress(),
                    randomInt(50000, 80000),
                    randomInt(75,400),
                    randomHouseType(),
                    randomTypeOfConstruction(),
                    randomInt(0,4),
                    randomInt(200,5000));
            default: return new Plat(randomDescription(),
                    randomAddress(),
                    randomInt(30000,85000),
                    randomInt(200,10000),
                    randomPlatType(),
                    new Random().nextBoolean());
        }
    }

    private static String randomDescription() {
        return "най-добрият имот ever";
    }

    private static String randomAddress() {
        return "Sofia, Mladost "+randomInt(1,4) +", N "+ randomInt(1,400);
    }

    public static Apartment.TypeOfApartment randomTypeOfApartment(){
        switch (Validator.randomInt(1,5)){
            case 1: return Apartment.TypeOfApartment.OneBedroom;
            case 2: return Apartment.TypeOfApartment.Studio;
            case 3: return Apartment.TypeOfApartment.TwoBedrooms;
            case 4: return Apartment.TypeOfApartment.ThreeBedrooms;
            default: return Apartment.TypeOfApartment.Penthouse;
        }
    }

    public static House.TypeOfHouse randomHouseType(){
        switch ((Validator.randomInt(1,2))){
            case 1: return House.TypeOfHouse.FlorOfHouse;
            default: return House.TypeOfHouse.AllHouse;
        }
    }

    public static Plat.TypeOfPlat randomPlatType(){
        switch (Validator.randomInt(1,3)){
            case 1: return Plat.TypeOfPlat.Field;
            case 2: return Plat.TypeOfPlat.Forest;
            default: return Plat.TypeOfPlat.Niva;
        }
    }

    public static TypeOfConstruction randomTypeOfConstruction(){
        switch (Validator.randomInt(1,4)){
            case 1: return TypeOfConstruction.ЕПК;
            case 2: return TypeOfConstruction.Кирпич;
            case 3: return TypeOfConstruction.Тухла;
            default: return TypeOfConstruction.Панел;
        }
    }

    public static int randomInt(int begin, int end) {
        return new Random().nextInt(end-begin +1)+ begin;
    }


    public static String randomPhone() {
        return "089456"+randomInt(1000,9999);
    }

    public static String randomName() {
        return NAMES[new Random().nextInt(NAMES.length)];
    }
}
