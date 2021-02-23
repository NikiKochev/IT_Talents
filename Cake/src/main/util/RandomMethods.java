package main.util;

import main.cake.*;
import main.person.Deliver;

import java.util.ArrayList;
import java.util.Random;

public abstract class RandomMethods {
    public static final String[] PERSON_NAMES = {"Ivan", "Dragan","Jordan","Grozdan","John","Simeon","Pepi","Eli","Dani","Vanq","Mimi","Geri"};
    public static final String[] CITY_NAMES = {"SOFIA","PLOVDIV","VARNA","BURGAS"};
    public static final String[] STREET_NAMES = {"Hristo Botev","Ivan Vazov","Bul Bulgaria","Vasil Levski"};
    public static final String[] EVENT = {"COMPANY","ADVERTISING","ANNIVERSARY"};
    public static final String[] DESCRIPTION = {"ebati qkata torta","SUPER E","naj-dobrata"};


    public static String randomName() {
        return PERSON_NAMES[new Random().nextInt(PERSON_NAMES.length)];
    }

    public static String randomPhoneNumber() {
        return "089"+ new Random().nextInt(9000000)+1000000;
    }

    public static int randomNumber(int i, int i1) {
        return new Random().nextInt(i1-i+1)+i;
    }

    public static double randomMoney() {
        return randomNumber(8,300)+0.99;
    }

    public static String randomAddress() {
        return CITY_NAMES[new Random().nextInt(CITY_NAMES.length)]+" "+ STREET_NAMES[new Random().nextInt(STREET_NAMES.length)]+" #"
                + randomNumber(1,200);
    }

    public static String randomDescription() {
        return DESCRIPTION[new Random().nextInt(DESCRIPTION.length)];
    }

    public static Cake createRandomCake() {
        switch (new Random().nextInt(4)){
            case 1: return new KidCake(randomName(),
                                        randomDescription(),
                                        randomMoney(),
                                        randomNumber(6,16),
                                        randomKidType(),
                                        randomName());
            case 2: return new StandardCake(randomName(),
                                            randomDescription(),
                                            randomMoney(),
                                            randomNumber(6,10),
                                            randomStandardType(),
                                            new Random().nextBoolean());
            case 3: return new WeddingCake(randomName(),
                                            randomDescription(),
                                            randomMoney(),
                                            randomNumber(6,10),
                                            randomWeddingType(),
                                            randomNumber(6,16));
            default: return new SpecialCake(randomName(),
                                            randomDescription(),
                                            randomMoney(),
                                            randomNumber(6,10),
                                            randomSpecialCake(),
                                            randomEvent());
        }
    }

    private static String randomEvent() {
        return EVENT[new Random().nextInt(EVENT.length)];
    }

    private static SpecialCake.SpecialType randomSpecialCake() {
        switch (new Random().nextInt(3)){
            case 1: return SpecialCake.SpecialType.ADVERTISING;
            case 2: return SpecialCake.SpecialType.COMPANY;
            default: return SpecialCake.SpecialType.ANNIVERSARY;
        }
    }

    private static WeddingCake.WeddingType randomWeddingType() {
        switch (new Random().nextInt(3)){
            case 1: return WeddingCake.WeddingType.BIG;
            case 2:return WeddingCake.WeddingType.MEDIUM;
            default: return WeddingCake.WeddingType.SMALL;
        }
    }

    private static StandardCake.StandardType randomStandardType() {
        switch (new Random().nextInt(4)){
            case 1: return StandardCake.StandardType.BISCUIT;
            case 2: return StandardCake.StandardType.CHOCOLATE;
            case 3: return StandardCake.StandardType.FRUIT;
            default: return StandardCake.StandardType.ECLAIR;
        }

    }

    private static KidCake.KidType randomKidType() {
        switch (new Random().nextInt(3)){
            case 1: return KidCake.KidType.FOR_A_FORERUNNER;
            case 2: return KidCake.KidType.FOR_A_BAPTISM;
            default: return KidCake.KidType.FOR_A_BIRTHDAY;
        }
    }

    public static Deliver createRandomDelivery() {
        return new Deliver(randomName(), randomPhoneNumber());
    }

    public static ArrayList<Cake> randomCakes() {
        int numOfcakes = randomNumber(3,5);
        ArrayList<Cake> current = new ArrayList<>();
        for (int i = 0; i < numOfcakes; i++) {
            current.add(createRandomCake());
        }
        return current;
    }
}
