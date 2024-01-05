public class River extends BattleLoc{

    public River(Player player) {
        super(player, "River", new Bear(), "Water", 2);
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in the river !");
        return super.onLocation();
    }
}