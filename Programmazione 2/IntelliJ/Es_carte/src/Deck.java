import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        for (Card.Suit s : Card.Suit.values()) {
            for (Card.Rank r : Card.Rank.values()) {
                for (int i=0; i<2; i++) {
                    cards.add(new Card(s, r));
                }
            }
        }
    }

    public void shuffle() {
        System.out.println("========================");
        System.out.println("Shuffling Deck");
        for (int i=0; i<100; i++) {
            Random rand = new Random();
            Card temp = cards.remove(rand.nextInt(cards.size()));
            cards.add(rand.nextInt(cards.size()),temp);
        }
        System.out.println("========================");
    }

    public void print() {
        for (Card c : cards) {
            c.print();
        }
    }

    public void deal(int n) {
        for (int i=0; i<n; i++) {
            Card show = cards.get(i);
            show.print();
        }
    }
}

