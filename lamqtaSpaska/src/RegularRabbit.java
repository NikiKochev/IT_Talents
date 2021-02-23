package lamqtaSpaska;

public class RegularRabbit extends Rabbit {

    RegularRabbit(Heroes heroes){
        super("Reg Rabbit" , 30,3,8,8, heroes);
    }

    @Override
    void getPrize() {
        this.heroes.setExperian(40);
        super.getPrize();
    }
}
