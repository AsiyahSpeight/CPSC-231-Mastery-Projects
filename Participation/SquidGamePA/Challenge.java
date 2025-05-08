import java.util.*;


// BASE CLASS FOR CHALLENGE 
abstract class Challenge {
    protected String type;

    public Challenge(String type) {
        this.type = type;
    }

    // Abstract method to conduct the challenge and determine the winner
    public abstract Contestant compete(LinkedList<Contestant> contestants);

    public String getType() {
        return type;
    }
}


// STRENGTH CHALLENGE CLASS
class StrengthChallenge extends Challenge {
    private Random random;

    public StrengthChallenge() {
        super("Strength");
        this.random = new Random();
    }

    @Override
    public Contestant compete(LinkedList<Contestant> contestants) {
        Contestant winner = null;
        int highestScore = -1;

        System.out.println("\n--- Strength Challenge ---");

        for (Contestant contestant : contestants) {
            int score = contestant.getStrength() + random.nextInt(20); // Adds a random factor for variability
            System.out.println(contestant.getName() + " scored " + score + " in the Strength challenge.");

            if (score > highestScore) {
                highestScore = score;
                winner = contestant;
            }
        }

        System.out.println("Winner of the Strength challenge is " + winner.getName() + "!\n");
        return winner;
    }
}


// INTELLIGENCE CHALLENGE CLASS

class IntelligenceChallenge extends Challenge {
    private Random random;

    public IntelligenceChallenge() {
        super("Intelligence");
        this.random = new Random();
    }

    @Override
    public Contestant compete(LinkedList<Contestant> contestants) {
        Contestant winner = null;
        int highestScore = -1;

        System.out.println("\n--- Intelligence Challenge ---");

        for (Contestant contestant : contestants) {
            int score = contestant.getIntelligence() + random.nextInt(20);
            System.out.println(contestant.getName() + " scored " + score + " in the Intelligence challenge.");

            if (score > highestScore) {
                highestScore = score;
                winner = contestant;
            }
        }

        System.out.println("Winner of the Intelligence challenge is " + winner.getName() + "!\n");
        return winner;
    }
}


// CHARISMA CHALLENGE CLASS
class CharismaChallenge extends Challenge {
    private Random random;

    public CharismaChallenge() {
        super("Charisma");
        this.random = new Random();
    }

    @Override
    public Contestant compete(LinkedList<Contestant> contestants) {
        Contestant winner = null;
        int highestScore = -1;

        System.out.println("\n--- Charisma Challenge ---");

        for (Contestant contestant : contestants) {
            int score = contestant.getCharisma() + random.nextInt(20);
            System.out.println(contestant.getName() + " scored " + score + " in the Charisma challenge.");

            if (score > highestScore) {
                highestScore = score;
                winner = contestant;
            }
        }

        System.out.println("Winner of the Charisma challenge is " + winner.getName() + "!\n");
        return winner;
    }
}



