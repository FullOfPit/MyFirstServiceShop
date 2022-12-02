package Shop1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ShopService {
    public ProductRepo productRepo;
    public OrderRepo orderRepo;

    public ShopService() {

    }

    //ShopService myNewCornerShop = new ShopService();

    public List<Product> listProducts() {
        return this.productRepo.list();
    }
    // public ProductRepo listProducts() {return this.productRepo;}

    public List<Order> listOrders() {
        return this.orderRepo.list();
    }

    public Product get(Product product) {
        return this.productRepo.get(product);
    }

    public void addOrder(Order order) {
        this.orderRepo.add(order);
    }

    public Order getOrder(Order order) {
       return this.orderRepo.get(order);
    }



}
