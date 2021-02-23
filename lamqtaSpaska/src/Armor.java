package lamqtaSpaska;

public class Armor extends Item {
    private int health;
    private int chanceForAvoidStrike;

    Armor(Rabbit rabbit){
        super(rabbit);
        this.health = random();
        this.chanceForAvoidStrike = randomChance();
    }

    public int getHealth() {
        return health;
    }

    public int getChanceForAvoidStrike() {
        return chanceForAvoidStrike;
    }
}
