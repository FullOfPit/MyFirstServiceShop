package InterfaceShop.repo;

import InterfaceShop.model.Diary;
import InterfaceShop.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


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

    @Test
    void productRepo_instantiatesWithEmptyList() {
        //Given
        ProductRepo newTestProductRepo = new ProductRepo();
        //When
        List<Product> actual = newTestProductRepo.productList;
        //Then
        Assertions.assertEquals(new ArrayList<>(), actual);
    }

    @Test
    void productRepo_instantiatesWithEmptyList_addProductManually() {
        //Given
        ProductRepo newTestProductRepo = new ProductRepo();
        newTestProductRepo.productList.add(generateTestProduct());
        //When
        Product actual = newTestProductRepo.productList.get(0);
        //Then
        Assertions.assertEquals(generateTestProduct(), actual);
    }

    @Test
    void productRepo_instantiatesWithEmptyList_addTwoProductsManually_TestForLength() {
        //Given
        ProductRepo newTestProductRepo = new ProductRepo();
        newTestProductRepo.productList.add(generateTestProduct());
        newTestProductRepo.productList.add(generateTestProduct());
        //When
        int actual = newTestProductRepo.productList.size();
        //Then
        Assertions.assertEquals(2, actual);
    }

    @Test
    void listMethod_returnsEmptyListWhenNoListAddedToRepo() {
        //Given
        ProductRepo newTestProductRepo = new ProductRepo();
        //When
        List<Product> actual = newTestProductRepo.list();
        //Then
        Assertions.assertEquals(new ArrayList<>(), actual);
    }

    @Test
    void listMethod_returnsListWithOneSpecificItemWhenSaidItemIsAdded() {
        //Given
        ProductRepo newTestProductRepo = new ProductRepo();
        newTestProductRepo.productList.add(generateTestProduct());
        //When
        List<Product> actual = newTestProductRepo.list();
        //Then
        Assertions.assertEquals(generateTestProductList(), actual);

    }




}