package lamqtaSpaska;

public class Wepon extends Item{
    private int damage;
    private int chanceForCriticalHit;

    public Wepon( Rabbit rabbit) {
        super(rabbit);
        this.damage = random();
        this.chanceForCriticalHit = randomChance();
    }

    public int getDamage() {
        return damage;
    }

    public int getChanceForCriticalHit() {
        return chanceForCriticalHit;
    }
}
