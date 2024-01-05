// ToolStore class represents the in-game store where players can buy weapons and armor
public class ToolStore extends NormalLoc {

    // Constructor for ToolStore class
    public ToolStore(Player player) {
        super(player, "Store");
    }

    // Overrides the onLocation method to handle actions when the player is at the store
    @Override
    public boolean onLocation() {
        System.out.println("------Welcome to the Store!------");

        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1 - Weapons");
            System.out.println("2 - Armors");
            System.out.println("3 - Exit");
            System.out.print("Your choice: ");
            int selectCase = input.nextInt();

            // Validate user input
            while (selectCase < 1 || selectCase > 3) {
                System.out.print("Invalid choice. Please try again: ");
                selectCase = input.nextInt();
            }

            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("See you again.");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    // Display available weapons for purchase
    public void printWeapon() {
        System.out.println("---------Weapons---------");
        for (Weapon weapon : Weapon.weapons()) {
            System.out.println(weapon.getId() + " - " + weapon.getName() +
                    " <Price: " + weapon.getPrice() + " Damage: " + weapon.getDamage() + ">");
        }
        System.out.println("0 - Exit");
    }

    // Process the purchase of a weapon
    public void buyWeapon() {
        System.out.println("Choose a weapon: ");
        int selectWeaponID = input.nextInt();

        // Validate user input
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.print("Invalid choice. Please try again: ");
            selectWeaponID = input.nextInt();
        }

        if (selectWeaponID != 0) {
            Weapon selectedWeapon = Weapon.getWeaponById(selectWeaponID);

            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > getPlayer().getMoney()) {
                    System.out.println("Insufficient funds.");
                } else {
                    // Purchase process
                    System.out.println(selectedWeapon.getName() + " purchased.");
                    int balance = getPlayer().getMoney() - selectedWeapon.getPrice();
                    getPlayer().setMoney(balance);
                    System.out.println("Your remaining funds: " + getPlayer().getMoney());

                    // Update player's inventory
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);

                    // Display the updated inventory
                    System.out.println("Updated Inventory:");
                    getPlayer().printInfo();
                }
            }
        }
    }

    // Display available armors for purchase
    public void printArmor() {
        System.out.println("---------Armors---------");
        for (Armor armor : Armor.armors()) {
            System.out.println(armor.getId() + " - " + armor.getName() + " <Price: " + armor.getPrice() + " Block: " + armor.getBlock() + ">");
        }
        System.out.println("0 - Exit");
    }

    // Process the purchase of an armor
    public void buyArmor() {
        System.out.println("Choose an armor: ");
        int selectArmorID = input.nextInt();

        // Validate user input
        while (selectArmorID < 0 || selectArmorID > Armor.armors().length) {
            System.out.print("Invalid choice. Please try again: ");
            selectArmorID = input.nextInt();
        }

        if (selectArmorID != 0) {
            Armor selectedArmor = Armor.getArmorById(selectArmorID);

            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > getPlayer().getMoney()) {
                    System.out.println("Insufficient funds.");
                } else {
                    // Purchase process
                    System.out.println(selectedArmor.getName() + " purchased.");
                    int balance = getPlayer().getMoney() - selectedArmor.getPrice();
                    getPlayer().setMoney(balance);
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Your remaining funds: " + getPlayer().getMoney());

                    // Display the updated inventory
                    System.out.println("Updated Inventory:");
                    getPlayer().printInfo();
                }
            }
        }
    }
}
