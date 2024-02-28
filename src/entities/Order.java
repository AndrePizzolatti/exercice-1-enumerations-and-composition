package entities;

import entities.enums.OrderStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private final LocalDateTime moment;
    private OrderStatus status;
    private Client client;
    private final List<OrderItem> orders = new ArrayList<>();

    public Order(OrderStatus status, Client client) {
        this.moment = LocalDateTime.now();
        this.status = status;
        this.client = client;
    }

    public String getMoment() {
        return fmt.format(moment);
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getOrders() {
        return orders;
    }

    public void addItem(OrderItem item) {
        orders.add(item);
    }

    public void removeItem(OrderItem item) {
        orders.remove(item);
    }

    public Double total() {
        Double sum = 0.0;
        for (OrderItem item : orders) {
            sum += item.subTotal();
        }
        return sum;
    }
}
