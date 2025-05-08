// PUZZLE 
import java.util.*;

class PuzzleSolver extends Contestant {
    public PuzzleSolver(String name, int age) {
        super(name, age, generateRandomSkill(), generateMaxPrimarySkill(), generateRandomSkill());
    }

    @Override
    public void competeInChallenge() {
        System.out.println(name + " (PuzzleSolver) competes with an intelligence score of " + intelligence);
    }

    @Override
    public void formAlliance(LinkedList<Contestant> contestants) {
        for (Contestant c : contestants) {
            if (c.getIntelligence() >= 70) {
                addAlly(c);
            }
        }
    }
}