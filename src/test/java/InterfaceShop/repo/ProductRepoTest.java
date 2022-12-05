package InterfaceShop.repo;

import InterfaceShop.model.Bakery;
import InterfaceShop.model.Diary;
import InterfaceShop.model.Product;
import InterfaceShop.model.Vegetable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {

    //Auxilliary
    public Product generateTestProduct() {
        return new Diary("Milk");
    }

    public List<Product> generateTestMixedProductList() {
        List<Product> testProductList = new ArrayList<>();
        testProductList.add(new Bakery());
        testProductList.add(new Diary());
        testProductList.add(new Vegetable());
        return testProductList;
    }




}