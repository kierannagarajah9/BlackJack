import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> myCards;

    private int deckNum = 52;

    private String[] names = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private String[] suits = {"Clubs", "Spades", "Hearts", "Dimes"};

    //Creates the deck of 52
    public Deck() {
        myCards = new ArrayList<Card>();
        for (int i = 0; i < names.length; i++) {
            for (String suit : suits) {
                Card card = new Card(names[i] + suit.charAt(0), suit, i + 1);
                this.myCards.add(card);
            }
        }
    }


    public ArrayList<Card> getMyCards() {
        return myCards;
    }

    public void shuffle() {
        ArrayList<Card> tempDeck = new ArrayList<Card>();
        Random random = new Random();
        int randomCardIndex = 0;
        int originalSize = this.myCards.size();

        for (int i = 0; i < originalSize; i++) {
            //Generate random index between max and min.... random.nextInt((max-min) + 1) +0
            randomCardIndex = random.nextInt((this.myCards.size() - 1 - 0) + 1) + 0;
            tempDeck.add(this.myCards.get(randomCardIndex));
            //Remove from original deck
            this.myCards.remove(randomCardIndex);
        }

        this.myCards = tempDeck;
    }


    public void dealCards(ArrayList<Player> players) {
        int numCards = 2 * players.size();
        for (int i = 1; i <= numCards; i++) {
            int currentPlayer = i % 2;
            players.get(currentPlayer).addCard(this.myCards.get(0));
            this.myCards.remove(0);
            players.get(currentPlayer).calcSum();
        }


    }

    public Card drawCard() {
        Card nextCard = this.myCards.get(0);
        this.myCards.remove(0);
        deckNum--;
        return nextCard;
    }
}
