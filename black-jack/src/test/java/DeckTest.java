import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class DeckTest {
    // Check can a desk successfully created
    @Test
    void testInitializdeDeck() {
        Deck deck = Deck().getDeck();
        assertEquals(52, deck.size());
    }
}
