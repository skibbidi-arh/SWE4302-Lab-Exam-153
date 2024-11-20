import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IceCreamShopTest {



    @Test
    void testContainerPrice() {
        Order order = new Order();
        order.setContainer("waffle cone");
        assertEquals(5.00, order.getContainerPrice(), 0.01);

        order.setContainer("paper cup");
        assertEquals(0.00, order.getContainerPrice(), 0.01);
    }

    @Test
    void testCalculateSubtotal() {
        Order order = new Order();
        IceCreamFlavor flavor = new IceCreamFlavor("Chocolate Fudge", 3.00);
        Topping topping = new Topping("Chocolate Chips", 0.50);

        order.addFlavor(flavor, 2);
        order.addTopping(topping, 3);
        order.setContainer("waffle cone");

        assertEquals(11.50, order.calculateSubtotal(), 0.01);
    }

    @Test
    void testCalculateTax() {
        Order order = new Order();
        IceCreamFlavor flavor = new IceCreamFlavor("Chocolate Fudge", 3.00);
        Topping topping = new Topping("Chocolate Chips", 0.50);

        order.addFlavor(flavor, 2);
        order.addTopping(topping, 3);
        order.setContainer("waffle cone");

        assertEquals(0.92, order.calculateTax(), 0.01);
    }



    @Test
    void testInvoiceGeneration() {
        Order order = new Order();
        IceCreamFlavor flavor = new IceCreamFlavor("Pistachio Delight", 3.25);
        Topping topping = new Topping("Crushed Oreo", 0.85);

        order.addFlavor(flavor, 2); // 2 scoops of Pistachio Delight
        order.addTopping(topping, 1); // 1 portion of Crushed Oreo
        order.setContainer("waffle cone");

        Invoice invoice = new Invoice();
        String generatedInvoice = invoice.generate(order);

        assertTrue(generatedInvoice.contains("Pistachio Delight - 2 x $3.25: $6.50"));
        assertTrue(generatedInvoice.contains("Crushed Oreo - 1 x $0.85: $0.85"));
        assertTrue(generatedInvoice.contains("Container: $5.00"));
        assertTrue(generatedInvoice.contains("Subtotal: $12.35"));
        assertTrue(generatedInvoice.contains("Tax: $0.99"));
        assertTrue(generatedInvoice.contains("Total Amount Due: $13.34"));
    }
}
