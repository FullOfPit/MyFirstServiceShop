package MyShop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRepo {
    List<Product> products;

    public List<Product> list() {
        return products;
    }
    public Product checkForProduct(Product product) {
        if (this.products.contains(product)) {
            return product;
        }
        throw new RuntimeException("MyShop.Product not registered");
    }
    public Product getProductByID(int ID) {
        for (Product product : this.products) {
            if (product.getId() == ID) {
                return product;
            }
        }
        throw new RuntimeException("MyShop.Product not registered");
    }
}
