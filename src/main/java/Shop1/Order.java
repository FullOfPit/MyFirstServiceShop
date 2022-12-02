package Shop1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Order {
    String id;
    List<Product> products;

    public Order() {

    }
}
