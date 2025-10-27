import java.util.List;
import java.util.Scanner;

public class Game {
    /**
     * To start a game, I need a dealer, a player, and a deck
     * First turn, dealer and players both get two cards from a shuffled deck
     * The first card of dealer needs to be shown, and the second card hides
     * Player can decide either to stand or hit
     */
    private final Player player;
    private final Dealer dealer;
    private final Deck deck;
    private Player turn;

    public Game() {
        this.player = new Player();
        this.dealer = new Dealer();
        this.deck = new Deck();
        deck.shuffle();
    }

    public void runGame() {
        startRound();   // just deals initial cards
        showGameState(true);

        // Check immediate Blackjack conditions
        if (isBlackJack(player) && isBlackJack(dealer)) {
            IO.println("Both have Blackjack! It's a push.");
            showGameState(true);
            return;
        } else if (isBlackJack(dealer)) {
            IO.println("Dealer has Blackjack! Dealer wins.");
            showGameState(true);
            return;
        } else if (isBlackJack(player)) {
            IO.println("Player has Blackjack! Player wins.");
            showGameState(true);
            return;
        }

        // Otherwise continue the round
        playerTurn();
        dealerTurn();
        determineWinner();
    }


    public void playerTurn() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            IO.print("Hit or Stand? ");
            String decision = sc.nextLine().toLowerCase();
            boolean standOrBust = decision.equals("stand")
                    || decision.equals("s")
                    || this.player.getHandValue() > 21;
            if (!standOrBust) {
                if (decision.equals("hit") || decision.equals("h")) {
                    this.player.addCard(this.deck.dealCard()); // player draw one card
                }
            } else {
                IO.println("Player turns end");
                return;
            }
            this.showGameState(true);
        }
    }

    public void dealerTurn() {
        while (this.dealer.getHandValue() < 17) {
            IO.println("dealer draw a card");
            this.dealer.addCard(this.deck.dealCard());
            this.showGameState(true);
        }
    }

    public boolean isBlackJack(Player playerOrDealer) {
        return playerOrDealer.getHandValue() == 21 && playerOrDealer.getHandSize() == 2;
    }

    public void startRound() {
        player.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
        player.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
    }

    public void showGameState(boolean hideDealer) {
        IO.println(this.dealer.showHand(hideDealer));
        IO.println(this.player.showHand());
    }

    public void determineWinner() {
        int playerVal = player.getHandValue();
        int dealerVal = dealer.getHandValue();

        showGameState(false); // reveal dealer’s hand

        IO.println("Dealer points: " + this.dealer.getHandValue());
        IO.println("Player points: " + this.player.getHandValue());

        if (playerVal > 21 && dealerVal > 21) {
            IO.println("Both busted! It's a draw.");
        } else if (playerVal > 21) {
            IO.println("Player busts! Dealer wins.");
        } else if (dealerVal > 21) {
            IO.println("Dealer busts! Player wins.");
        } else if (playerVal == dealerVal) {
            IO.println("It's a push (tie).");
        } else if (playerVal > dealerVal) {
            IO.println("Player wins!");
        } else {
            IO.println("Dealer wins!");
        }
    }

    public static void main(String[] args) {
        IO.println("=== Welcome to Blackjack! ===");
        Game game = new Game();
        game.runGame();
        IO.println("=== Game Over ===");
    }


}
