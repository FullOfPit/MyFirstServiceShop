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

    @Test
    void orderRepo_listMethod_returnsEmptyMapWhenItShouldBeEmpty() {
        //Given
        OrderRepo testOrderRepo = new OrderRepo();
        //When
        Map<Integer, LinkedList<Order>> actual = testOrderRepo.list();
        //Then
        Assertions.assertEquals(new HashMap<Integer, LinkedList<Order>>(), actual);
    }

    @Test
    void orderRepo_listMethod_returnsMapWithOneItemSet() {
        //Given
        OrderRepo testOrderRepo = new OrderRepo();
        testOrderRepo.addOrder(1, generateTestOrder());

        Map<Integer, LinkedList<Order>> testMap = new HashMap<Integer, LinkedList<Order>>();
        testMap.put(1, new LinkedList<>());
        testMap.get(1).add(generateTestOrder());
        //When
        Map<Integer, LinkedList<Order>> actual = testOrderRepo.list();
        //Then
        Assertions.assertEquals(testMap, actual);
    }

    @Test
    void orderRepo_listMethod_returnsMapWithTwoItemSet() {
        //Given
        OrderRepo testOrderRepo = new OrderRepo();
        testOrderRepo.addOrder(1, generateTestOrder());
        testOrderRepo.addOrder(generateTestOrder());

        Map<Integer, LinkedList<Order>> testMap = new HashMap<Integer, LinkedList<Order>>();
        testMap.put(1, new LinkedList<>());
        testMap.get(1).add(generateTestOrder());
        testMap.put(new HCG("Test Recipient").getHCG(), new LinkedList<>());
        testMap.get(new HCG("Test Recipient").getHCG()).add(generateTestOrder());
        //When
        Map<Integer, LinkedList<Order>> actual = testOrderRepo.list();
        //Then
        Assertions.assertEquals(testMap, actual);
    }

    @Test
    void orderRepo_getMethod_getLinkedListThroughIDIfLinkedListPresent() {
        //Given
        OrderRepo testOrderRepo = new OrderRepo();
        testOrderRepo.addOrder(1, generateTestOrder());

        LinkedList<Order> testList = new LinkedList<>();
        testList.add(generateTestOrder());

        //When
        LinkedList<Order> actual = testOrderRepo.get(1);
        //Then
        Assertions.assertEquals(testList, actual);
    }

    @Test
    void orderRepo_getMethod_throwExceptionWhenIDNotRegistered() {
        //Given
        OrderRepo testOrderRepo = new OrderRepo();
        //When - Then
        try {
            testOrderRepo.get(1);
            Assertions.fail();
        } catch (RuntimeException e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    void orderRepo_getMethod_acceptStringAndReturnOrderByRecipientString() {
        //Given
        OrderRepo testOrderRepo = new OrderRepo();
        testOrderRepo.addOrder(generateTestOrder());

        Map<Integer, LinkedList<Order>> testMap = new HashMap<>();
        int hashCode = new HCG(generateTestOrder().getRecipient()).getHCG();
        testMap.put(hashCode,  new LinkedList<>());
        testMap.get(hashCode).add(generateTestOrder());
        //When
        LinkedList<Order> actual = testOrderRepo.get("Test Recipient");
        //Then
        Assertions.assertEquals(testMap.get(hashCode), actual);

    }

}