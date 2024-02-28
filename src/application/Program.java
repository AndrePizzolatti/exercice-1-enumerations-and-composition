package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter client data:");

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Birth date (DD/MM/YYYY): ");
        String birthDate = sc.nextLine();

        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order data:");

        System.out.print("Status: ");
        String status = sc.nextLine();

        System.out.print("How many items to this order? ");
        int numberOfItems = sc.nextInt();

        Order order = new Order(OrderStatus.valueOf(status), client);

        sc.nextLine();

        for (int i=1; i<=numberOfItems; i++) {
            System.out.println("Enter #1 item data:");

            System.out.print("Product name: ");
            String productName = sc.nextLine();

            System.out.print("Product price: ");
            Double productPrice = sc.nextDouble();

            System.out.print("Quantity: ");
            Integer quantity = sc.nextInt();

            Product product = new Product(productName, productPrice);

            OrderItem orderItem = new OrderItem(product, quantity, productPrice);

            order.addItem(orderItem);

            sc.nextLine();
        }

        sc.close();

        System.out.println();

        System.out.println("ORDER SUMMARY:");
        System.out.println("Order moment: " + order.getMoment());
        System.out.println("Order status: " + order.getStatus());
        System.out.println("Client: " + client.getName() + " (" + client.getBirthDate() + ") - " + client.getEmail());

        System.out.println("Order items:");
        for (OrderItem item : order.getOrders()) {
            System.out.printf("%s, $%.2f, Quantity: %d, Subtotal: $%.2f%n", item.getProduct().getName(), item.getPrice(), item.getQuantity(), item.subTotal());
        }
        System.out.printf("Total price: $%.2f%n", order.total());
    }
}
