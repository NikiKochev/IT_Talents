package lamqtaSpaska;

public class HardToKillRabbit extends Rabbit {

    HardToKillRabbit(Heroes heroes){
        super("Hard to Kill", 70, 5, 10, 10,heroes);
    }

    @Override
    void getPrize() {
        this.heroes.setExperian(50);
        super.getPrize();
    }
}
