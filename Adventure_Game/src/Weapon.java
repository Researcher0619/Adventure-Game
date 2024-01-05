// Class representing weapons, implements WarDiamond interface
public class Weapon implements WarDiamond {

    private int id;
    private String name;
    private int damage;
    private int price;

    // Constructor to initialize weapon properties
    public Weapon(int id, String name, int damage, int price) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.price = price;
    }

    // Static method to get an array of predefined weapons
    public static Weapon[] weapons() {
        Weapon[] weaponsList= new Weapon[3];
        weaponsList[0] = new Weapon(1, "Pistol", 2, 5);
        weaponsList[1] = new Weapon(2, "Sword", 3, 35);
        weaponsList[2] = new Weapon(3, "Rifle", 7, 45);
        return weaponsList;
    }

    // Static method to get a weapon by its ID
    public static Weapon getWeaponById(int id) {
        for (Weapon weapon : Weapon.weapons()) {
            if (weapon.getId() == id) {
                return weapon;
            }
        }
        return null;
    }

    // Getter and setter methods for class properties

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // Override the getWarDiamond method from the WarDiamond interface
    @Override
    public Object getWarDiamond() {
        return this;
    }

    // Override the toString method to provide a string representation of the weapon
    @Override
    public String toString() {
        return "Weapon" +
                " = " + name + " ";
    }
}
