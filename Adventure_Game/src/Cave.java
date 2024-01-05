public class Cave extends BattleLoc{

    public Cave(Player player) {
        super(player, "Cave", new Zombie(), "Food", 3);
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in the cave !");
        return super.onLocation();
    }

}