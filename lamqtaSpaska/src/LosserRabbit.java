package lamqtaSpaska;

public class LosserRabbit extends Rabbit {

    LosserRabbit(Heroes heroes){
        super("loser Rabbit", 5,1,5,5,heroes);
    }

    @Override
    void getPrize() {
        this.heroes.setExperian(30);
        super.getPrize();
    }
}
