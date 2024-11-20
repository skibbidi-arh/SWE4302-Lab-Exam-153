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

    public void addFlavor(IceCreamFlavor flavor,int quantity) {

       items.add(new OrderItem(flavor.getName(),quantity, flavor.getPricePerScoop()));



    }

    public void addTopping(Topping topping, int quantity) {
        items.add(new OrderItem(topping.getName(), quantity, topping.getPrice()));
    }


}
