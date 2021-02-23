package lamqtaSpaska;

import java.util.Random;

public class Item {
    Rabbit rabbit;
    Heroes heroes;

    public Item(Rabbit rabbit) {
        this.rabbit = rabbit;
    }

    int random(){
         Random r = new Random();
         return r.nextInt(200)+100;
    }

    int randomChance(){
        Random r = new Random();
        return r.nextInt(20)+10;
    }

    void changeOwner(Heroes heroes){
        this.heroes = heroes;
        this.rabbit = null;
    }

    public int getChanceForCriticalHit(){
        return 0;
    }

    public int getDamage(){
        return 1;
     }

    public int getHealth() {
        return 1;
    }

    public int getChanceForAvoidStrike() {
        return 1;
    }

}
