package InterfaceShop.repo;

import InterfaceShop.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo{

    public List<Product> productList = new ArrayList<>();

    public List<Product> list() {
        return this.productList;
    }



}
