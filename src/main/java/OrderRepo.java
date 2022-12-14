import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class OrderRepo {
    List<Order> orders;


    public List<Order> list() {
        return this.orders;
    }

    public Order checkForOrder(Order order) {
        if (this.orders.contains(order)) {
            return order;
        }
        throw new RuntimeException("Order not registered");
    }

    public Order getOrderByID(int ID) {
        for (Order order : this.orders) {
            if (order.getId() == ID) {
                return order;
            }
        }
        throw new RuntimeException("Order not registered");
    }

    public void add(ArrayList<Product> newOrder) {
        if (this.orders == null) {
            this.orders = new ArrayList<>();
            this.orders.add(new Order(1, newOrder));
        }
        this.orders.add(new Order(this.orders.size() + 1, newOrder));
    }
}
