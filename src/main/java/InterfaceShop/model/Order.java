package InterfaceShop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Order {
    String recipient;
    List<Product> productList = new ArrayList<>();

    public Order(String name, List<Product> productList) {
        this.recipient = name;
        this.productList = productList;
    }
}
