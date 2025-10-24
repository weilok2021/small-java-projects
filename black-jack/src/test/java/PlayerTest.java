import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// ... Assuming Card and Player classes are accessible ...

public class PlayerTest {
    // Helper Cards for clean testing (must be initialized outside methods)
    // Note: Use actual Rank/Suit enums from your Card class
    private final Card cardAce = new Card(Card.Rank.ACE, Card.Suit.SPADES);     // Value 11
    private final Card cardKing = new Card(Card.Rank.KING, Card.Suit.CLUBS);   // Value 10
    private final Card cardFive = new Card(Card.Rank.FIVE, Card.Suit.HEARTS);   // Value 5
    private final Card cardTwo = new Card(Card.Rank.TWO, Card.Suit.DIAMONDS);  // Value 2

    // --- Test for addCard(Card card) ---

    @Test
    void testAddCardIncreasesHandSize() {
        // Arrange
        Player player = new Player();

        // Act
        player.addCard(cardKing);
        player.addCard(cardFive);

        // Assert: Assuming Player has a getHandSize() or similar accessor
        assertEquals(2, player.getHandSize(), "Hand size should be 2 after adding two cards.");
    }

    // --- Tests for getHandValue() (Blackjack Scoring Logic) ---
    @Test
    void testHandValueSimpleCards() {
        // Arrange: 10 + 5 = 15
        Player player = new Player();
        player.addCard(cardKing);
        player.addCard(cardFive);

        // Act & Assert
        assertEquals(15, player.getHandValue(), "King (10) + 5 should equal 15.");
    }

    @Test
    void testHandValueSoftAceAsEleven() {
        // Arrange: Ace (11) + 5 = 16 (Ace stays 11)
        Player player = new Player();
        player.addCard(cardAce);
        player.addCard(cardFive);

        // Act & Assert
        assertEquals(16, player.getHandValue(), "Ace and 5 should be 16 (Ace as 11).");
    }

    @Test
    void testHandValueHardAceAsOne() {
        // Arrange: Ace (11) + King (10) + 2 = 23. Ace must drop to 1. Result: 1 + 10 + 2 = 13.
        Player player = new Player();
        player.addCard(cardAce);
        player.addCard(cardKing);
        player.addCard(cardTwo);

        // Act & Assert
        assertEquals(13, player.getHandValue(), "Ace + King + 2 should be 13 (Ace as 1).");
    }

    @Test
    void testHandValueMultipleAces() {
        // Arrange: Ace (11) + Ace (11) + 9 = 31. First Ace drops to 1 (Total 21).
        Player player = new Player();
        player.addCard(cardAce); // Ace 1
        player.addCard(cardAce); // Ace 2
        player.addCard(new Card(Card.Rank.NINE, Card.Suit.HEARTS)); // Value 9

        // Act & Assert
        assertEquals(21, player.getHandValue(), "Two Aces and 9 should correctly score 21.");
    }
}