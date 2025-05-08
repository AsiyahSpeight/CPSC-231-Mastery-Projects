import java.util.*;


public class SquidGamesDriver {
    public static Random random = new Random(); // static so we can use it anywhere in this class and use the same instance across all methods

    // Helper method to generate a random age between 20 and 70
    private static int randomAge() {
        return 20 + random.nextInt(51);
    }

    // MAIN METHOD
    public static void main(String[] args) {
        // Create a LinkedList to hold the contestants
        LinkedList<Contestant> contestants = new LinkedList<>();

        // Adding various types of contestants 
        contestants.add(new Athlete("Hyeon-woo", randomAge()));
        contestants.add(new Athlete("Jeong-min", randomAge()));
        contestants.add(new Strategist("Ji-yeon", randomAge()));
        contestants.add(new Strategist("Dong-geun", randomAge()));
        contestants.add(new SocialPlayer("Sun-woo", randomAge()));
        contestants.add(new SocialPlayer("Min-seok", randomAge()));
        contestants.add(new PuzzleSolver("Seung-gi", randomAge()));
        contestants.add(new PuzzleSolver("Yoon-jin", randomAge()));

        // Print initial contestant info
        System.out.println("Welcome to Squid Game: The Challenge Reality Show!");
        System.out.println("Here are today's contestants:\n");

        for (Contestant contestant : contestants) {
            System.out.println(contestant);
        }
        System.out.println("\n--- Alliance Formation ---\n");

        // Have each contestant form alliances
        for (Contestant contestant : contestants) {
            contestant.formAlliance(contestants);
        }

        System.out.println("\nLet’s see the alliances formed today!\n");
        for (Contestant contestant : contestants) {
            System.out.println(contestant);
        }
        System.out.println("\n--- Challenge Rounds ---\n");

        // Conduct multiple rounds of challenges
        int rounds = 5;

        for (int i = 1; i <= rounds; i++) {
            // Randomly create a challenge type for each round
            Challenge challenge;
            int challengeType = random.nextInt(3);
            if (challengeType == 0) {
                challenge = new StrengthChallenge();
            } else if (challengeType == 1) {
                challenge = new IntelligenceChallenge();
            } else {
                challenge = new CharismaChallenge();
            }

            // Conduct the challenge and announce the winner
            Contestant winner = challenge.compete(contestants);
            winner.addWin();
            System.out.println("Round " + i + " winner: " + winner.getName() + "! Total wins: " + winner.getWins() + "\n");
        }

        // print total results 
        System.out.println("--- Contestant Performance ---");
        for (Contestant c: contestants){
            System.out.println(c.getName() + " won " + c.getWins() + " challenge(s)");
        }
    }
}