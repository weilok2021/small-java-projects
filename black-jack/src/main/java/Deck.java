import java.util.ArrayList;
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

//    shuffle() — randomizes card order.
//
//    dealCard() — returns and removes the top card.
//
//    cardsLeft() — optional, returns count.
}
