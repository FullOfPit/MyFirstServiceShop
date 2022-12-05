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

    //                     ------------- Auxiliary -------------
    public Product generateTestProduct() {
        return new Diary("Test Product");
    }

    public List<Product> generateTestProductList() {
        List<Product> testProductList = new ArrayList<>();
        testProductList.add(new Diary("Test Product"));
        return testProductList;
    }

    public Map<Integer, Product> generateTestProductMap() {
        Map<Integer, Product> testProductMap = new HashMap<>();
        testProductMap.put(1, generateTestProduct());
        return testProductMap;
    }

    public int hcg(String name) {
        return new HCG(name).getHCG();
    }

    //                     ------------- Testing -------------

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
        Map<Integer, Product> actual = newTestProductRepo.list();
        //Then
        Assertions.assertEquals(new HashMap<>(), actual);
    }

    @Test
    void listMethod_returnsListWithOneSpecificItemWhenSaidItemIsAddedToIndex1() {
        //Given
        ProductRepo newTestProductRepo = new ProductRepo();
        newTestProductRepo.productMap.put(1, generateTestProduct());
        //When
        Map<Integer, Product> actual = newTestProductRepo.list();
        //Then
        Assertions.assertEquals(generateTestProductMap(), actual);
    }

    @Test
    void listMethod_returnsListWithOneSpecificItemWhenSaidItemIsAddedToHCGIndex() {
        //Given
        ProductRepo newTestProductRepo = new ProductRepo();
        newTestProductRepo.productMap.put(hcg(generateTestProduct().getName()), generateTestProduct());

        Map<Integer, Product> newTestMap = new HashMap<>();
        newTestMap.put(hcg(generateTestProduct().getName()), generateTestProduct());
        //When
        Map<Integer, Product> actual = newTestProductRepo.list();
        //Then
        Assertions.assertEquals(newTestMap, actual);
    }

    @Test
    void getMethodString_returnsProduct_ByNameString() {
        //Given
        ProductRepo newTestProductRepo = new ProductRepo();
        newTestProductRepo.productMap.put(hcg(generateTestProduct().getName()), generateTestProduct());
        //When
        Product actual = newTestProductRepo.get("Test Product");
        //Then
        Assertions.assertEquals(generateTestProduct(), actual);
    }

    @Test
    void getMethodString_throwsExc_EnteredNonExistentProductName() {
        //Given
        ProductRepo newTestProductRepo = new ProductRepo();
        newTestProductRepo.productMap.put(hcg(generateTestProduct().getName()), generateTestProduct());
        //When -- Then
        try {
            newTestProductRepo.get("Cheese");
            Assertions.fail();
        } catch (RuntimeException e) {
            Assertions.assertEquals("Product name not registered", e.getMessage());
        }
    }

    @Test
    void getMethodID_returnsProduct_ByPutID() {
        //Given
        ProductRepo newTestProductRepo = new ProductRepo();
        newTestProductRepo.productMap.put(2, generateTestProduct());
        //When
        Product actual = newTestProductRepo.get(2);
        //Then
        Assertions.assertEquals(generateTestProduct(), actual);
    }

    @Test
    void getMethodInt_throwsExc_EnteredNonExistentProductID() {
        //Given
        ProductRepo newTestProductRepo = new ProductRepo();
        newTestProductRepo.productMap.put(hcg(generateTestProduct().getName()), generateTestProduct());
        //When -- Then
        try {
            newTestProductRepo.get(2);
            Assertions.fail();
        } catch (RuntimeException e) {
            Assertions.assertEquals("ID not registered", e.getMessage());
        }
    }


}