public class Armor implements WarDiamond{

    private int id;
    private String name;
    private int block;
    private int price;

    public Armor(int id, String name, int block, int price) {
        this.id = id;
        this.name = name;
        this.block = block;
        this.price = price;
    }

    public static Armor[] armors() {
        Armor[] armorsList = new Armor[3];
        armorsList[0] = new Armor(1, "Light Armor", 1, 15);
        armorsList[1] = new Armor(2, "Medium Armor", 3, 25);
        armorsList[2] = new Armor(3, "Heavy Armor", 5, 40);
        return armorsList;
    }

    public static Armor getArmorById(int id) {
        for (Armor armor : Armor.armors()) {
            if (armor.getId() == id) {
                return armor;
            }
        }
        return null;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getBlock() { return block; }

    public void setBlock(int block) { this.block = block; }

    public int getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }

    @Override
    // Since it implements the WarDiamond interface, we are obligated to override this method.
    public Object getWarDiamond() {
        return this;
    }

    @Override
    public String toString() {
        return "Armor" +
                " = " + name + " ";
    }
}
