package warGameCard;

import java.util.Random;

public class DeckOfCard {
    private  Card [] deck;

    DeckOfCard(){
        createADeck();
        shuffleCards();
    }

    public Card getDeck(int index) {
        return deck[index];
    }

    private void createADeck(){
        deck = new Card[52];
        int counter = 0;
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++, counter++) {//да видя дали работи правилно
                deck[counter] = new Card(i,cardName(counter));
            }
        }
    }

    private  void shuffleCards(){
        Random r = new Random();
        for (int i = 0; i < this.deck.length; i++) {
            int randomIndex = r.nextInt(this.deck.length);
            Card x= this.deck[randomIndex];
            this.deck[randomIndex] = deck[i];
            deck[i] = x;
        }
    }

    private String cardName(int numberOfCard) {
        switch (numberOfCard + 1) {
            case 1:
                return "2 спатия";
            case 2:
                return "2 каро";
            case 3:
                return "2 купа";
            case 4:
                return "2 пика";
            case 5:
                return "3 спатия";
            case 6:
                return "3 каро";
            case 7:
                return "3 купа";
            case 8:
                return "3 пика";
            case 9:
                return "4 спатия";
            case 10:
                return "4 каро";
            case 11:
                return "4 купа";
            case 12:
                return "4 пика";
            case 13:
                return "5 спатия";
            case 14:
                return "5 каро";
            case 15:
                return "5 купа";
            case 16:
                return "5 пика";
            case 17:
                return "6 спатия";
            case 18:
                return "6 каро";
            case 19:
                return "6 купа";
            case 20:
                return "6 пика";
            case 21:
                return "7 спатия";
            case 22:
                return "7 каро";
            case 23:
                return "7 купа";
            case 24:
                return "7 пика";
            case 25:
                return "8 спатия";
            case 26:
                return "8 каро";
            case 27:
                return "8 купа";
            case 28:
                return "8 пика";
            case 29:
                return "9 спатия";
            case 30:
                return "9 каро";
            case 31:
                return "9 купа";
            case 32:
                return "9 пика";
            case 33:
                return "10 спатия";
            case 34:
                return "10 каро";
            case 35:
                return "10 купа";
            case 36:
                return "10 пика";
            case 37:
                return "вале спатия";
            case 38:
                return "вале каро";
            case 39:
                return "вале купа";
            case 40:
                return "вале пика";
            case 41:
                return "дама спатия";
            case 42:
                return "дама каро";
            case 43:
                return "дама купа";
            case 44:
                return "дама пика";
            case 45:
                return "поп спатия";
            case 46:
                return "поп каро";
            case 47:
                return "поп купа";
            case 48:
                return "поп пика";
            case 49:
                return "асо спатия";
            case 50:
                return "асо каро";
            case 51:
                return "асо купа";
            case 52:
                return "асо пика";

        }
        return "асо пика";
    }
}
