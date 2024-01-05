// SafeHouse class extends NormalLoc, representing a safe location in the game
public class SafeHouse extends NormalLoc {

    // Constructor for SafeHouse class
    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    // Overrides the onLocation method to handle actions when the player is at the safe house
    @Override
    public boolean onLocation() {
        // Displays a message indicating the player is at a safe house and their health is restored
        System.out.println("You are in a safe house. Your health has been restored.");

        // Sets the player's health to its original value
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());

        // Returns true to indicate that the location interaction was successful
        return true;
    }
}
