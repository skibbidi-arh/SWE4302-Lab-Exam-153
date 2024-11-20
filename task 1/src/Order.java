import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<OrderItem> items;
    private double containerPrice;
    private final double TAX_RATE = 0.08;

    public Order(List<OrderItem> items, double containerPrice) {
        this.items = new ArrayList<>();
        this.containerPrice = 0.0;
    }
    public Order()
    {
        this.items = new ArrayList<>();
    }




    public void addFlavor(IceCreamFlavor flavor,int quantity) {

       items.add(new OrderItem(flavor.getName(),quantity, flavor.getPricePerScoop()));

    }

    public void addTopping(Topping topping, int quantity) {
        items.add(new OrderItem(topping.getName(), quantity, topping.getPrice()));
    }

    public void setContainer(String containerType) {
        if (containerType.equalsIgnoreCase("waffle cone")) {
            this.containerPrice = 5.00;
        } else {
            this.containerPrice = 0.00;
        }
    }
    public double calculateSubtotal() {

        return items.stream().mapToDouble(OrderItem::getTotalPrice).sum() + containerPrice;
    }


    public List<OrderItem> getItems() {
        return items;
    }



    public double getContainerPrice() {

        return containerPrice;

    }


    public double calculateTax() {

        return calculateSubtotal() * TAX_RATE;
    }


    public double calculateTotal() {
        return calculateSubtotal() + calculateTax();
    }
}
