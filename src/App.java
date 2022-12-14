import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Player dealer = new Player("Mark", 1000000);
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(dealer);


        System.out.println("What is your name ?");
        String name = scan.nextLine();
        System.out.println("How much do you want to start with ?");
        int amt = scan.nextInt();
        scan.nextLine();

        Player player = new Player(name, amt);
        players.add(player);

        Deck myDeck = new Deck();
        myDeck.shuffle();
        myDeck.dealCards(players);

        for (Player x : players) {
            System.out.println(x.toString());
        }


        for (int i = 0; i < players.size(); i++) {
            while (true) {
                System.out.println(players.get(i).toString());
                System.out.println("Would you like to hit or stand?");
                String option = scan.nextLine();
                if (option.equals("hit")) {
                    Card nextCard = myDeck.drawCard();
                    System.out.println(nextCard.toString());
                    players.get(i).addCard(nextCard);
                    players.get(i).toString();



                } else {
                    break;
                }
            }
        }


    }
}
