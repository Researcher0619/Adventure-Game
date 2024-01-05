// Class representing zombies, extends Obstacle class
public class Zombie extends Obstacle {

    // Constructor to initialize zombie properties
    public Zombie() {
        super(1, "Zombie", 3, 10, 4);
    }

    // Override the toString method to provide a string representation of the zombie
    @Override
    public String toString() {
        return "Zombie";
    }
}
