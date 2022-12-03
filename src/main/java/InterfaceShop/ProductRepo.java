package InterfaceShop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductRepo {
    private List<Product> products;

    public List<Product> list() {
        return this.products;
    }

    public Product get(int ID) {
        if (this.products == null) {
            return null;
        }
        for (Product product : this.products) {
            if (product.getID() == ID) {
                return product;
            }
        }
        throw new RuntimeException("Product_ID not registered");
    }


}
