package InterfaceShop.repo;

import InterfaceShop.model.*;
import InterfaceShop.service.HCG;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepoTest {

    //Auxilliary
    List<Product> generateTestProductList() {
        return Stream.of(new Bakery(), new Diary(),new Vegetable()).collect(Collectors.toList());
    }
    Order generateTestOrder() {
        return new Order("Christian", generateTestProductList());
    }
    List<Order> generateTestOrderList() {
        return Stream.of(generateTestOrder()).collect(Collectors.toList());
    }

    @Test
    void orderRepoInstantiation_generatesMapForFutureDataStorage() {
        //Given
        OrderRepo testOrderRepo = new OrderRepo();
        //When
        Map<Integer, Order> actual= testOrderRepo.orderMap;
        //Then
        Assertions.assertEquals(new HashMap<Integer, Order>(), actual);
    }

    @Test
    void orderRepo_addExplicitIDOrderPairToMap() {
        //Given
        OrderRepo testOrderRepo = new OrderRepo();
        testOrderRepo.addOrder(1, generateTestOrder());

        Map<Integer, Order> newTestOrderMap = new HashMap<>();
        newTestOrderMap.put(1, generateTestOrder());
        //When
        Map<Integer, Order> actual= testOrderRepo.orderMap;
        //Then
        Assertions.assertEquals(newTestOrderMap, actual);
    }

    @Test
    void orderRepo_addOrderToMap() {
        //Given
        OrderRepo testOrderRepo = new OrderRepo();
        testOrderRepo.addOrder(generateTestOrder());

        Map<Integer, Order> newTestOrderMap = new HashMap<>();
        newTestOrderMap.put(new HCG("Christian").getHCG(), generateTestOrder());
        //When
        Map<Integer, Order> actual= testOrderRepo.orderMap;
        //Then
        Assertions.assertEquals(newTestOrderMap, actual);
    }

    @Test
    void orderRepo_addOrderFromProductList() {
        //Given
        OrderRepo testOrderRepo = new OrderRepo();
        testOrderRepo.addOrder(generateTestProductList());

        Map<Integer, Order> newTestOrderMap = new HashMap<>();
        newTestOrderMap.put(
                new HCG("Unknown recipient").getHCG(),
                new Order("Unknown recipient", generateTestProductList())
        );
        //When
        Map<Integer, Order> actual= testOrderRepo.orderMap;
        //Then
        Assertions.assertEquals(newTestOrderMap, actual);
    }


}