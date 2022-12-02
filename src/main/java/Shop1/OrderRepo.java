package Shop1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OrderRepo {
    public List<Order> orders;

    // String name = "Christian";
    // name.length

    // List<Order> namensListe = {jdjshfhhd}
    // namesListe.add();


    public List<Order> list() {
        return this.orders;
    }

    public Order get(Order order) {
        return this.orders.contains(order) ? order : null;
    }

    public void add(Order order) { this.orders.add(order);}
}
