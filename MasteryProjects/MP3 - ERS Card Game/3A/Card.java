public class Card {
    /**
     * Card
     * The Card class should consist of:
     *
     * 1. Member variables for a rank (2-10, J, Q, K, A) and a suit (hearts, spades, clubs, diamonds) all stored 
     *    as integers
     * 2. A default constructor which creates an Ace of Spades
     * 3. An overloaded constructor
     * 4. A copy constructor
     * 5. toString method that nicely displays the suit and rank of the card. In particular, suits should be 
     *    represented textually (not by their integer values), as should all face cards 
     *    and aces. Eg. “Queen of Hearts”, “3 of Diamonds”, “Ace of Spades”
     * 6. equals method - assume 2 cards are equal if their ranks are equal
     * 7. Mutators(setRank() & setSuit()) and accessors (getRank() & getSuit()) for rank and suit
     *
     * Within your Card class, you should define constants to be used to set the suit value, eg:
     *    - public static final int HEARTS = 0;
     *    - public static final int SPADES = 1;
     *    - public static final int CLUBS = 2;
     *    - public static final int DIAMONDS = 3;
     *
     * Similarly, the rank of the card should be represented as an integer, with constants to define the rank of face cards, eg:
     *    - public static final int JACK = 11;
     *    - public static final int QUEEN = 12;
     *    - public static final int KING = 13;
     *    - public static final int ACE = 14;
     */

    // card type constants
    public static final int HEARTS = 0;
    public static final int SPADES = 1;
    public static final int CLUBS = 2;
    public static final int DIAMONDS = 3;

    // rank of the card in constants
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    public static final int ACE = 14;

    // 1. MEMBER VARIABLES
    private int m_cardRank;
    private int m_cardSuit;

    // 2. DEFAULT CONSTRUCTOR
    public Card() {
        // creates an Ace of spades
        this.m_cardRank = ACE;
        this.m_cardSuit = SPADES;
    }

    // 3. OVERLOADED CONSTRUCTOR
    public Card(int cardRank, int cardSuit) {
        this.m_cardRank = cardRank;
        this.m_cardSuit = cardSuit;
    }

    // 4. COPY CONSTRUCTOR
    public Card(Card copyCard) {
        this.m_cardRank = copyCard.m_cardRank;
        this.m_cardSuit = copyCard.m_cardSuit;
    }

    // 5. TO STRING METHOD
    public String toString() {
        String rank = switch (m_cardRank) {
            case JACK -> "Jack";
            case QUEEN -> "Queen";
            case KING -> "King";
            case ACE -> "Ace";
            default -> Integer.toString(m_cardRank);
        };
        String suit = switch (m_cardSuit) {
            case HEARTS -> "Hearts";
            case SPADES -> "Spades";
            case CLUBS -> "Clubs";
            case DIAMONDS -> "Diamonds";
            default -> "Unknown";
        };
        return rank + " of " + suit;
    }

   // 6. EQUALS METHOD
public boolean equals(Object obj) {
    if (this == obj) return true; // they are the same exact object in memory
    if (!(obj instanceof Card)) return false; // obj is not a Card object, so they cannot be equal

    Card card = (Card) obj; // type cast obj back to Card so we can access its member vars
    return this.m_cardRank == card.m_cardRank; // comparing m_cardRank values
}


    // 7. ACCESSORS & MUTATORS
    public void setRank(int rank) {
        this.m_cardRank = rank;
    }

    public void setSuit(int suit) {
        this.m_cardSuit = suit;
    }

    public int getRank() {
        return m_cardRank;
    }

    public int getSuit() {
        return m_cardSuit;
    }
}