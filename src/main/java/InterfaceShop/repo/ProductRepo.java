package InterfaceShop.repo;

import InterfaceShop.model.AbstractProduct;
import InterfaceShop.model.Product;
import InterfaceShop.service.HCG;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepo extends AbstractRepository<Product> {

    public Map<Integer, Product> productMap = new HashMap<>();

    public List<Product> list() {
        return this.productMap.values().stream().toList();
    }

    public Product get(String name) {
        if (this.productMap.get(new HCG(name).getHCG()) == null) {
            throw new RuntimeException("Product name not registered");
        }
        return this.productMap.get(new HCG(name).getHCG());
    }

    public Product get(int ID) {
        if (this.productMap.get(ID) == null) {
            throw new RuntimeException("Product ID not registered");
        }
        return this.productMap.get(ID);
    }

}
