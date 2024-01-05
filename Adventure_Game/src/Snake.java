import java.util.Random;

// Represents an obstacle in the game, specifically a snake
public class Snake extends Obstacle {

    // Weapons and armor that the snake may have
    private Weapon weapon;
    private Armor armor;

    // Constructor for the Snake class
    public Snake() {
        super(4, "Snake", 0, 12, 0);
        setDamage(4);
    }

    // Sets the damage of the snake randomly between 3 and 6
    @Override
    public void setDamage(int damage) {
        Random r = new Random();
        int i = r.nextInt(damage) + 3;
        super.setDamage(i);
    }

    // Provides a string representation of the snake
    @Override
    public String toString() {
        return "Snake";
    }

    // Gets the weapon or armor that the snake has
    public WarDiamond getWarDiamond() {
        if (weapon != null) {
            return weapon;
        } else if (armor != null) {
            return armor;
        }
        return null;
    }

    // Sets the weapon or armor for the snake
    public void setWarDiamond(WarDiamond warDiamond) {
        if (warDiamond instanceof Weapon) {
            this.weapon = (Weapon) warDiamond;
        } else if (warDiamond instanceof Armor) {
            this.armor = (Armor) warDiamond;
        }
    }

    // Determines the random reward (weapon, armor, or money) the snake drops
    public WarDiamond randomWarDiamond() {
        Random r = new Random();
        int i = r.nextInt(101);

        if (i <= 15) {
            Random r2 = new Random();
            int j = r2.nextInt(101);
            // Weapon
            if (j < 20) {
                return Weapon.getWeaponById(3);
            } else if (j < 50) {
                return Weapon.getWeaponById(2);
            } else if (j >= 50) {
                return Weapon.getWeaponById(1);
            }
        } else if (i > 15 && i <= 30) {
            Random r2 = new Random();
            int j = r2.nextInt(101);
            // Armor
            if (j < 20) {
                return Armor.getArmorById(3);
            } else if (j < 50) {
                return Armor.getArmorById(2);
            } else if (j >= 50) {
                return Armor.getArmorById(1);
            }
        } else if (i > 30 && i <= 55) {
            Random r2 = new Random();
            int j = r2.nextInt(101);
            // Probability of earning money
            if (j < 20) {
                this.setAward(10);
                System.out.println("You earned 10 coins!");
            } else if (j < 50) {
                this.setAward(5);
                System.out.println("You earned 5 coins!");
            } else if (j >= 50) {
                this.setAward(1);
                System.out.println("You earned 1 coin!");
            }
        } else {
            System.out.println("Nothing found from the snake!");
        }
        return null;
    }
}
