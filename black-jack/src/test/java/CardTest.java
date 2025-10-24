import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CardTest {
    @Test
    void cardStoresRankAndSuitCorrectly() {
        Card card = new Card(Card.Rank.ACE, Card.Suit.HEARTS);
        assertEquals(Card.Rank.ACE, card.getRank());
        assertEquals(Card.Suit.HEARTS, card.getSuit());
    }

    @Test
    void cardsWithSameRankAndSuitAreEqual() {
        Card c1 = new Card(Card.Rank.TEN, Card.Suit.SPADES);
        Card c2 = new Card(Card.Rank.TEN, Card.Suit.SPADES);
        assertEquals(c1, c2);
    }

    @Test
    void toStringShowsReadableFormat() {
        Card card = new Card(Card.Rank.KING, Card.Suit.CLUBS);
        assertEquals("KING of CLUBS", card.toString());
    }
}
