public class OrderItem {

    private String name;
    private  int quantity;
    private  double unitPrice;

    public OrderItem(String name, int quantity, double unitPrice) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public double getTotalPrice() {
        return unitPrice * quantity;

    }




}
