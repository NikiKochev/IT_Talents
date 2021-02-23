package warGameCard;

public class demo {
    public static void main(String[] args) {
        Player p1 = new Player("player1");
        Player p2  = new Player("player2");


        Game one= new Game(p1,p2);
        for (int i = 0; i < 10; i++) {
            one.play();
        }


    }
}
