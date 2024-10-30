public abstract class MenuItem {
    private int id;
    private String name;
    private String description;
    private double price;

    public MenuItem(int id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }
     
    public String getName(){
        return name;

    }
    public double getItemPrice() {
        return price;
    }

    @Override
    public String toString() {
        return id + ": " + name + " - " + description + " ($" + price + ")";
    }
}
