
// TO DO: STRATEGIST 
import java.util.*;

class Strategist extends Contestant {
    public Strategist(String name, int age) {
        super(name, age, generateRandomSkill(), generateMaxPrimarySkill(), generateRandomSkill());
    }

    @Override
    public void competeInChallenge() {
        System.out.println(name + "(Strategist) competes with an intelligence score " + intelligence);
        System.out.println("And with a charisma score of " + charisma);
    }

    @Override
    public void formAlliance(LinkedList<Contestant> contestants) {
        for (Contestant c : contestants) {
            if (c.getIntelligence() >= 100 && c.getCharisma() >= 80) {
                addAlly(c);
            }
        }
    }
}