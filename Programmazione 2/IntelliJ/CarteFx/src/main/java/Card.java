public class Card {
    public enum Suit {CLUB, DIAMOND, HEART, SPADE};
    public enum Rank {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, J, Q, K};

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public void print() {
        System.out.println(rank + " of " + suit);
    }

    public boolean equals(Card card) {
        return rank == card.rank && suit == card.suit;
    }
}
