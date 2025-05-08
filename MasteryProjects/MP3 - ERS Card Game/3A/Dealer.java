import java.util.LinkedList;

public class Dealer {
  /**
   * Dealer
   * The Dealer class is responsible for managing the cards in the deck during gameplay. It consists of a single attribute m_deck of type Deck.
   * 
   * It consists of the following methods:
   * 1. A default constructor that initializes m_deck to a new Deck of 52 cards
   * 2. A method, deals, with the following signature "public LinkedList<Card> deals(int n)"
   *    This method returns a new LinkedList that consists of n cards dealt randomly from the deck. 
   *    If the deck is empty, it should return a LinkedList of length 0.
   * 3. A size method that returns the number of cards in m_deck
   * 4. A toString method that just calls toString on m_deck and returns the result
   *  */ 
    // 1. MEMBER VARIABLES
   private Deck m_deck;

   // 1. DEFAULT CONSTRUCTOR
   // that initializes m_deck to a new Deck of 52 cards
   
   public Dealer() {
    m_deck = new Deck(); // initializes a new deck of 52 cards
   }

   // 2. A METHOD THAT DEALS WITH "public LinkedList<Card> deals(int n)"
   // This method returns a new LinkedList that consists of n cards dealt randomly from the deck. 
   // If the deck is empty, it should return a LinkedList of length 0.

   public LinkedList<Card> deals(int n) {
    LinkedList<Card> cardsDealt = new LinkedList<>();
    n = Math.min(n, m_deck.size()); // taken from Kevin Orpeza, which states that to ensure no more cards are dealt than available
    for (int i = 0; i < n; i++) {
        if (m_deck.size() > 0) {
            cardsDealt.add(m_deck.deal());
        } else {
            break;
        }
    }
    return cardsDealt; // return the list of dealt cards, may be less than n if the deck runs out
   }

   // 3. SIZE METHOD
   // returns the number of cards in m_deck
   public int size() {
    return m_deck.size();
   }

   // 4. TO STRING METHOD
   // just calls toString on m_deck and returns the result
   @Override 
   public String toString() {
    return m_deck.toString();
   }
}
