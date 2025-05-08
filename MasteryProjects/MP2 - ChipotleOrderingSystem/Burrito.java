public class Burrito {
    /**
      Burrito Class:
     This is the first of two classes built in this assignment. This class stores information about a single burito. Uses member variables
     that will consist of size of the burrito, type of protein in the burrito, type of rice and type of bean. Other member variables include
     boolean member variables. Guacamole, tomatillo salsa, sour cream, cheese, lettuce. 
     
     @author Asiyah Speight
     @version 1.0.0
     @see ChipotleDriver
     
     The Burrito Class will have the following organized in there prespective code blocks:
     
    1. Private member variables will be stored as the first step. 
    2. Default constructor
        - creates a default burrito which is regular-sized with chicken, white rice, black beans, lettuce and sour cream.
    3. Fully specified, overloaded constructor
        - that sets all of the member variables as given.
    4. Copy constructor 
        - using the appropriate shallow or deep copies for member variables.
    5. Public accessors & mutators
        - used for some of the member variables

    Later in the code a public method named calcCost(), which will return a double that us the cost of the burrito. Burrito cost will be determined by the following
        - Size:
            - kids: $7.00
            - Regular: $9.00
        - Protein
            - +$0.50 for chicken
            - $1.25 for steak
            - $0.50 for veggie
        - Extras
            - +$2.65 for Guacamole unless the protein is “veggie” in which case, guacamole is included.
            - +$0 for Tomatillo salsa
            - +$0.25 for Sour cream
            - +$0.50 for Cheese
            - +$0 for Lettuce
        - To note the "default" Burrito will have the following and come out to be a total of $9.75. With the following breakdown:
            - size -> regular +$9
            - chicken -> +$0.50
            - Sour cream -> +$0.25
            - lettuce -> +$0
    A public method named toString() that returns a string containing the Burritos member variable values and cost as calculated by calcCost(), will be built
    later on in the code
    Another public method name equals(), will be built. This method will return a Boolean to determine if two burritos are "equal". we will assume two burritos are equal if they have all the same member variables.

    A test will be conducted to make sure the Burrito class works, and has the outcome we want. 
     */

    /**
     * 1) MEMBER VARIABLES (PRIVATE): 
     * to store the following:
     *  - m_size; size of the burrito either regular or kids
     *  - m_protein; choices may be chicken, steak, veggie
     *  - m_rice; type of rice: white, brown, or no rice
     *  - m_beans; type of beans: black, pinto, np beans
     *  - m_guac; Guacamole
     *  - m_tomatillo; Tomatillo salsa
     *  - m_sourCream; Sour Cream
     *  - m_cheese; Cheese
     *  - m_lettuce; Lettuce
     */

    // String member variables
    private String m_size; // size of the burrito either regular or kids
    private String m_protein; // choices may be chicken, steak, veggie
    private String m_rice; // type of rice: white, brown, or no rice
    private String m_beans; // type of beans: black, pinto, np beans

    // Boolean member variables
    private boolean m_guac;
    private boolean m_tomatillo;
    private boolean m_sourCream;
    private boolean m_cheese;
    private boolean m_lettuce;
    
     /**
    * 2) DEFAULT CONSTRUCTOR
    * the constructor will have no parameters, all will be set to default. Creates a default burrito which is regular-sized 
    * with chicken, white rice, black beans, lettuce and sour cream
     */
    public Burrito(){
        m_size = "regular";
        m_protein = "chicken";
        m_rice = "white rice";
        m_beans = "black beans";
        
        m_guac = false;
        m_tomatillo = false;
        m_sourCream = true;
        m_cheese = false;
        m_lettuce = true;
    }

    /**
     * 3) FULLY SPECIFIED, OVERLOADED CONSTRUCTOR
     * that sets all of the member variables as given
     */
    public Burrito(String sze, String p, String r, String b, boolean guac, boolean tomati, boolean sourCream, boolean cheese, boolean lettuce){
        m_size = sze;
        m_protein = p;
        m_rice = r;
        m_beans = b;

        m_guac = guac;
        m_tomatillo = tomati;
        m_sourCream = sourCream;
        m_cheese = cheese;
        m_lettuce = lettuce;
    }

    /**
     * 4) COPY CONSTRUCTOR
     * using the appropriate shallow or deep copies for member variables.
     * 
     * Below is a shallow copy.
     */
    public Burrito (Burrito burritoToCopy){
        m_size = burritoToCopy.m_size;
        m_protein = burritoToCopy.m_protein;
        m_rice = burritoToCopy.m_rice;
        m_beans = burritoToCopy.m_beans;

        m_guac = burritoToCopy.m_guac;
        m_tomatillo = burritoToCopy.m_tomatillo;
        m_sourCream = burritoToCopy.m_sourCream;
        m_cheese = burritoToCopy.m_cheese;
        m_lettuce = burritoToCopy.m_lettuce;
    }

    /**
     * 5) PUBLIC ACCESSORS & MUTATORS
     * for some of the member variables. I choose to do all to air on the side of caution.
     * 
     *  - Accessors
     *      - known as getters will return the value of a member variable. They are always public. 
     *        have no parameters, and return the value of a member variable
     *  - Mutators
     *      - known as setters will allow to change the value of a member variable
     */
    // Acessors (getters)
    public String getM_size(){
        return m_size;
    }
    public String getM_protein(){
        return m_protein;
    }
    public String getM_rice(){
        return m_rice;
    }
    public String getM_beans(){
        return m_beans;
    }
    public boolean getM_tomatillo(){
        return m_tomatillo;
    }
    public boolean getM_guac(){
        return m_guac;
    }
    public boolean getM_sourCream(){
        return m_sourCream;
    }
    public boolean getM_cheese(){
        return m_cheese;
    }
    public boolean getM_lettuce(){
        return m_lettuce;
    }

    //Mutators (setters)
    public void setSize(String sze){
        m_size = sze;
    }
    public void setProtein(String p){
        m_protein = p;
    }
    public void setRice(String r){
        m_rice = r;
    }
    public void setBeans(String b){
        m_beans = b;
    }
    public void setGuac(boolean guac){
        m_guac = guac;
    }
    public void setTomatillo(boolean tomati){
        m_tomatillo = tomati;
    }
    public void setSourcream(boolean sourCream){
        m_sourCream = sourCream;
    }
    public void setCheese(boolean cheese){
        m_cheese = cheese;
    }
    public void setLettuce(boolean lettuce){
        m_lettuce = lettuce;
    }

    /**
     * calcCost() method
     *  - this is a method that returns a double. This method represents the cost of the Burrito. 
     *  - Burrito cost are determined by the following:
     *      - Size:
            - kids: $7.00
            - Regular: $9.00
        - Protein
            - +$0.50 for chicken
            - $1.25 for steak
            - $0.50 for veggie
        - Extras
            - +$2.65 for Guacamole unless the protein is “veggie” in which case, guacamole is included.
            - +$0 for Tomatillo salsa
            - +$0.25 for Sour cream
            - +$0.50 for Cheese
            - +$0 for Lettuce
        - To note the "default" Burrito will have the following and come out to be a total of $9.75. With the following breakdown:
            - size -> regular +$9
            - chicken -> +$0.50
            - Sour cream -> +$0.25
            - lettuce -> +$0
     */

     // Method to calculate the cost of a burrito
     public double calcCost() {
        double cost = 0;

        // Size of the burrito
        if (m_size.equals("kids")) {
            cost += 7.00;
        } else {
            cost += 9.00;
        }

        // Protein choice of for the burrito
        switch (m_protein){
            case "chicken":
            cost += 0.50;
            break;

            case "steak":
            cost += 1.25;
            break;

            case "veggie":
            cost += 0.50;
            if (m_guac) {
                m_guac = false; //the protein is “veggie” in which case, guacamole is included.
            }
            break;
        }

        // cost of extras
        if (m_guac) {
            cost += 2.65;
        } 
        if (m_sourCream) {
            cost += 0.25;
        }
        if (m_cheese) {
            cost += 0.50;
        }
        if (m_tomatillo) {
            cost += 0;
        }
        if (m_lettuce) {
            cost += 0;
        }

        return cost;
     }

     /**
      * toString Method
      A public method that displays the member variable values for an object.
      */

     // toString method
     public String toString(){
        String s = "";

        s += "\tBurrito Details:\n";
        s += "\tSize :" + m_size + "\n";
        s += "\tProtein: " + m_protein + "\n";
        s += "\tRice: " + m_rice + "\n";
        s += "\tBeans: " + m_beans + "\n";
        
        s += "\tGuacamole: " + (m_guac ? "Yes" : "No") + "\n"; // the LLM ChatGPT assisted me in getting this line of code, the rest was self explanatory.
        s += "\tTomatillo: " + (m_tomatillo ? "Yes" : "No") + "\n"; // LLM ChatGPT
        s += "\tSour Cream: " + (m_sourCream ? "Yes" : "No") + "\n"; // LLM ChatGPT
        s += "\tCheese: " + (m_cheese ? "Yes" : "No") + "\n"; // LLM ChatGPT
        s += "\tLettuce: " + (m_lettuce ? "Yes" : "No") + "\n"; // LLM ChatGPT
        
        s += "\tCost: $" + calcCost() + "\n"; // commet from ChatGPT; "call calcCost() to include the burrito cost"

        return s;
     }

     /**
      * public method name equals():
        - that returns a Boolean to determine if two Burritos are “equal.” You can assume two Burritos are equal if they have all the same member variables
      */
      public boolean equals(Object bur){
        if (this == bur) {
            // checking whether a and the object the method was called upon share the same memory address
            // if they share the same the same address then they are the same object so they equal
            return true;
        }
        // if Object a is not a Burrito type object then we for sure know they are not equal
        if (! (bur instanceof Burrito)) {
            // a is not of type Burrito
            return false;
        }

        Burrito buri = (Burrito) bur;
        // the symbol "&&" was added thanks LLM ChatGPT
        return this.m_size.equals(buri.m_size) 
        && this.m_protein.equals(buri.m_protein)
        && this.m_rice.equals(buri.m_rice)
        && this.m_beans.equals(buri.m_beans)
        
        && this.m_guac == buri.m_guac
        && this.m_tomatillo == buri.m_tomatillo
        && this.m_sourCream == buri.m_sourCream
        && this.m_cheese == buri.m_cheese
        && this.m_lettuce == buri.m_lettuce;
      }

}   
