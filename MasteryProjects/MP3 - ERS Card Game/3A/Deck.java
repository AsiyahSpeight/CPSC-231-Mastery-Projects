import java.util.LinkedList;
import java.util.Random;

/**
 * Deck
 * 
 * A new Deck consists of all 52 cards (a card of each rank and suit) in a LinkedList<Card> data structure 
 * called m_cards. It contains the following methods:
 * 
 *  1. A default constructor that initializes a fresh deck of 52 cards in the linked list
 *  2. A copy constructor that creates a deck from another deck, making sure to make a deep copy of each card
 *  3. A toString method that displays each card currently in the deck
 *  4. A size method that returns the number of cards in the underlying LinkedList<Card> as an integer
 *  5. A method, deal, that removes a random card from the list and returns that card
 */
public class Deck {
    private LinkedList<Card> m_cards;

    // 1. DEFAULT CONSTRUCTOR
    public Deck() {
        m_cards = new LinkedList<>();
        for (int suit = Card.HEARTS; suit <= Card.DIAMONDS; suit++){
            for (int rank = 2; rank <= Card.ACE; rank++){
                m_cards.add(new Card(rank, suit));
            }
        }
    }

    // 2. COPY CONSTRUCTOR
    public Deck(Deck other) { // Kevin Orpeza assisted in starting this
        m_cards = new LinkedList<>();
        for (Card card : other.m_cards) {
            this.m_cards.add(new Card(card.getSuit(), card.getRank()));
        }
    }

    // 3. TO STRING METHOD
    public String toString() {
        return m_cards.toString();
    }

    // 4. SIZE METHOD
    public int size() {
        return m_cards.size();
    }

    // 5. DEAL METHOD 
    public Card deal() {
        if (m_cards.isEmpty()) {
            return null;
        }
        Random rand = new Random();
        int index = rand.nextInt(m_cards.size());
        return m_cards.remove(index);
    }
}

