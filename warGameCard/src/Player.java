package warGameCard;

public class Player {
    private Card [] start;
    private int cardsTaken;
    private String name;

    Player(String  name){
        this.name = name;
        this.cardsTaken = 0;
    }

    public void setStart(Card[] start) {
        this.start = start;
    }

    public Card getStart(int index) {
        return start[index];
    }

    public void setCardsTaken(int cardsTaken, boolean isItNewGame) {
        if(isItNewGame){
            this.cardsTaken = 0;
        }
        else {
            this.cardsTaken += cardsTaken;
        }
    }

    public int getCardsTaken() {
        return cardsTaken;
    }

    public String getName() {
        return name;
    }
}
