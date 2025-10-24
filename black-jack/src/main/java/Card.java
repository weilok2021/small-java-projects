public class Card {
    /**
     * Represents an immutable playing card with a rank and suit.
     *
     * Assumptions:
     * - A deck will contain at most one card of each (Rank, Suit) combination.
     * - Rank and Suit are never reassigned.
     * - The value of Ace is treated as 11 by default; game logic decides when to treat it as 1.
     * Examples:
     *   new Card(Rank.ACE, Suit.HEARTS) → "ACE of HEARTS"
     */

    final Suit suit;
    final Rank rank;

    public enum Suit {
        HEARTS, DIAMONDS, CLUBS, SPADES
    }

    public enum Rank {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN,
        JACK, QUEEN, KING, ACE
    }

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public Rank getRank() {
        return this.rank;
    }

    /**
     *
     * @return numeric value: 2-10 for number cards, 10 for faces cards, 11 for ace.
     * @implNote The flexible value of Ace (1 or 11) is handled in Hand, not here.
     */
    public int getValue() {
        switch (this.rank) {
            case JACK, QUEEN, KING:
                return 10;
            case ACE:
                return 11; // or 1, depending on context
            default:
                return rank.ordinal() + 2;
        }
    }

    /**
     * Compares this card to the specified object for equality.
     *
     * Two cards are considered equal if and only if they have the same rank
     * and the same suit. Equality is based on card identity rather than
     * object reference.
     *
     * @param obj the object to compare with this card
     * @return true if {@code obj} is a Card with the same rank and suit; false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Card))
            return false;
        Card card = (Card) obj;
        return this.suit == card.suit && this.rank == card.rank;
    }

    @Override
    public String toString() {
        return this.rank.toString() + " of " + this.suit.toString();
    }
}
