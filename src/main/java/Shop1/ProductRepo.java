package Shop1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProductRepo {
    public List<Product> products;
    //public List<String> animals;

    public List<Product> list() {
        return this.products;
    }

    public Product get(Product product) {
        /*
        if (this.products.contains(product) {
            return product;} else {
                return null; }


        return (this.product.contains(product) ? product : null;
         */

        return this.products.contains(product) ? product : null;
    }
}
