import java.util.ArrayList;

public class Player {
    private String name;
    private int balance;
    ArrayList<Card> cards = new ArrayList<Card>();
    int sum;

    public Player(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }


    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int getSum() {
        return sum;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void addCard(Card card) {
        this.cards.add(card);
        this.calcSum();
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String toString() {
        return this.name + " has "
                + this.cards.get(0).getName() + " and "
                + this.cards.get(1).getName() + " and a balance of: "
                + this.balance + " with sum: "
                + this.sum;
    }


    public void calcSum() {
        sum = 0;
        for (Card x : cards) {
            sum += x.getValue();
        }
    }


}
