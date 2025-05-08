// TO DO: SOCIAL PLAYER
import java.util.*;

class SocialPlayer extends Contestant {
    public SocialPlayer(String name, int age) {
        super(name, age, generateRandomSkill(), generateMaxPrimarySkill(), generateRandomSkill());
    }

    @Override
    public void competeInChallenge() {
        System.out.println(name + "(SocialPlayer) competes with an extroverted score of " + charisma);
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
 