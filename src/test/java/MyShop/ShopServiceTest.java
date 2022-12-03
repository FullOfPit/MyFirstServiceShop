package MyShop;

import MyShop.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ShopServiceTest {

    //Setup methods
    List<Product> generateTestProductList() {

        return new ArrayList<>(
                Stream.of(
                        new Product(1, "1"),
                        new Product(2, "2"),
                        new Product(3, "3")
                ).collect(Collectors.toList())
        );
    }

    ProductRepo generateTestProductRepo() {
        return new ProductRepo(generateTestProductList());
    }

    Order generateTestOrder() {
        return new Order(1, generateTestProductList());
    }
    List<Order> generateTestOrderList() {
        return Stream.of(generateTestOrder()).collect(Collectors.toList());

    }

    OrderRepo generateTestOrderRepo() {
        return new OrderRepo(generateTestOrderList());
    }


    //                          -----------------------Testing------------------------
    @Test
    void listProducts_ReturnsListOfProducts() {
        //Given
        ShopService myTestShop = new ShopService(generateTestProductRepo(), null);
        //When
        List<Product> actual = myTestShop.listProducts();
        //Then
        Assertions.assertEquals(generateTestProductList(), actual);

    }

    @Test
    void listOrders_ReturnListOfOrders() {
        // Given
        ShopService myTestShop = new ShopService(null, generateTestOrderRepo());
        // When
        List<Order> actual = myTestShop.listOrders();
        // Then
        Assertions.assertEquals(generateTestOrderList() ,actual);

    }

    @Test
    void getProduct_byProduct() {
        //Given
        ShopService myTestShop = new ShopService(generateTestProductRepo(), null);
        //When
        Product actual = myTestShop.getProduct(new Product(2, "2"));
        //Then
        Assertions.assertEquals(new Product(2, "2"), actual);
    }

    @Test
    void getProduct_byID() {
        //Given
        ShopService myTestShop = new ShopService(generateTestProductRepo(), null);
        //When
        Product actual = myTestShop.getProduct(2);
        //Then
        Assertions.assertEquals(new Product(2, "2"), actual);

    }

    @Test
    void getProduct_byID_ThrowRunExcIfIDNotRegistered() {
        //Given
        ShopService myTestShop = new ShopService(generateTestProductRepo(), null);
        //When - Then

        try {
            Product actual = myTestShop.getProduct(4);
            Assertions.fail();
        } catch (RuntimeException e) {
            Assertions.assertEquals("MyShop.Product not registered", e.getMessage());

        }
    }

    @Test
    void getProduct_byID_ThrowRunExcIfIProductNotRegistered() {
            //Given
            ShopService myTestShop = new ShopService(generateTestProductRepo(), null);
            //When - Then
            try {
                Product actual = myTestShop.getProduct(new Product(4, "4"));
                Assertions.fail();
            } catch (RuntimeException e) {
                Assertions.assertEquals("MyShop.Product not registered", e.getMessage());

            }
        }

        @Test
        void getOrder_byOrder() {
            // Given
            ShopService myTestShop = new ShopService(null, generateTestOrderRepo());
            // When
            Order actual = myTestShop.getOrder(new Order(1, generateTestProductList()));
            // Then
            Assertions.assertEquals(generateTestOrder(), actual);
        }

    @Test
    void getOrder_byID() {
        // Given
        ShopService myTestShop = new ShopService(null, generateTestOrderRepo());
        // When
        Order actual = myTestShop.getOrder(1);
        // Then
        Assertions.assertEquals(new Order(1, generateTestProductList()), actual);
    }

    @Test
    void addOrder_AddOrderToEmptyOrderRepo_AsOrderObject() {
        ShopService myTestShop = new ShopService(null, null);
        myTestShop.addOrder(generateTestOrder());

        OrderRepo myTestOrderRepo = generateTestOrderRepo();
        //When
        OrderRepo actual = myTestShop.orderRepo;
        //
        Assertions.assertEquals(myTestOrderRepo, actual);
    }

    @Test
    void addOrder_AddOrderToEmptyOrderRepo_AsOrderProductList() {
        ShopService myTestShop = new ShopService(null, null);
        myTestShop.addOrder(generateTestOrder());

        //When
        OrderRepo actual = myTestShop.orderRepo;
        //
        Assertions.assertEquals(generateTestOrderRepo(), actual);
    }

    @Test
    void addOrder_AddOrderToExistingOrderRepo_AsOrderObject() {

        ShopService myTestShop = new ShopService(null, generateTestOrderRepo());
        myTestShop.addOrder(new Order(2, generateTestProductList()));

        OrderRepo myTestOrderRepo = new OrderRepo(generateTestOrderList());
        myTestOrderRepo.add(generateTestOrder());
        //When
        OrderRepo actual = myTestShop.orderRepo;
        //
        Assertions.assertEquals(myTestOrderRepo, actual);
    }

    @Test
    void addOrder_AddOrderToExistingOrderRepo_AsProductList() {

        ShopService myTestShop = new ShopService(null, generateTestOrderRepo());
        myTestShop.addOrder(generateTestProductList());

        OrderRepo myTestOrderRepo = generateTestOrderRepo();
        myTestOrderRepo.add((ArrayList<Product>) generateTestProductList());
        //When
        OrderRepo actual = myTestShop.orderRepo;
        //
        Assertions.assertEquals(myTestOrderRepo, actual);
    }


}