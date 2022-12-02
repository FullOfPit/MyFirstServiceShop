package Shop2;

import java.util.List;

public interface OrderRepo extends Order, ProductRepo{
    List<Order> orders();
    List<Product> list();
    Product get();
    List<Order> add();



}
