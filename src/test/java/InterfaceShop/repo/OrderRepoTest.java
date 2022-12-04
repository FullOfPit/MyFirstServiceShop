package InterfaceShop.repo;

import InterfaceShop.model.*;
import InterfaceShop.service.HCG;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class OrderRepoTest {

    //Auxilliary
    List<Product> generateTestProductList() {
        return Stream.of(new Bakery(), new Diary(),new Vegetable()).collect(Collectors.toList());
    }
    Order generateTestOrder() {
        return new Order("Test Recipient", generateTestProductList());
    }
    List<Order> generateTestOrderList() {
        return Stream.of(generateTestOrder()).collect(Collectors.toList());
    }

    @Test
    void orderRepoInstantiation_generatesMapForFutureDataStorage() {
        //Given
        OrderRepo testOrderRepo = new OrderRepo();
        //When
        Map<Integer, LinkedList<Order>> actual= testOrderRepo.orderMap;
        //Then
        Assertions.assertEquals(new HashMap<Integer, LinkedList<Order>>(), actual);
    }

    @Test
    void orderRepo_addExplicitIDOrderPairToMap() {
        //Given
        OrderRepo testOrderRepo = new OrderRepo();
        testOrderRepo.addOrder(1, generateTestOrder());

        Map<Integer, LinkedList<Order>> newTestOrderMap = new HashMap<>();
        newTestOrderMap.put(1, new LinkedList<>());
        newTestOrderMap.get(1).add(generateTestOrder());
        //When
        Map<Integer, LinkedList<Order>> actual= testOrderRepo.orderMap;
        //Then
        Assertions.assertEquals(newTestOrderMap, actual);
    }

    @Test
    void orderRepo_addOrder_CheckCorrectSizeOfLinkedList() {
        //Given
        OrderRepo testOrderRepo = new OrderRepo();
        testOrderRepo.addOrder(1, generateTestOrder());

        //When
        int actual= testOrderRepo.orderMap.get(1).size();
        //Then
        Assertions.assertEquals(1, actual);
    }

    @Test
    void orderRepo_addOrderToMap_WhenLinkedListAtHashCodeIsEmpty() {
        //Given
        OrderRepo testOrderRepo = new OrderRepo();
        int testRecipientKey = new HCG("Test Recipient").getHCG();
        testOrderRepo.addOrder(generateTestOrder());

        //When
        Order actual = testOrderRepo.orderMap.get(testRecipientKey).get(0);
        //Then
        Assertions.assertEquals(generateTestOrder(), actual);
    }

    @Test
    void orderRepo_addOrderToMap_WhenLinkedListAtHashCodeExists() {
        //Given
        OrderRepo testOrderRepo = new OrderRepo();
        int testRecipientKey = new HCG("Test Recipient").getHCG();
        testOrderRepo.addOrder(generateTestOrder());
        testOrderRepo.addOrder(generateTestOrder());

        //When
        Order actual = testOrderRepo.orderMap.get(testRecipientKey).get(1);
        //Then
        Assertions.assertEquals(generateTestOrder(), actual);
    }



    @Test
    void orderRepo_addOrderFromProductList_AddedToEmptyLinkedList_UnderCorrectKey() {
        //Given
        OrderRepo testOrderRepo = new OrderRepo();
        int unknownRecipientKey = new HCG("Unknown recipient").getHCG();
        testOrderRepo.addOrder(generateTestProductList());
        //When
        Order actual = testOrderRepo.orderMap.get(unknownRecipientKey).get(0);
        //Then
        Assertions.assertEquals(new Order("Unknown recipient", generateTestProductList()), actual);
    }

    @Test
    void orderRepo_addOrderFromProductList_AddedToExistingLinkedList_UnderCorrectKey() {
        //Given
        OrderRepo testOrderRepo = new OrderRepo();
        int unknownRecipientKey = new HCG("Unknown recipient").getHCG();
        testOrderRepo.addOrder(generateTestProductList());
        testOrderRepo.addOrder(generateTestProductList());
        //When
        Order actual = testOrderRepo.orderMap.get(unknownRecipientKey).get(1);
        //Then
        Assertions.assertEquals(new Order("Unknown recipient", generateTestProductList()), actual);
    }

    @Test
    void orderRepo_addOrder_WithID_ToEmptyLinkedList() {
        //Given
        OrderRepo testOrderRepo = new OrderRepo();
        testOrderRepo.addOrder(1, generateTestOrder());
        //When
        Order actual = testOrderRepo.orderMap.get(1).get(0);
        //Then
        Assertions.assertEquals(new Order("Test Recipient", generateTestProductList()), actual);
    }

    @Test
    void orderRepo_addOrder_WithID_ToExistingLinkedList() {
        //Given
        OrderRepo testOrderRepo = new OrderRepo();
        testOrderRepo.addOrder(1, generateTestOrder());
        testOrderRepo.addOrder(1, generateTestOrder());
        //When
        Order actual = testOrderRepo.orderMap.get(1).get(1);
        //Then
        Assertions.assertEquals(new Order("Test Recipient", generateTestProductList()), actual);
    }
}