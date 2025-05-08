//3B/Driver.java
/**
 * This class includes a main method where you will play a single game. You can also use this to test your 
 * code as you develop it.
 * You should add several print statements to your code within each method to show what the simulated game 
 * is doing and debug the choices your players are making. These will not be 
 * auto-graded, but will help you throughout the development process.
 */
public class Driver {
    public static void main(String[] args){
        System.out.println("Game Begin!");

        // we start the game with 3 players
        Game game = new Game(3);

        // Debugging - in case we run into any problems
        System.out.println("Primary game setup:");
        for (Player player:game.getPlayers()){
            System.out.println(player);
        }
        System.out.println();

        // lets play the game
        int winner = game.play();

        // Display winner
        System.out.println("GAME OVER! AHAHAHAHAHAHA!!!!!!");
        System.out.println("PLAYER " + winner + " WINS!!!");
    }
}