import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
public class ShopService {
    public ProductRepo productRepo;
    public OrderRepo orderRepo;

    public List<Product> listProducts() {
        return this.productRepo.list();
    }
    public List<Order> listOrders() {
        return this.orderRepo.list();
    }

    public Product getProduct(Object product) {
        if (product.getClass() == Product.class){
            return this.productRepo.checkForProduct((Product) product);
        }
        if (product.getClass() == Integer.class) {
            return this.productRepo.getProductByID((int)product);
        }
        return null;
    }

    public Order getOrder(Object order) {
        if (order.getClass() == Order.class) {
            return this.orderRepo.checkForOrder((Order)order);
        }
        if (order.getClass() == Integer.class) {
            return this.orderRepo.getOrderByID((int) order);
        }
        return null;
    }

    public void addOrder(Object order) {
        if (this.orderRepo == null) {
            this.orderRepo = new OrderRepo(new ArrayList<Order>());
        }
        if (order.getClass() == Order.class) {
            this.orderRepo.add((ArrayList<Product>) ((Order) order).getProducts());
        } else if (Objects.equals(order.getClass(), ArrayList.class)) {
            this.orderRepo.add((ArrayList<Product>) order);
        } else {
            throw new RuntimeException("You have entered an inadequate order format");
        }
    }

}
