import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> deck;

    /**
     * Create a new deck with 52 cards, each card has a unique value of (suit, rank)
     * Use enums.values() to iterate over suit or rank for creating unique card.
     * Add this constructed unique card to list deck.
     * @return the new deck with 52 cards added.
     */
    private List<Card> createNewDeck() {
        final List<Card> deck = new ArrayList<>();
        for (Card.Suit suit: Card.Suit.values()) {
            for (Card.Rank rank: Card.Rank.values()) {
                Card newCard = new Card(rank, suit);
                deck.add(newCard);
            }
        }
        return deck;
    }

    public Deck() {
        this.deck = createNewDeck();
    }

    public List<Card> getDeck() {
        return this.deck;
    }

    /**
     * Always draw the card on top of the deck.
     * The only exception to break the assumption is when the deck is empty.
     * @return card at top of the deck but raise exception when the deck is empty
     */
    public Card dealCard() {
            List<Card> cards = this.getDeck();
            if (cards.isEmpty()) {
                // Throwing IllegalStateException when the deck is empty
                throw new IllegalStateException("Cannot deal card: The deck is empty. Please reshuffle or create a new deck.");
            }
            return cards.remove(cards.size() - 1);
    }


    /**
     * Mutating method that directly mutate the deck
     * Shuffle the deck using java builtin shuffle method.
     */
    public void shuffle() {
        Collections.shuffle(this.deck);
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        for (Card card: deck.getDeck()) {
            IO.println(card);
        }
    }
}
