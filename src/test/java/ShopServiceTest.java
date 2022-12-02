import Shop1.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ShopServiceTest {

    @Test
    void listProducts() {
        //Given
        Product milk = new Product("Milk", "1");
        Product bread = new Product("Bread", "2");
        Product honey = new Product("Honey", "3");
        Product bagels = new Product("Bagel", "4");
        Product crisps = new Product("Crisps", "5");

        ArrayList<Product> newProductList = new ArrayList<>();
        newProductList.add(milk);
        newProductList.add(bread);
        newProductList.add(honey);
        newProductList.add(bagels);
        newProductList.add(crisps);

        ProductRepo newProductRepo = new ProductRepo(newProductList);

        ArrayList<Product> orderList1 = new ArrayList<>();
        orderList1.add(milk);
        orderList1.add(bread);

        ArrayList<Product> orderList2 = new ArrayList<>();
        orderList1.add(honey);
        orderList1.add(bagels);


        Order firstOrder = new Order("1", orderList1);
        Order secondOrder = new Order("2", orderList2);

        ArrayList<Order> orderList = new ArrayList<>();
        orderList.add(firstOrder);
        orderList.add(secondOrder);

        OrderRepo newOrderRepo = new OrderRepo(orderList);


        ShopService newShopService = new ShopService(newProductRepo, newOrderRepo);
        //When
        List<Product> actual = newShopService.listProducts();
        //Then
        Assertions.assertEquals(
                newProductList, actual
        );

    }

    @Test
    void get() {
    }

    @Test
    void addOrder() {
    }

    @Test
    void getOrder() {

    }

    @Test
    void listOrders() {
    }

    @Test
    void getProductRepo() {
    }

    @Test
    void getOrderRepo() {
    }

    @Test
    void setProductRepo() {
    }

    @Test
    void setOrderRepo() {
    }
}