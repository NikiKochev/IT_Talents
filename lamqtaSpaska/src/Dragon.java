package lamqtaSpaska;

public class Dragon extends Enemy{

    public Dragon(Heroes heroes) {
        super("Lamqta Spaska",10000,100, 10,15, heroes);
    }

    @Override
    void getPrize() {
        heroes.winingAgame(true);
    }
}
