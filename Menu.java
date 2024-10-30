import java.util.*;


public class Menu {
    private String type;
    private List<MenuItem> items;

    public Menu(String type) {
        this.type = type;
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public MenuItem getItem(int id) {
        for (MenuItem item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void displayMenu() {
        System.out.println(type + " Menu:");
        System.out.println("\nStandard Items:");
        boolean standardItemsExist = false;
        for (MenuItem item : items) {
            if (item instanceof StandardMenuItem) {
                System.out.println(item);
                standardItemsExist = true;
            }
        }
        if (!standardItemsExist) {
            System.out.println("No standard items available.");
        }

        System.out.println("\nPremium Items:");
        boolean premiumItemsExist = false;
        for (MenuItem item : items) {
            if (item instanceof PremiumMenuItem) {
                System.out.println(item);
                premiumItemsExist = true;
            }
        }
        if (!premiumItemsExist) {
            System.out.println("No premium items available.");
        }

        System.out.println("\nDiscounted Items:");
        boolean discountedItemsExist = false;
        for (MenuItem item : items) {
            if (item instanceof DiscountMenuItem) {
                System.out.println(item);
                discountedItemsExist = true;
            }
        }
        if (!discountedItemsExist) {
            System.out.println("No discounted items available.");
        }

        
        System.out.println("\nDrink Items:");
        boolean drinkExist=false;
        for (MenuItem item : items) {
            if (item instanceof DrinksMenuItem) {
                System.out.println(item);
                drinkExist=true;
            }
        }
        if(!drinkExist){
            System.out.println("No drinks availble.");
        }
    
    }
}
