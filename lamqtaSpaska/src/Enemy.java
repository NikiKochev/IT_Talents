package lamqtaSpaska;

import java.util.Random;

public class Enemy {
    private String name;
    private int health;
    private int damage;
    private int chanceForCriticalHit;
    private int chanceForAvoidStrike;
    Heroes heroes;


    public Enemy(String name, int health, int damage, int chanceForCriticalHit, int chanceForAvoidStrike, Heroes heros) {

        this.name = name;
        this.health = health;
        this.damage = damage;
        this.chanceForCriticalHit = chanceForCriticalHit;
        this.chanceForAvoidStrike = chanceForAvoidStrike;
        this.heroes = heros;
    }

    private void recovering(int health, int damage, int chanceForCriticalHit, int chanceForAvoidStrike){
        this.health = health;
        this.damage = damage;
        this.chanceForCriticalHit = chanceForCriticalHit;
        this.chanceForAvoidStrike = chanceForAvoidStrike;
    }

     void hit(Heroes heroes){
        Random r = new Random();
        if (r.nextInt(100) < this.chanceForCriticalHit) {
            heroes.takeAHit(this.damage * 1.5);
        } else {
            heroes.takeAHit(this.damage);
        }
    }

    void takeAHit(double damage){
        Random r = new Random();
        if(r.nextInt(100)>this.chanceForAvoidStrike){
            this.health-= damage;
        }
    }

    public int getHealth() {
        return health;
    }

    void getPrize(){}
}
