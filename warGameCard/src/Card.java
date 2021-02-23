package warGameCard;

public class Card {
    private int strength;
    private String name;


    Card(int strength, String name){
        this.strength = strength;
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }
}
