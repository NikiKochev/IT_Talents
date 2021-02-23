package lamqtaSpaska;

import java.util.Random;
import java.util.Scanner;

public class Heroes {
    private String name;
    private int level;
    private int experian;
    private int health;
    private int damage;
    private int chanceForCriticalHit;
    private int chanceForAvoidStrike;
    private Enemy enemy;
    private Item[] wepons;
    private int freePlasesWepons;
    private Item[] armors;
    private int freePlasesArmor;
    private boolean win;

    public Heroes(String name) {
        if(name != null && name.length() > 0 && name.length() < 20){
            this.name = name;
        }
        else{
            this.name = "player1";
        }
        this.level = 1;
        this.experian = 0;
        this.health = 100;
        this.damage = 5;
        this.chanceForAvoidStrike = 0;
        this.chanceForCriticalHit = 0;
        this.win = false;
        this.wepons = new Wepon[3];
        this.freePlasesWepons = wepons.length;
        this.armors = new Armor[2];
        this.freePlasesArmor = armors.length;
    }

    boolean isWin() {// при побеждаване на ламята да спира играта
        return win;
    }

    void setExperian(int experian) {
        this.experian+= experian;
        if(this.experian > this.levelExp(this.level)*100){
            this.damage+=5;
            this.health+=20;
            this.level++;
        }

    }

    private int levelExp(int n)  {
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else
            return levelExp(n - 1) + levelExp(n - 2);
    }

    void movment(char x){
        switch (x){
            default : System.out.println("invalid move");
                    break;
            case '1': this.goAndFigthWithRabbit();
                    break;
            case '2': this.goToBar();
                    break;
            case '3': this.goAndFigthWithSpaska();
                    break;
            case '4': this.showInfo();
                    break;
        }
    }

    private void goAndFigthWithRabbit(){
        Random r = new Random();
        switch (r.nextInt(2)) {
            case 0 : this.enemy = new LosserRabbit(this);
                break;
            case 1: this.enemy = new RegularRabbit(this);
                break;
            case 2: this.enemy = new HardToKillRabbit(this);
                break;
        }
        while (this.health > 0){
            this.hit();
            if(this.enemy.getHealth() > 0){
                enemy.hit(this);
            }
            if(this.enemy.getHealth()<= 0){
                break;
            }
        }
        if(this.enemy.getHealth() <= 0) {
            System.out.println("Уби този заек");
            this.takeEnemyReward();
        }
        if (this.health <= 0){
            System.out.println("Мъртав си!!!!!");
            this.goToBar();
        }
    }

    private void goAndFigthWithSpaska(){
        this.enemy = new Dragon(this);
        while ( this.health > 0){
            this.hit();
            if(this.enemy.getHealth() > 0){
                enemy.hit(this);
            }
            if(this.enemy.getHealth()<= 0){
                this.takeEnemyReward();
                break;
            }
        }
        if(this.health <=0) {
            System.out.println(" you are death. Try again");
            this.goToBar();
        }

    }

    void takeAHit(double damage) {
        Random r = new Random();
        if (r.nextInt(100) > this.chanceForAvoidStrike) {
            this.health -= damage;
        }
    }

    private void hit(){
        Random r = new Random();
        if (r.nextInt(100) < this.chanceForCriticalHit) {
            this.enemy.takeAHit(this.damage * 1.5);
        } else {
            this.enemy.takeAHit(this.damage);
        }
    }

    private void takeEnemyReward(){
        this.enemy.getPrize();

    }

    void setItem(Item item){
        if(item instanceof Wepon){
            System.out.println("падна ти се меч");
           if(this.freePlasesWepons > 0){
               this.wepons[wepons.length - this.freePlasesWepons] =  item;
               this.freePlasesWepons--;
               this.damage+= item.getDamage();
               this.chanceForCriticalHit+= item.getChanceForCriticalHit();
           }
           else {

               this.changeWepon( item);
           }
        }
        else {
            System.out.println("падна ти се броня");
            if(this.freePlasesArmor > 0){
                this.armors[armors.length - this.freePlasesArmor] =  item;
                this.freePlasesArmor--;
                this.health += item.getHealth();
                this.chanceForAvoidStrike += item.getChanceForAvoidStrike();
            }
            else{
                this.changeArmor(item);
            }
        }
        item.changeOwner(this);
    }

    private void changeWepon(Item wepon){
        this.printInfoForWepons();
        System.out.println("натисни 0 ако не искаш да сменяш ");
        System.out.println();
        System.out.println("текущ предмет удар: " + wepon.getDamage() + ", шанс за критичен удар: " + wepon.getChanceForCriticalHit());
        Scanner sc = new Scanner(System.in);
        System.out.println("избери кой предмет да смениш");
        char c =sc.next().charAt(0);
        int temp = c - '0';
        if(temp>0 && temp<4){
            this.damage -= this.wepons[temp -1].getDamage();
            this.chanceForCriticalHit -= this.wepons[temp-1].getChanceForCriticalHit();
            this.wepons[temp -1] = wepon;
            this.damage += wepon.getDamage();
            this.chanceForCriticalHit += wepon.getChanceForCriticalHit();
        }

    }

    private void changeArmor(Item armor){
        this.printInfoForArmors();
        System.out.println("натисни 0 ако не искаш да сменяш ");
        System.out.println();
        System.out.println("текущ предмет защита: " + armor.getHealth() + ", шанс за отбягване на удар: " + armor.getChanceForAvoidStrike());
        Scanner sc = new Scanner(System.in);
        System.out.println("избери коя броня да смениш");
        char c =sc.next().charAt(0);
        int temp = c - '0';
        if(temp>0 && temp<3){
            this.health-=this.armors[temp -1].getHealth();
            this.chanceForAvoidStrike-= this.armors[temp -1].getChanceForAvoidStrike();
            this.armors[temp -1] = armor;
            this.health+= armor.getHealth();
            this.chanceForAvoidStrike+= armor.getChanceForAvoidStrike();
        }
    }

    void winingAgame(boolean win){
        this.win = win;
    }

    private void showInfo(){
        System.out.print(this.name + " "+this.level+" ниво " +this.health+" живот, "+this.damage+" удар, " +this.chanceForCriticalHit+
                " шанс за критичен удар, " + this.chanceForAvoidStrike +" шанс за отбягване на удар");
        System.out.println();
        this.printInfoForItem();
    }

    private void printInfoForItem(){
        this.printInfoForArmors();
        this.printInfoForWepons();
    }

    private void printInfoForWepons(){
        for (int i = 0; i < this.wepons.length - this.freePlasesWepons; i++) {
            System.out.println(i+1 + " удар " + this.wepons[i].getDamage() + ", шанс за критичен удар " + this.wepons[i].getChanceForCriticalHit()+"%");
        }
    }

    private void printInfoForArmors(){
        for (int i = 0; i < this.armors.length - this.freePlasesArmor; i++) {
            System.out.println(i+1 + " защита " + this.armors[i].getHealth() + ", шанс за избягване на удар " + this.armors[i].getChanceForAvoidStrike()+"%");
        }
    }

    private void goToBar(){
        this.health =  100 + this.level*20;
        this.damage = 5 + this.level*5;
        this.chanceForAvoidStrike = 0;
        this.chanceForCriticalHit = 0;
        this.prepareForBattle();
    }

    private void prepareForBattle(){
        for (int i = 0; i < this.wepons.length - this.freePlasesWepons; i++) {
            this.damage+= this.wepons[i].getDamage();
            this.chanceForCriticalHit+= this.wepons[i].getChanceForCriticalHit();
        }
        for (int i = 0; i < this.armors.length - this.freePlasesArmor; i++) {
            this.health+= this.armors[i].getHealth();
            this.chanceForAvoidStrike += this.armors[i].getChanceForAvoidStrike();
        }

    }
}
