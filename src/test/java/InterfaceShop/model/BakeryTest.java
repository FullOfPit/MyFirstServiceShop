package InterfaceShop.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import InterfaceShop.service.HCG;


class BakeryTest {

    @Test
    void getName() {
        //Given
        Bakery bread = new Bakery("Bread");
        //When
        String actual = bread.getName();
        //Then
        Assertions.assertEquals("Bread", actual);

    }

    @Test
    void generateCustomHashCodeThroughAbstractClass() {
        //Given
        Bakery bread = new Bakery("Bread");
        //When
        int actual = bread.getID();
        //Then
        Assertions.assertEquals(new HCG("Bread").getHCG(), actual);

    }


}