public class BlackJack {
    /**
     * What are the objects needed in blackjack?
     * A card composed of rank and suit
     * Player hand of cards
     * A deck composed of list/collection of cards
     *      methods: shuffle, drawCard
     * Game Logic/Controller
     *      (deal, hit, stand, win/loss check)
     */

    public enum Suit {
        HEARTS, DIAMONDS, CLUBS, SPADES
    }

    public enum Rank {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN,
        JACK, QUEEN, KING, ACE
    }

    public class Card {
        private final Suit suit;
        private final Rank rank;

        public Card(Suit suit, Rank rank) {
            this.suit = suit;
            this.rank = rank;
        }

        public Suit getSuit() {
            return this.suit;
        }

        public Rank getRank() {
            return this.rank;
        }
    }
}
