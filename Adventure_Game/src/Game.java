import java.util.Scanner;

public class Game {
    public Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to the Adventure Game!");
        System.out.println("Please enter a name: ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Dear " + player.getName() + ", welcome to this dark and misty island!");
        System.out.println("Please select a character: ");
        player.selectChar();

        Location location = null;
        while (true) {
            player.printInfo();
            System.out.println("=====================================================");
            System.out.println("======================= Areas ========================");
            System.out.println("1 - Safe House --> Your health will be restored.");
            System.out.println("2 - Tool Store --> You can buy weapons and armor.");
            System.out.println("3 - Cave --> Reward <Food>, Beware! You may encounter a Zombie.");
            System.out.println("4 - Forest --> Reward <Firewood>, Beware! You may encounter a Vampire.");
            System.out.println("5 - River --> Reward <Water>, Beware! You may encounter a Bear.");
            System.out.println("6 - Mine --> Reward <Money, Weapon, Armor>, Beware! You may encounter a Snake.");
            System.out.println("0 - Exit --> Ends the game.");
            System.out.println("Please choose the area you want to go: ");
            int selectLoc = input.nextInt();

            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    if (player.getInventory().isFood() && player.getInventory().isFirewood() && player.getInventory().isWater()) {
                        System.out.println("Congratulations! You have won the game!");
                        return;
                    }
                    location = new SafeHouse(player);
                    break;

                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    if (!player.getInventory().isFood()) {
                        location = new Cave(player);
                        break;
                    } else {
                        // After getting the reward, prevent re-entry into the cave.
                        System.out.println("You have already entered the cave and collected your reward!");
                        continue;
                    }
                case 4:
                    if (!player.getInventory().isFirewood()) {
                        location = new Forest(player);
                        break;
                    } else {
                        // After getting the reward, prevent re-entry into the forest.
                        System.out.println("You have already entered the forest and collected your reward!");
                        continue;
                    }
                case 5:
                    if (!player.getInventory().isWater()) {
                        location = new River(player);
                        break;
                    } else {
                        // After getting the reward, prevent re-entry into the river.
                        System.out.println("You have already entered the river and collected your reward!");
                        continue;
                    }
                case 6:
                    location = new Mine(player);
                    break;
                default:
                    System.out.println("Please select a valid area!");
            }

            if (location == null) {
                System.out.println("Game Over. You gave up too quickly!");
                break;
            }

            if (!location.onLocation()) {
                System.out.println("You lost the game!");
                break;
            }
        }
    }
}
