import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IceCreamShop {
    List<OrderItem> items = new ArrayList<OrderItem>();
    public  void Shop() throws IOException{


        IceCreamFlavor mintChocolateChip = new IceCreamFlavor("Mint Chocolate Chip", 2.80);
        IceCreamFlavor chocolateFudge = new IceCreamFlavor("Chocolate Fudge", 3.00);
        IceCreamFlavor strawberrySwirl = new IceCreamFlavor("Strawberry Swirl", 2.75);
        IceCreamFlavor pistachioDelight = new IceCreamFlavor("Pistachio Delight", 3.25);


        Topping sprinkles = new Topping("Sprinkles", 0.30);
        Topping marshmallow = new Topping("Marshmallow", 0.70);
        Topping crushedOreo = new Topping("Crushed Oreo", 0.85);
        Topping freshStrawberries = new Topping("Fresh Strawberries", 1.00);
        Topping chocolateChips = new Topping("Chocolate Chips", 0.50);


        Order order = new Order(items,0.00);
        order.addFlavor(chocolateFudge, 2);
        order.addFlavor(mintChocolateChip, 1);
        order.addTopping(freshStrawberries, 2);
        order.setContainer("waffle cone");


        Invoice invoice = new Invoice();
        System.out.println(invoice.generate(order));


        try {
            invoice.saveToFile(order, "invoice.txt");
        } catch (IOException e) {
            System.out.println("Error saving invoice to file: " + e.getMessage());
        }
    }
}
