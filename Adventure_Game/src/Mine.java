import java.util.Random;

public class Mine extends BattleLoc{


    public Mine(Player player) {
        super(player, "Mine", new Snake(), "Diamond", 5);

    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in the mine !");
        return super.onLocation();
    }
}