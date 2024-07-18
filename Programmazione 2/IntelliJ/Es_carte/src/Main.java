import java.util.*;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();

        deck.shuffle();
        deck.deal(10);
        for (int i = 0; i < 10; i++) {
            Card curr = deck.getCard(i);
            for (int j = 0; j < i; j++) {
                Card check = deck.getCard(j);
                if (curr.equals(check)) {
                    System.out.println("Hai vinto!");
                    System.exit(0);
                }
            }
        }
        System.out.println("Hai perso");
    }
}
