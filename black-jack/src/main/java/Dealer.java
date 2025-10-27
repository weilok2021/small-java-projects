import java.util.List;

public class Dealer extends Player{
//    private final Card firstCard;
    public Dealer() {
        super();
    }

    public Card getFirstCard() {
        return this.getHand().get(0);
    }

    /**
     * Returns a string representation of the dealer's hand.
     * @param hideFirst if true, hides the first card (used during the game).
     * @return String representation of dealer's hand.
     */
    public String showHand(boolean hideFirst) {
        List<Card> dealerHand = this.getHand();
        if (dealerHand.isEmpty())
            return "Dealer has no hand";

        StringBuilder sb = new StringBuilder("Dealer's hand:\n");

        for (int i = 0; i < dealerHand.size(); i++) {
            if (i == 0 && hideFirst) {
                sb.append("Hidden First Card\n");
            } else {
                Card card = dealerHand.get(i);
                sb.append(formatCard(card)).append("\n");
            }
        }
        return sb.toString();
    }

    private String formatCard(Card card) {
        return capitalize(card.getRank().name()) + " of " + capitalize(card.getSuit().name());
    }

    private String capitalize(String s) {
        return s.charAt(0) + s.substring(1).toLowerCase();
    }

//    @Override
//    public String toString() {
//        String s = "";
//        List<Card> dealerHand = this.getHand();
//        if (dealerHand.isEmpty())
//            return "Dealer has no hand";
//
//        s += "Dealer's hand: \n";
//        s += "Hidden First Card\n";
//        for (int i = 1; i < dealerHand.size(); i++) {
//            s += dealerHand.get(i).getRank().toString() + " of " + dealerHand.get(i).getSuit().toString();
//            s += "\n";
//        }
//        return s;
//    }

    public static void main(String[] args) {
        Dealer dealer = new Dealer();
        dealer.addCard(new Card(Card.Rank.ACE, Card.Suit.HEARTS));
        dealer.addCard(new Card(Card.Rank.KING, Card.Suit.HEARTS));
        dealer.addCard(new Card(Card.Rank.TEN, Card.Suit.HEARTS));
        IO.println(dealer.showHand(true));

//        IO.println(dealer);
    }
}
