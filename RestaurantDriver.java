import java.util.*;
public class RestaurantDriver {
    public static void main(String[] args) {
        Scanner myobj = new Scanner(System.in);

        // Welcome message
        System.out.println("Welcome to the Fine Dining Menu Manager");
        System.out.println("Crafted with care by Oshin's team");


        // Create  menus
        Menu takeawayMenu = new Menu("Takeaway");
        Menu dineInMenu = new Menu("Dine-In");

        // ArrayLists for dishes
        ArrayList<String> standardDishes = new ArrayList<>(Arrays.asList("Paneer Butter Masala", "Chicken Tikka Masala", "Dal Maharani", "Aloo Gobi (vegan)", "Palak Paneer","Punjabi Butter chicken", "Butter Naan","Garlic naan","Butter roti", "Garlic roti"));
        ArrayList<String> premiumDishes = new ArrayList<>(Arrays.asList("Lamb Rogan Josh", "Prawn Vindaloo", "Butter Chicken", "Goan Fish Curry", "Mutton Biryani","Punjabi Malai kofta","Cheese naan", "Cheese Garlic naan", "Aalu onion kulcha","Aalu paratha"));
        ArrayList<String> discountedDishes = new ArrayList<>(Arrays.asList("Vegetable Biryani", "Chole Bhature", "Rajma Chawal", "Masala Dosa", "Idli Sambar","Peas Pulau Rice","plain rice", "saffron rice", "coconut rice","Kasmiri rice"));
        ArrayList<String> drinksDishes = new ArrayList<>(Arrays.asList("Mango Lassi", "Masala Chai", "Sweet Lassi", "Filter Coffee", "Coconut Water","Jeera Lassi", "capachino", "Rozz lassi","Sparkling lemonade","cold drink"));

        // Adding dishes to takeaway and dine-in menus
        for (int i = 0; i < standardDishes.size(); i++) {
            takeawayMenu.addItem(new StandardMenuItem(i + 1, standardDishes.get(i), "Description", 11.0 + i));
            dineInMenu.addItem(new StandardMenuItem(i + 1, standardDishes.get(i), "Description", 11.0 + i));
        }
        for (int i = 0; i < premiumDishes.size(); i++) {
            takeawayMenu.addItem(new PremiumMenuItem(i + 11, premiumDishes.get(i), "Description", 15.0 + i));
            dineInMenu.addItem(new PremiumMenuItem(i + 11, premiumDishes.get(i), "Description", 15.0 + i));
        }
        for (int i = 0; i < discountedDishes.size(); i++) {
            takeawayMenu.addItem(new DiscountMenuItem(i + 21, discountedDishes.get(i), "Description", 8.0 + i));
            dineInMenu.addItem(new DiscountMenuItem(i + 21, discountedDishes.get(i), "Description", 8.0 + i));
        }
        for (int i = 0; i < drinksDishes.size(); i++) {
            takeawayMenu.addItem(new DrinksMenuItem(i + 31, drinksDishes.get(i), "Drink Description", 5.0 + i));
            dineInMenu.addItem(new DrinksMenuItem(i + 31, drinksDishes.get(i), "Drink Description", 5.0 + i));
        }

        // ask user to place an order
        System.out.println();
        System.out.print("Enter customer name: ");
        String customerName = myobj.nextLine();
        System.out.print("Enter customer status (Regular, VIP, new.): ");
        String customerStatus = myobj.nextLine();

        //creating object
        Customer obj=new Customer(customerName, 0, customerStatus);

        // Display menus
        System.out.println();
        System.out.print("Choose: ");
        System.out.println("1.takeaway 2. Dine-In(2.5% service charge)");
        Integer choice= myobj.nextInt();
        myobj.nextLine();

        Menu selectedMenu;
        switch (choice){
            case 1:
                selectedMenu=takeawayMenu;
                break;
            case 2:
                selectedMenu=dineInMenu;
                break;
            default:
                System.out.println("Invalid entry!!");
                return;
        }
        System.out.println();
        selectedMenu.displayMenu();
        System.out.println();

        List<MenuItem> order = new ArrayList<>();
        List<Double> quantities =new ArrayList<>();

        System.out.println("Enter the item numbers to add to your order (enter 0 to finish):");
        
        while (true) {
            int itemNumber = myobj.nextInt();
            if (itemNumber == 0) {
                break;
            }

            MenuItem item = selectedMenu.getItem(itemNumber);
            if (item != null) {
                order.add(item);
                System.out.println("enter number of item.");
                double quantity=myobj.nextDouble();
                quantities.add(quantity);
                System.out.println(item.getName()+" added to order.");
            } 
            else {
                System.out.println("Item not found.");
            }
        }


        // Print ordered items
        System.out.println("\nOrdered Items:");
        double totalAmount = 0;
        for (int i = 1; i <= order.size(); i++) {
            MenuItem item = order.get(i-1);
            double quantity=quantities.get(i-1);
            double itemTotal=item.getItemPrice()*quantity;
            totalAmount+=itemTotal;
            System.out.println(i+". "+item.getName()+" * "+quantity+": "+itemTotal);
        }

        // Calculate total amount, applying discounts and service charges

        //appplying the discount
        double discount= obj.getDiscount();
        Double discountamt=discount/100*totalAmount;
        double finalAmt=totalAmount-discountamt;
       
        // service charge
        double serviceCharge=0.00;
        double grossAmt=0.00;
        if (choice==2){
            serviceCharge = finalAmt * 0.025;
            grossAmt=finalAmt + serviceCharge;
        }
        else{
            grossAmt=finalAmt;
        }
        System.out.println("amount      : $"+totalAmount);
        System.out.println("discount    : $"+ discountamt);
        System.out.println("charge      : $"+serviceCharge);
        System.out.println("Total amount: $" + grossAmt);
        System.out.println();
        System.out.println("Thank you for your order, " + customerName + "!");
    }
}
