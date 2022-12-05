package InterfaceShop.repo;

import InterfaceShop.model.Product;
import InterfaceShop.service.HCG;
import lombok.Data;


import java.util.HashMap;
import java.util.Map;

public class ProductRepo extends AbstractRepository<Product> {

    public Map<Integer, Product> productMap = new HashMap<>();

    public Map<Integer, Product> list() {
        return this.productMap;
    }

    /*
    public Product get(int ID) {
        if (this.productMap.get(ID) != null) {
            return this.productMap.get(ID);
        }
        throw new RuntimeException("ID not registered");
    }

     */

    public Product get(String name) {
        if (this.productMap.get(new HCG(name).getHCG()) != null) {
            return this.productMap.get(new HCG(name).getHCG());
        }
        throw new RuntimeException("Product name not registered");
    }

}
