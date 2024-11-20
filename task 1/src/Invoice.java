import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Invoice {
    public String generate(Order order) {
        StringBuilder invoice = new StringBuilder();
        for (OrderItem item : order.getItems()) {
            invoice.append(item.toString()).append("\n");
        }
        invoice.append("Container: $").append(String.format("%.2f", order.getContainerPrice())).append("\n");
        invoice.append("Subtotal: $").append(String.format("%.2f", order.calculateSubtotal())).append("\n");
        invoice.append("Tax: $").append(String.format("%.2f", order.calculateTax())).append("\n");
        invoice.append("Total Amount Due: $").append(String.format("%.2f", order.calculateTotal())).append("\n");
        return invoice.toString();
    }

    public void saveToFile(Order order, String filename) throws IOException {
        FileWriter writer = new FileWriter(filename);
        writer.write(generate(order));
        writer.close();
    }
}