import java.util.*;


abstract class Contestant {
    protected String name;
    protected int age;
    protected int strength;
    protected int intelligence;
    protected int charisma;
    private int wins;
    protected LinkedList<Contestant> allies;

    public Contestant(String name, int age, int strength, int intelligence, int charisma) {
        this.name = name;
        this.age = age;
        this.strength = strength;
        this.intelligence = intelligence;
        this.charisma = charisma;
        this.wins = 0;
        this.allies = new LinkedList<>();
    }

    // Abstract methods for subclasses to implement
    public abstract void competeInChallenge();
    public abstract void formAlliance(LinkedList<Contestant> contestants);

    // Adds an ally with mutual alliance check
    public void addAlly(Contestant ally) {
        if (!allies.contains(ally) && ally != this) {
            allies.add(ally);
            if (!ally.allies.contains(this)) {
                ally.allies.add(this);
            }
            System.out.println(name + " has allied with " + ally.name);
        }
    }

    // Adds a win to the contestant's record
    public void addWin() {
        wins++;
    }

    public int getWins() {
        return wins;
    }

    public String getName() {
        return name;
    }

    // Getters for specific skills
    public int getStrength() {
        return strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getCharisma() {
        return charisma;
    }

    // Static helper methods to generate skill values
    protected static int generateMaxPrimarySkill() {
        return 90 + new Random().nextInt(11); // Generates a high value for primary skill (90-100)
    }

    protected static int generateRandomSkill() {
        return 40 + new Random().nextInt(51); // Generates a random value for secondary skills (40-90)
    }

    @Override
    public String toString() {
        String s = "";
        s += "Name: " + name + "\n";
        s += "Age: " + age + "\n";
        s += "Wins: " + wins + "\n"; 
        s += "Characteristics: \n";
        s += "\tStrength: " + strength + "\n"; 
        s += "\tIntelligence: " + intelligence + "\n"; 
        s += "\tCharisma: " + charisma + "\n"; 
        if (allies.size() > 0){
            s += "Allies: ";
            for (Contestant c: allies){
                s += c.getName() + " ";
            }
            s += "\n";
        }
        return s;
    }
}