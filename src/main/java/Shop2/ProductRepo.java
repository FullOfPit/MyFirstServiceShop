package Shop2;

import java.util.List;

public interface ProductRepo extends Product {
    List<Product> products();
    List<Product> list();
    Product get();

}
