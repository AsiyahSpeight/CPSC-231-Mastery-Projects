import java.util.LinkedList;

public class testCards {
    /*
     * the testCards.java is the driver. it has the main method where you will test the functionality of the following classes:
     * - Card
     * - Deck
     * - Dealer
     */

    // Kevin Orpeza assisted in the outline
     public static void main(String[] args) {
        // Dealer Object
        Dealer dealer = new Dealer();

        // print full deck
        System.out.println("Deck before dealing:");
        System.out.println(dealer);

        // Deal 5 cards
        LinkedList<Card> cardsDealt = dealer.deals(5);

        // print the cards that were dealt
        System.out.println("\nDealt Cards:");
        for (Card card : cardsDealt){
            System.out.println(card);
        }

        // print the dealers deck after dealing 5 cards
        System.out.println("\nDeck after dealing 5 cards:");
        System.out.println(dealer);
     }
}
