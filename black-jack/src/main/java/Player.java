import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<Card> hand;

    public Player() {
        this.hand = new ArrayList<Card>();
    }

    /**
     * Add param card to hand
     * @param card
     * This method will be called by either player by I/O or the (Computer) in game controller
     */
    public void addCard(Card card) {
        this.hand.add(card);
    }

    /**
     * Compute the total's card value in player's hand.
     * The first forloop add all cards values to handValue,
     *      if it is an Ace card, increment ace count but don't sum it
     * The second forloop add the ace values to handValue.
     *      if current handValue < 11 AND aceCount < 1, this indicates this is the first ace on hand
     *          so add 11 to handValue
     *      else either the handValue >= 11 OR this is not the first ace on hand.
     *          so add 1 to handValue
     * @return sum of card's value on a player's hand
     */
    public int getHandValue() {
        int handValue = 0;
        int aceCount = 0;
        final List<Card> aces = new ArrayList<>();
        final int aceLimit = 11;

        for (Card card: this.hand) {
            if (card.getRank() == Card.Rank.ACE) {
                aces.add(card);
            }
            else {
                handValue += card.getValue();
            }
        }

        for (Card ace: aces) {
            if (handValue < aceLimit && aceCount < 1) {
                handValue += ace.getValue(); // ace is 11 point
                aceCount++;
            }
            else {
                handValue += 1;
            }
        }
        return handValue;
    }

    public int getHandSize() {
        return this.hand.size();
    }
}
