package InterfaceShop.repo;

import InterfaceShop.model.Diary;
import InterfaceShop.model.Product;
import InterfaceShop.service.HCG;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class ProductRepoTest {

    //Auxilliary
    public Product generateTestProduct() {
        return new Diary("Milk");
    }

    public List<Product> generateTestProductList() {
        List<Product> testProductList = new ArrayList<>();
        testProductList.add(new Diary("Milk"));
        return testProductList;
    }

    public int hcg(String name) {
        return new HCG(name).getHCG();
    }

    @Test
    void productRepo_instantiatesWithEmptyList() {
        //Given
        ProductRepo newTestProductRepo = new ProductRepo();
        //When
       Map<Integer, Product> actual = newTestProductRepo.productMap;
        //Then
        Assertions.assertEquals(new HashMap<>(), actual);
    }

    @Test
    void productRepo_instantiatesWithEmptyList_addProductManually_AtIDOne() {
        //Given
        ProductRepo newTestProductRepo = new ProductRepo();
        newTestProductRepo.productMap.put(1,generateTestProduct());
        //When
        Product actual = newTestProductRepo.productMap.get(1);
        //Then
        Assertions.assertEquals(generateTestProduct(), actual);
    }

    @Test
    void productRepo_instantiatesWithEmptyList_addTwoProductsManually_TestForLength() {
        //Given
        ProductRepo newTestProductRepo = new ProductRepo();
        newTestProductRepo.productMap.put(hcg(generateTestProduct().getName()),generateTestProduct());
        //When
        Product actual = newTestProductRepo.productMap.get(hcg(generateTestProduct().getName()));
        //Then
        Assertions.assertEquals(generateTestProduct(), actual);
    }

    @Test
    void listMethod_returnsEmptyMapWhenNoMapAddedToRepo() {
        //Given
        ProductRepo newTestProductRepo = new ProductRepo();
        //When
        List<Product> actual = newTestProductRepo.list();
        //Then
        Assertions.assertEquals(new ArrayList<>(), actual);
    }

    @Test
    void listMethod_returnsListWithOneSpecificItemWhenSaidItemIsAddedToIndex1() {
        //Given
        ProductRepo newTestProductRepo = new ProductRepo();
        newTestProductRepo.productMap.put(1, generateTestProduct());
        //When
        List<Product> actual = newTestProductRepo.list();
        //Then
        Assertions.assertEquals(generateTestProductList(), actual);
    }

    @Test
    void listMethod_returnsListWithOneSpecificItemWhenSaidItemIsAddedToHCGIndex() {
        //Given
        ProductRepo newTestProductRepo = new ProductRepo();
        newTestProductRepo.productMap.put(hcg(generateTestProduct().getName()), generateTestProduct());
        //When
        List<Product> actual = newTestProductRepo.list();
        //Then
        Assertions.assertEquals(generateTestProductList(), actual);
    }






}