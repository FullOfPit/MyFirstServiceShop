package InterfaceShop.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import InterfaceShop.model.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    //Auxilliary
    public List<Product> testBakeryList() {
        return Stream.of(new Bakery()).collect(Collectors.toList());
    }
    public List<Product> testDiaryList() {
        return Stream.of(new Diary()).collect(Collectors.toList());
    }
    public List<Product> testVegetableList() {
        return Stream.of(new Vegetable()).collect(Collectors.toList());
    }
    public List<Product> testMixedList() {
        return Stream.of(new Bakery(), new Diary(),new Vegetable()).collect(Collectors.toList());
    }

    @Test
    void generateNewEmptyOrder() {
        //Given
        Order christiansOrder = new Order();
        //When
        String actual = christiansOrder.getRecipient();
        //Then
        Assertions.assertEquals(null, actual);
    }

    @Test
    void generateNewOrder_WithRecipient_EmptyList() {
        //Given
        Order christiansOrder = new Order("Christian", null);
        //When
        String actual = christiansOrder.getRecipient();
        //Then
        Assertions.assertEquals("Christian", actual);
    }

    @Test
    void generateNewOrder_WithRecipient_BakeryList() {
        //Given
        Order christiansOrder = new Order("Christian", testBakeryList());
        //When
        List<Product> actual = christiansOrder.getProductList();
        //Then
        Assertions.assertEquals(Stream.of(new Bakery()).collect(Collectors.toList()), actual);
    }
    @Test
    void generateNewOrder_WithRecipient_DiaryList() {
        //Given
        Order christiansOrder = new Order("Christian", testDiaryList());
        //When
        List<Product> actual = christiansOrder.getProductList();
        //Then
        Assertions.assertEquals(Stream.of(new Diary()).collect(Collectors.toList()), actual);
    }
    @Test
    void generateNewOrder_WithRecipient_VegetableList() {
        //Given
        Order christiansOrder = new Order("Christian", testVegetableList());
        //When
        List<Product> actual = christiansOrder.getProductList();
        //Then
        Assertions.assertEquals(Stream.of(new Vegetable()).collect(Collectors.toList()), actual);
    }

    @Test
    void generateNewOrder_WithRecipient_MixedList() {
        //Given
        Order christiansOrder = new Order("Christian", testMixedList());
        //When
        List<Product> actual = christiansOrder.getProductList();
        //Then
        Assertions.assertEquals(Stream.of(new Bakery(), new Diary(), new Vegetable()).collect(Collectors.toList()), actual);
    }



}