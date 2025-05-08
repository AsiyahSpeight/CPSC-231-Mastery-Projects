// 3B/Player.java

import java.util.LinkedList;

/* The Assignment
// Now that you've built an awesome OO framework for playing cards, let's use what you've done to
// program an actual card game: ERS!
You will not be getting user input to play the game, but instead simulating the gameplay using
probability and printing out a record of the gameplay along with the winner of the game.
*/

// The Player class consists of the following member variables:
// m_playerNum - an integer to identify which player it is
// LinkedList<Card> m_hand - a list of cards that the player has in their hand, the first element in the list is considered to be on "top" and new cards should be added to the "bottom" (end of the list)
// a String representing the type of pattern this player watches for, chosen at random from the Game class's patterns array
public class Player {

    // 1. MEMBER VARIABLES
    private int m_playerNum; // an integer (1, 2, etc) to identify which player it is 
    private LinkedList<Card> m_hand; // a list of cards that the player has in their hand
    private String m_pattern; // a String representing the type of pattern this player watches for

    // 2. OVERLOADED CONSTRUCTOR
    public Player(int playerNum, LinkedList<Card> h, String p) {
        this.m_playerNum = playerNum;
        this.m_hand = h;
        this.m_pattern = p;
    }

    // Removes a card from the top of the player's hand (position 0) and returns it
    public Card playCard() {
        if (m_hand.isEmpty()) {
            System.out.println("Player " + m_playerNum + " is out of cards!!!");
            return null; // player ran out of cards
        }
        return m_hand.removeFirst(); // remove and return the card at the top of the hand
    }

    // Checks if player is following the guideline of the game, by "slapping" the pile if the top card matches the pattern
    public boolean slaps(LinkedList<Card> pile) {
        boolean result = false; // Default result
    
        // Evaluate if the top cards in the pile match the player's pattern, this part was written thanks to Kevin Orpeza, after many iterations of the code, and many errors
        switch (m_pattern) {
            case "doubles":
                result = Game.doubles(pile); // Calls Game's static method 
                break;
            case "sandwich":
                result = Game.sandwich(pile); // Calls Game's static method
                break;
            case "top bottom":
                result = Game.topBottom(pile); // Calls Game's static method
                break;
            default:
                result = false;
        }
    
        // Print the action of the player slapping for the pattern
        if (result) {
            System.out.println("Player " + m_playerNum + " slaps for " + m_pattern + "!");
        }
    
        // Return the result
        return result;
    }
    
    // Adds a card to the bottom of the player's hand
    public void addCard(Card c) {
        m_hand.addLast(c); // add the card to the bottom of the hand
    }

    // Add more than one card to the bottom of the player's hand
    public void addCards(LinkedList<Card> cards) {
        m_hand.addAll(cards); // add all the cards to the bottom of the hand
        System.out.println("Player " + m_playerNum + " has " + cards.size() + " cards.");
    }

    // player ran out of cards
    public boolean outOfCards() {
        return m_hand.isEmpty();
    }

    // Accessor method
        // Accessor methods for all member variables: getPlayerNum(), getHand(), getPattern() etc
    public int getPlayerNum() {
        return m_playerNum;
    }

    public LinkedList<Card> getHand() {
        return m_hand;
    }

    public String getPattern() {
        return m_pattern;
    }

    // toString Method
    // toString that returns the Player’s number, pattern, and current hand of cards
    @Override
    public String toString() {
        return "Player " + m_playerNum + " with pattern " + m_pattern + " has " + m_hand.size() + " cards.";
    }
}