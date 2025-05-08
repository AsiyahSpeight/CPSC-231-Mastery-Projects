// 3B/Game.java
import java.util.LinkedList;
import java.util.Random;

public class Game {
    // 1. MEMBER VARIABLES
    private LinkedList<Player> players; // a LinkedList of Players that represents each Player object in order of the “circle”
    private LinkedList<Card> pile; // a LinkedList of Cards that represents the current pile of cards in the game. The last element of the pile is considered to be on “top”
    private Dealer dealer; // a Dealer member variable that holds the game’s Deck of cards
    private String[] patterns; // an array of Strings representing which special pattern are valid to be slapped on during this game. All games should include at minimum these patterns: [ “doubles”, “top bottom”, “sandwich” ]

    // 2. DEFAULT CONSTRUCTOR
    public Game(){
        this(2); // Initializes the game with 2 players by calling the other constructor (overloaded)
    }

    // 3. OVERLOADED CONSTRUCTOR
    public Game(int numPlayers){
        players = new LinkedList<Player>();
        pile = new LinkedList<Card>();
        dealer = new Dealer();
        patterns = new String[]{"doubles", "top bottom", "sandwich"};
        
        int cardsForPlayers = dealer.size() / numPlayers;
        for (int i = 0; i < numPlayers; i++){
            LinkedList<Card> hand = dealer.deals(cardsForPlayers);
            String pattern = patterns[new Random().nextInt(patterns.length)];
            players.add(new Player(i + 1, hand, pattern)); // assuming Player constructor takes an index, hand, and pattern
        }
    }

    // Play the game until there is only one player left with cards
    public int play(){
        int currentPlayerIndex = 0; // Index of the current player

        while (players.size() > 1){ // Game continues while more than one player remains
            Player currentPlayer = players.get(currentPlayerIndex);

            // Each player plays a card
            Card playedCard = currentPlayer.playCard();

            if (playedCard == null){
                // If the player has no cards, remove them from the game
                System.out.println("Player " + currentPlayer.getPlayerNum() + " is out of cards!!!");
                players.remove(currentPlayerIndex);
                
                if (players.size() == 1) break; // terminate the game if only one player remains

                // Adjust currentPlayerIndex to avoid invalid index after removal
                // If we removed the last player, set the index back to 0
                // the if statement was taken from chat as I Was experiencing an infinite loop after running the code a few more times
                if (currentPlayerIndex == players.size()) {
                    currentPlayerIndex = 0;  // Reset to the first player
                }

                continue; // Move to the next player
            }

            // Add the card to the pile.
            pile.add(playedCard);
            System.out.println("Player " + currentPlayer.getPlayerNum() + " plays " + playedCard);

            // Check if the player can slap based on their assigned pattern
            // below was achieved by the help of student Kevin Orpeza as well as chatgpt
            String pattern = currentPlayer.getPattern(); // Get the player's slap pattern

            boolean slapped = false;
            if (pattern.equals("doubles") && doubles(pile)) {
                System.out.println("Player " + currentPlayer.getPlayerNum() + " slaps doubles!"); // statement written thanks to Kevin Orpeza
                slapped = true;
            } else if (pattern.equals("top bottom") && topBottom(pile)) {
                System.out.println("Player " + currentPlayer.getPlayerNum() + " slaps top-bottom!"); // statement written thanks to Kevin Orpeza
                slapped = true;
            } else if (pattern.equals("sandwich") && sandwich(pile)) {
                System.out.println("Player " + currentPlayer.getPlayerNum() + " slaps sandwich!"); // statement written thanks to Kevin Orpeza
                slapped = true;
            }

            // If the player slaps, they take the pile
            if (slapped) {
                currentPlayer.addCards(pile);
                pile.clear();
                currentPlayerIndex = players.indexOf(currentPlayer); // keep the same player as they won the pile
            }

            // Update the currentPlayerIndex to move to the next player
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size(); // This line ensures the index loops correctly when we reach the end of the list
        }
        return players.get(0).getPlayerNum(); // return the player number of the winner
    }

    // 4. STATIC METHODS
    public static boolean doubles(LinkedList<Card> pile){
        if (pile.size() < 2) return false;
        return pile.get(pile.size() - 1).equals(pile.get(pile.size() - 2));
    }

    public static boolean sandwich(LinkedList<Card> pile){
        if (pile.size() < 3) return false;
        return pile.get(pile.size() - 1).equals(pile.get(pile.size() - 3));
    }

    public static boolean topBottom(LinkedList<Card> pile){
        if (pile.isEmpty()) return false;
        return pile.get(pile.size() - 1).equals(pile.get(0));
    }

    // 5. Accessor methods for member variables
    public LinkedList<Player> getPlayers() {
        return players;
    }

    public LinkedList<Card> getPile() {
        return pile;
    }

    public Dealer getDealer() {
        return dealer;
    }
}