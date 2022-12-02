import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {

    @Test
    void listProducts_ReturnsListOfProducts() {
        //Given
        Product bread = new Product(1, "bread");
        Product milk = new Product(2, "milk");
        Product honey = new Product(3, "honey");

        List<Product> testProductList = new ArrayList<>();
        testProductList.add(bread);
        testProductList.add(milk);
        testProductList.add(honey);

        ProductRepo testProductRepo = new ProductRepo();
        testProductRepo.products = testProductList;

        ShopService myTestShop = new ShopService(testProductRepo, null);
        //When
        List<Product> actual = myTestShop.listProducts();
        //Then
        Assertions.assertEquals(testProductList, actual);

    }

    @Test
    void listOrders_ReturnListOfOrders() {
        // Given
        Product bread = new Product(1, "bread");
        Product milk = new Product(2, "milk");
        Product honey = new Product(3, "honey");

        List<Product> testProductList = new ArrayList<>();
        testProductList.add(bread);
        testProductList.add(milk);
        testProductList.add(honey);

        List<Order> myTestOrderList = new ArrayList<>();
        myTestOrderList.add(new Order(1, testProductList));

        OrderRepo myTestOrderRepo = new OrderRepo(myTestOrderList);

        ShopService myTestShop = new ShopService(null, myTestOrderRepo);
        // When
        List<Order> actual = myTestShop.listOrders();
        // Then
        Assertions.assertEquals(myTestOrderList ,actual);

    }

    @Test
    void getProduct_byProduct() {
        //Given
        Product bread = new Product(1, "bread");
        Product milk = new Product(2, "milk");
        Product honey = new Product(3, "honey");

        List<Product> testProductList = new ArrayList<>();
        testProductList.add(bread);
        testProductList.add(milk);
        testProductList.add(honey);

        ProductRepo testProductRepo = new ProductRepo();
        testProductRepo.products = testProductList;

        ShopService myTestShop = new ShopService(testProductRepo, null);
        //When
        Product actual = myTestShop.getProduct(milk);
        //Then
        Assertions.assertEquals(milk, actual);
    }

    @Test
    void getProduct_byID() {
        Product bread = new Product(1, "bread");
        Product milk = new Product(2, "milk");
        Product honey = new Product(3, "honey");

        List<Product> testProductList = new ArrayList<>();
        testProductList.add(bread);
        testProductList.add(milk);
        testProductList.add(honey);

        ProductRepo testProductRepo = new ProductRepo();
        testProductRepo.products = testProductList;

        ShopService myTestShop = new ShopService(testProductRepo, null);
        //When
        Product actual = myTestShop.getProduct(2);
        //Then
        Assertions.assertEquals(milk, actual);

    }

    @Test
    void getProduct_byID_ThrowRunExcIfIDNotRegistered() {
        Product bread = new Product(1, "bread");
        Product milk = new Product(2, "milk");
        Product honey = new Product(3, "honey");

        List<Product> testProductList = new ArrayList<>();
        testProductList.add(bread);
        testProductList.add(milk);
        testProductList.add(honey);

        ProductRepo testProductRepo = new ProductRepo();
        testProductRepo.products = testProductList;

        ShopService myTestShop = new ShopService(testProductRepo, null);
        //When

        try {
            Product actual = myTestShop.getProduct(4);
            Assertions.fail();
        } catch (RuntimeException e) {
            Assertions.assertEquals("Product not registered", e.getMessage());

        }
    }

    @Test
    void getProduct_byID_ThrowRunExcIfIProductNotRegistered() {
            Product bread = new Product(1, "bread");
            Product milk = new Product(2, "milk");
            Product honey = new Product(3, "honey");

            Product cookies = new Product(4, "cookies");

            List<Product> testProductList = new ArrayList<>();
            testProductList.add(bread);
            testProductList.add(milk);
            testProductList.add(honey);

            ProductRepo testProductRepo = new ProductRepo();
            testProductRepo.products = testProductList;

            ShopService myTestShop = new ShopService(testProductRepo, null);
            //When

            try {
                Product actual = myTestShop.getProduct(cookies);
                Assertions.fail();
            } catch (RuntimeException e) {
                Assertions.assertEquals("Product not registered", e.getMessage());

            }
        }

        @Test
        void getOrder_byOrder() {
            // Given
            Product bread = new Product(1, "bread");
            Product milk = new Product(2, "milk");
            Product honey = new Product(3, "honey");

            List<Product> testProductList = new ArrayList<>();
            testProductList.add(bread);
            testProductList.add(milk);
            testProductList.add(honey);

            List<Order> myTestOrderList = new ArrayList<>();
            myTestOrderList.add(new Order(1, testProductList));

            OrderRepo myTestOrderRepo = new OrderRepo(myTestOrderList);

            ShopService myTestShop = new ShopService(null, myTestOrderRepo);
            // When
            Order actual = myTestShop.getOrder(new Order(1, testProductList));
            // Then
            Assertions.assertEquals(new Order(1, testProductList), actual);
        }

    @Test
    void getOrder_byID() {
        // Given
        Product bread = new Product(1, "bread");
        Product milk = new Product(2, "milk");
        Product honey = new Product(3, "honey");

        List<Product> testProductList = new ArrayList<>();
        testProductList.add(bread);
        testProductList.add(milk);
        testProductList.add(honey);

        List<Order> myTestOrderList = new ArrayList<>();
        myTestOrderList.add(new Order(1, testProductList));

        OrderRepo myTestOrderRepo = new OrderRepo(myTestOrderList);

        ShopService myTestShop = new ShopService(null, myTestOrderRepo);
        // When
        Order actual = myTestShop.getOrder(1);
        // Then
        Assertions.assertEquals(new Order(1, testProductList), actual);
    }

    @Test
    void addOrder_AddOrderToEmptyOrderRepo_AsOrderObject() {
        Product bread = new Product(1, "bread");
        Product milk = new Product(2, "milk");
        Product honey = new Product(3, "honey");

        List<Product> testProductList = new ArrayList<>();
        testProductList.add(bread);
        testProductList.add(milk);
        testProductList.add(honey);

        ShopService myTestShop = new ShopService(null, null);
        myTestShop.addOrder(new Order(1, testProductList));

        List<Order> myTestOrderList = new ArrayList<>();
        myTestOrderList.add(new Order(1, testProductList));

        OrderRepo myTestOrderRepo = new OrderRepo(myTestOrderList);
        //When
        OrderRepo actual = myTestShop.orderRepo;
        //
        Assertions.assertEquals(myTestOrderRepo, actual);
    }

    @Test
    void addOrder_AddOrderToEmptyOrderRepo_AsOrderProductList() {
        Product bread = new Product(1, "bread");
        Product milk = new Product(2, "milk");
        Product honey = new Product(3, "honey");

        List<Product> testProductList = new ArrayList<>();
        testProductList.add(bread);
        testProductList.add(milk);
        testProductList.add(honey);

        ShopService myTestShop = new ShopService(null, null);
        myTestShop.addOrder(testProductList);

        List<Order> myTestOrderList = new ArrayList<>();
        myTestOrderList.add(new Order(1, testProductList));

        OrderRepo myTestOrderRepo = new OrderRepo(myTestOrderList);
        //When
        OrderRepo actual = myTestShop.orderRepo;
        //
        Assertions.assertEquals(myTestOrderRepo, actual);
    }

    @Test
    void addOrder_AddOrderToExistingOrderRepo_AsOrderObject() {
        Product bread = new Product(1, "bread");
        Product milk = new Product(2, "milk");
        Product honey = new Product(3, "honey");

        List<Product> testProductList = new ArrayList<>();
        testProductList.add(bread);
        testProductList.add(milk);
        testProductList.add(honey);

        List<Order> myTestOrderList = new ArrayList<>();
        myTestOrderList.add(new Order(1, testProductList));

        ShopService myTestShop = new ShopService(null, new OrderRepo(myTestOrderList));
        myTestShop.addOrder(new Order(1, testProductList));

        OrderRepo myTestOrderRepo = new OrderRepo(myTestOrderList);
        myTestOrderRepo.add((ArrayList<Product>) testProductList);
        //When
        OrderRepo actual = myTestShop.orderRepo;
        //
        Assertions.assertEquals(myTestOrderRepo, actual);
    }

    @Test
    void addOrder_AddOrderToExistingOrderRepo_AsProductList() {
        Product bread = new Product(1, "bread");
        Product milk = new Product(2, "milk");
        Product honey = new Product(3, "honey");

        List<Product> testProductList = new ArrayList<>();
        testProductList.add(bread);
        testProductList.add(milk);
        testProductList.add(honey);

        List<Order> myTestOrderList = new ArrayList<>();
        myTestOrderList.add(new Order(1, testProductList));

        ShopService myTestShop = new ShopService(null, new OrderRepo(myTestOrderList));
        myTestShop.addOrder(testProductList);

        OrderRepo myTestOrderRepo = new OrderRepo(myTestOrderList);
        myTestOrderRepo.add((ArrayList<Product>) testProductList);
        //When
        OrderRepo actual = myTestShop.orderRepo;
        //
        Assertions.assertEquals(myTestOrderRepo, actual);
    }


}