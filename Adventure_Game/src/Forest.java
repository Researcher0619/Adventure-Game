public class Forest extends BattleLoc {

    public Forest(Player player) {
        super(player, "Forest", new Vampire(), "Firewood", 3);
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in the forest!");
        return super.onLocation();
    }
}
