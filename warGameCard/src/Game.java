package warGameCard;

public class Game {
    private Player one;
    private Player two;
    private DeckOfCard deck;
    private boolean isItNewGame;
    private int curentCardOnTable;

    Game(Player one, Player two){
        this.one = one;
        this.two = two;
        this.isItNewGame =true;
        this.curentCardOnTable =0;
        this.one.setCardsTaken(curentCardOnTable,isItNewGame);
        this.two.setCardsTaken(curentCardOnTable,isItNewGame);
        play();
    }

    void play(){
        this.curentCardOnTable =0;
        this.one.setCardsTaken(curentCardOnTable,isItNewGame);
        this.two.setCardsTaken(curentCardOnTable,isItNewGame);
        this.isItNewGame =false;
        deck = new DeckOfCard();
        handingOutCards();
        int index = 0;

        while (index<26) {

            curentCardOnTable = 0;
            index = cardVsCard(index, false);
        }
        if (one.getCardsTaken() > two.getCardsTaken()){
            System.out.println(one.getName() + " is a winner");
        }
        else {
            if(one.getCardsTaken() < two.getCardsTaken()){
                System.out.println(two.getName() + " is a winner");
            }
            else {
                System.out.println("the result is equal");
            }
        }
        this.isItNewGame =true;
    }

    private  void handingOutCards(){
        Card[] playerOne = new Card[26];
        Card[] playerTwo = new Card[26];
        for (int i = 0; i < 26; i++) {
            playerOne[i] = deck.getDeck(i);
            playerTwo[i]  = deck.getDeck(51-i);
        }
        this.one.setStart(playerOne);
        this.two.setStart(playerTwo);
    }

    private int cardVsCard(int index,boolean isWasAwar){
        this.curentCardOnTable+=2;

        if(one.getStart(index).getStrength() > two.getStart(index).getStrength()){
            this.one.setCardsTaken(curentCardOnTable,isItNewGame);
            index++;
        }
        else {
            if(one.getStart(index).getStrength() < two.getStart(index).getStrength()){
                this.two.setCardsTaken(curentCardOnTable,isItNewGame);
                 index++;
            }
            else {
                if(index>22){
                    this.one.setCardsTaken(curentCardOnTable/2,isItNewGame);
                    this.two.setCardsTaken(curentCardOnTable/2,isItNewGame);
                    index++;
                }
                else {
                    if(!isWasAwar) {
                        index = threeVsThree(index);
                    }
                    else {
                      index= cardVsCard(index +1,isWasAwar);
                    }
                }
            }
        }
        return index;
    }

    private int threeVsThree(int index){
        this.curentCardOnTable+=6;
        if(one.getStart(index + 3).getStrength() > two.getStart(index + 3).getStrength()){
            this.one.setCardsTaken(curentCardOnTable,isItNewGame);
            index+=3;
        }
        else {
            if(one.getStart(index).getStrength() < two.getStart(index).getStrength()){
                this.two.setCardsTaken(curentCardOnTable,isItNewGame);
                 index+=3;
            }
            else {
                 index = cardVsCard(index+3,true);

            }
        }
        return index;
    }
}
