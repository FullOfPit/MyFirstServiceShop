package InterfaceShop.repo;

import InterfaceShop.model.Product;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepo{

    public Map<Integer, Product> productMap = new HashMap<>();

    public List<Product> list() {
        return this.productMap.values().stream().toList();
    }





}
