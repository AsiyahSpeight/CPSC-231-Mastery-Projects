public class BurritoOrder {
    /**
     * BurritoOrder Class:
     * This is a class that stores information about an order of potentially multiple Burritos. 
     * 
     * @author Asiyah Speight
     * @version 1.0.0
     * @see ChipotleDriver
     * 
     * The class contains the following:
     * 1. Private member variables
     *  - m_order
     *      - a private member variable classified as an array of base type burrito.
     *      - each element saved in this array should be a Burrito object.
     *  - m_numBurritos
     *      - a private member vairable, classified as an integer (int), which tells how many Burritos are currently in the order
     *  - m_numBurritosMax
     *      - a private member variable, classified as an integer (int), which tells us how many Burritos there will be in the order total (size of the m_order array)
     * 
     * 2. A Defualt Constructor
     *  - This constructor will default to an order of a single Burrito.
     * 
     * 3. An Overloaded Constructor
     *  - which takes an interger parameter that tells how many burritos will be added ot the order
     *  - initializes the order instance variable to an empty Burrito array of that size.
     * 
     * 4. public int addBurrito(Burrito b)
     *  - add the parameter Burrito object to the BurritoOrder’s m_order member variable. Given that the order is saved as a Burrito array.
     *  - REMINDER; once the order is full you will not be able to add more Burrito
     *  - NOTE; If the addition was successful the method should return a 1 and if unsuccessful (array is full) return -1.
     * 
     * 5. public double calcTotal()
     *  - returns the total cost of the order by adding up the prices of each Burrito in the order.
     *  - HINT: use the calcCost method from the Burrito class for each Burrito object in the m_order array.
     * 
     * 6. public String toString()
     *  - returns a String representing this order, so that the employee at Chipotle can repeat the order back to you before sending it to be prepared. 
     *  - This method should begin by calling the calcTotal() method so that the total price of the order can be displayed at the top. Then, it should list all of the details of all Burritos in the order.
     */

    /**
     * 1) MEMBER VARIABLES
     * to store the following:
     * - m_order; a private member variable classified as an array of base type burrito, each element saved in this array should be a Burrito object. size of the burrito either regular or kids
     * - m_numBurritos; A private member variable, which tells how many Burritos are currently in the order.
     * - m_numBurritosMax; A private member variable, which tells how many Burritos there will be in the order total (size of the m_order array)
     */

    private Burrito[] m_order; // a private member variable classified as an array of base type burrito, each element saved in this array should be a Burrito object.
    private int m_numBurritos; // a private member vairable, classified as an integer (int), which tells how many Burritos are currently in the order
    private int m_numBurritosMax; // a private member variable, classified as an integer (int), which tells us how many Burritos there will be in the order total (size of the m_order array)

    /**
     * 2) DEFAULT CONSTRUCTOR
     * This constructor will default to an order of a single Burrito.
     */
    public BurritoOrder(){
        m_numBurritosMax = 1; // maximum number of burritos in this order will be 1 by default
        m_order = new Burrito[m_numBurritosMax]; // an array with a size of 1 it can hold only one Burrito object.
        m_order[0] = new Burrito(); // The array's first element (m_order[0]) is initialized as a new Burrito
        m_numBurritos = 1; // keeps track of how many burritos are in the current order
    }

    /**
    * 3) OVERLOADED CONSTRUCTOR
    * This constructor takes an integer parameter that tells how many Burritos will be added to the order and initializes the order instance variable to an empty Burrito array of that size
    */

    public BurritoOrder(int burritoMax){
        m_numBurritosMax = burritoMax;
        m_order = new Burrito[m_numBurritosMax];
        m_numBurritos = 0;
    }

    /**
     * 4) public int addBurrito(Burrito b)
     * 
     *  - add the parameter Burrito object to the BurritoOrder’s m_order member variable. Given that the order is saved as a Burrito array.
     *  - REMINDER; once the order is full you will not be able to add more Burrito
     *  - NOTE; If the addition was successful the method should return a 1 and if unsuccessful (array is full) return -1.
     */
    public int addBurrito(Burrito b){
        if (m_numBurritos < m_numBurritosMax) {
            m_order[m_numBurritos] = b;
            m_numBurritos++;

            return 1; // The burrito was successfully added
        }
        return -1; // The currect order is full
    }

    /**
     * 5) public double calcTotal()
     * 
     *  - returns a String representing this order, so that the employee at Chipotle can repeat the order back to you before sending it to be prepared. 
     *  - This method should begin by calling the calcTotal() method so that the total price of the order can be displayed at the top. Then, it should list all of the details of all Burritos in the order.
     */
    public double calcTotal(){
        double totalCost = 0;

    // for loop through each burrito in the order
    for (int i = 0; i < m_numBurritos; i++) {
        // Cost of each burrito using the calcCost() method from the Burrito class
        totalCost += m_order[i].calcCost();
     }
    return totalCost;
    }

    /**
     * 6) public String toString()
     * 
     * - returns a String representing this order, so that the employee at Chipotle can repeat the order back to you before sending it to be prepared. 
     *  - This method should begin by calling the calcTotal() method so that the total price of the order can be displayed at the top. Then, it should list all of the details of all Burritos in the order.
     */
    public String toString(){
        String bo = ""; // bo is for burrito order.

        // Add up total cost
        bo += "Total Cost: $" + String.format("%.2f", calcTotal()) + "\n"; // "%.2f"; added from ChatGPT

        bo += "The following Burritos are in your order: \n";
        for (int i = 0; i < m_numBurritos; i++) {
            bo += "\t* Burrito " + (i + 1) + ": " + m_order[i].toString() + "\n";
        }
        return bo; // returns the final string that represents the burrito order
    }

}