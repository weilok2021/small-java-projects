import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class DeckTest {
    // Check is the new deck size equals to 52
    @Test
    void testSizeOfNewDeck() {
        Deck deck = new Deck();
        assertEquals(52, deck.getDeck().size());
    }

    // Check if all required(rank, suite) 52 cards exist in the new deck
    @Test
    void testRequireCardExistence() {
        Deck deck = new Deck();
        List<Card> cards = deck.getDeck();
        // 2. Assert that every possible unique card is present
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                // Create the card we expect to find
                Card expectedCard = new Card(rank, suit);

                // Check if the list contains the expected card, relying on Card.equals()
                assertTrue(cards.contains(expectedCard),
                        () -> "Deck is missing the card: " + expectedCard.toString());
            }
        }
    }
    // check if the deal cards are from the top of the deck
    @Test
    void testDealCardsFromTopOfDeck() {
        Deck deck = new Deck();
        List<Card> cards = deck.getDeck();
        for (int i = 0; i < 52; i++) {
            Card expectedCardDrawed = cards.get(cards.size() - 1);
            Card cardDrawed = deck.dealCard();
            assertTrue(cardDrawed.equals(expectedCardDrawed));
        }
    }
}
