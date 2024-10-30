public class Customer {
    private String name;
    private double discount;
    private String status;


    // constructor to initialize instance variables
    public Customer(String name, double discount, String status) {
        this.name = name;
        this.discount = discount;
        this.status = status;
        setDiscount(this.status); // Calculate discount based on status
    }

    // Getter and Setter 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        setDiscount(this.status); // Recalculate discount when status changes
    }

    // to calculate discount based on customer status
    public void setDiscount(String status) {
        switch (status.toLowerCase()) {
            case "vip":
                this.discount = 15.0;
                break;
            case "regular":
                this.discount = 10.0;
                break;
            case "new":
                this.discount = 0.0;
                break;
            default:
                System.out.println("invalid!!");
                this.discount=0.0;
                break;
        }
    }

    // toString() method to return object details
    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", discount=" + discount +
                ", status='" + status + '\'' +
                '}';
    }

}
