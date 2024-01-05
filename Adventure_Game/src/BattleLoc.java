import java.util.Random;

public abstract class BattleLoc extends Location {

    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    public int randomObstacleNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();

        System.out.println("You are currently at: " + getName());
        System.out.println("Be careful! There are " + obsNumber + " " + this.getObstacle().getName() + "(s) in this area!");
        System.out.println("=======================================");
        System.out.println("<F>ight or <R>un: ");
        String selectCase = input.nextLine().toUpperCase();
        if (selectCase.equals("F") && combat(obsNumber)) {
            System.out.println("Battle is over!");
            System.out.println("=======================================");
            // Battle methods
            System.out.println("You have defeated all the enemies in " + this.getName() + "!");
            regionReward();     // Winning rewards
            return true;
        }

        if (getPlayer().getHealth() <= 0) {
            System.out.println(" -----You died!----- ");
            return false;
        }
        return true;
    }

    public void regionReward() {
        // Winning rewards
        if (this instanceof Cave) {
            getPlayer().getInventory().setFood(true);
            System.out.println("Food reward added to your inventory!");
        } else if (this instanceof Forest) {
            getPlayer().getInventory().setFirewood(true);
            System.out.println("Firewood reward added to your inventory!");
        } else if (this instanceof River) {
            getPlayer().getInventory().setWater(true);
            System.out.println("Water reward added to your inventory!");
        }
    }

    public boolean combat(int obsNumber) {
        for (int i = 1; i <= obsNumber; i++) {
            boolean isSnake = getObstacle().getName().equals("Snake");
            if (isSnake) {
                this.setObstacle(new Snake());
            }
            this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
            playerStats();
            obstacleStats(i);

            boolean firstMove = Math.random() * 100 <= 50;
            while (getPlayer().getHealth() > 0 && getObstacle().getHealth() > 0) {
                if (firstMove) {
                    System.out.println("It's your turn!");
                    System.out.println("<A>ttack or <R>un: ");
                    String selectCombat = input.nextLine().toUpperCase();
                    if (selectCombat.equals("A")) {
                        System.out.println("You attacked!");
                        getObstacle().setHealth(getObstacle().getHealth() - getPlayer().getTotalDamage());
                        afterHit();
                    } else {
                        return false;
                    }
                } else {
                    if (getObstacle().getHealth() > 0) {
                        System.out.println();
                        System.out.println("It's opponent's turn!");
                        System.out.println("The monster attacked you!");
                        int obstacleDamage = getObstacle().getDamage() - getPlayer().getInventory().getArmor().getBlock();
                        if (obstacleDamage < 0) {
                            obstacleDamage = 0;
                        }
                        getPlayer().setHealth(getPlayer().getHealth() - obstacleDamage);
                        afterHit();
                    }
                }
                firstMove = !firstMove;
            }

            if (getObstacle().getHealth() < getPlayer().getHealth()) {
                System.out.println("You defeated the enemy!");

                if (isSnake) {
                    Snake snake = (Snake) getObstacle();
                    snake.setWarDiamond(snake.randomWarDiamond());
                    if (snake.getWarDiamond() instanceof Weapon){
                        getPlayer().getInventory().setWeapon((Weapon) snake.getWarDiamond());
                    } else if (snake.getWarDiamond() instanceof Armor){
                        getPlayer().getInventory().setArmor((Armor) snake.getWarDiamond());
                    }
                    System.out.println(snake.getWarDiamond() != null ? "You won " + snake.getWarDiamond() + "!" : "");
                }
                getPlayer().setMoney(getPlayer().getMoney() + getObstacle().getAward());
                System.out.println(isSnake ? "" : "You earned " + getObstacle().getAward() + " coins!");
                System.out.println("Your current money: " + getPlayer().getMoney());
                System.out.println("=======================================");
            } else {
                return false;
            }
        }
        return true;
    }

    public void afterHit() {
        System.out.println("Player Health \t: " + getPlayer().getHealth());
        System.out.println(getObstacle().getName() + " Health \t: " + getObstacle().getHealth());
        System.out.println("=======================================");
    }

    public void playerStats() {
        System.out.println("Player Stats\n");
        System.out.println("----------------");
        System.out.println("Health \t: " + getPlayer().getHealth());
        System.out.println("Weapon \t: " + getPlayer().getInventory().getWeapon().getName());
        System.out.println("Damage \t: " + getPlayer().getTotalDamage());
        System.out.println("Armor \t: " + getPlayer().getInventory().getArmor().getName());
        System.out.println("Block \t: " + getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Money \t: " + getPlayer().getMoney());
        System.out.println("=======================================");
    }

    public void obstacleStats(int i) {
        System.out.println(i + " . " + getObstacle().getName() + " Stats\n");
        System.out.println("----------------");
        System.out.println("Health \t: " + getObstacle().getHealth());
        System.out.println("Damage \t: " + getObstacle().getDamage());
        System.out.println("Reward \t: " + getObstacle().getAward());
        System.out.println("=======================================");
    }
}
