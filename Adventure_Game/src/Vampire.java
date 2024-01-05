// Represents a vampire obstacle that the player might encounter in the game
public class Vampire extends Obstacle {

    // Constructor for the Vampire class
    public Vampire() {
        // Initializes the Vampire with specific attributes
        super(2, "Vampire", 4, 14, 7);
    }

    // Overrides the toString method to provide a string representation of the Vampire
    @Override
    public String toString() {
        return "Vampire";
    }
}
