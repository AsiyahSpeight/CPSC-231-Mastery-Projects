// ChipotleDriver class declaration 
public class ChipotleDriver {
/**
 * ChipotleDriver
 * 
 * This class will serve as a driver class to your Burrito and BurritoOrder classes. It should therefore
 * contain only a main method and be the only class that contains one. Below is some code illustrating
 * the methods of Burrito and BurritoOrder. **Note that first few lines are incomplete. Fill them in and
 * include this code in the main method
 */

// main method declaration 
public static void main(String[] args){
    Burrito defaultBurrito = new Burrito();

    // veggieBurrito: regular, veggie, white rice, pinto beans, guacamole, lettuce, tomatillo 
    Burrito veggieBurrito = new Burrito("regular", "veggie", "white", "pinto", true, true, false, false, true); // veggieBurrito

    //Same as veggieBurrito, use copy constructor
    Burrito veggieBurrito2 = new Burrito(veggieBurrito);

    // defaultBurrito2: Same as defaultBurrito, use copy constructor
    Burrito  defaultBurrito2 = new Burrito(defaultBurrito);

    // order; an order of THREE burritos
    BurritoOrder order = new BurritoOrder(3);

    // add defaultBurrito to the order
    System.out.println(order.addBurrito(defaultBurrito));

    // add veggieBurrito to the order
    System.out.println(order.addBurrito(veggieBurrito));

    // add veggieBurrito2 to the order
    System.out.println(order.addBurrito(veggieBurrito2));

    // add defaultBurrito2 to the order – what happens here? 
    System.out.println(order.addBurrito(defaultBurrito2));

    // are veggieBurrito and veggieBurrito2 the same? should be!
    System.out.print("are veggieBurrito and veggieBurrito2 the same? ");
    System.out.println(veggieBurrito.equals(veggieBurrito2));
    // are veggieBurrito and defaultBurrito the same? shouldn't be...
    System.out.print("are veggieBurrito and defaultBurrito the same? ");
    System.out.println(veggieBurrito.equals(defaultBurrito));

    // Should call order’s toString methods
    System.out.println(order);
    }

}
