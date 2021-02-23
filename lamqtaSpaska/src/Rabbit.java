package lamqtaSpaska;

import java.util.Random;

public class Rabbit extends Enemy {
    Item item;

    public Rabbit(String name, int health, int damage, int chanceForCriticalHit, int chanceForAvoidStrike, Heroes heroes) {
        super(name, health, damage, chanceForCriticalHit, chanceForAvoidStrike, heroes);
        Random r = new Random();
        if(r.nextBoolean()){
            this.item = new Wepon(this);
        }
        else{
            this.item = new Armor(this);
        }
    }

    public Item getItem() {
        return item;
    }

    @Override
    void getPrize() {

        this.heroes.setItem(this.item);
    }
}
