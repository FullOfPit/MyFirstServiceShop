package InterfaceShop.model;

import InterfaceShop.service.HCG;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VegetableTest {

    @Test
    void getName() {
        //Given
        Vegetable courgette = new Vegetable("Courgette");
        //When
        String actual = courgette.getName();
        //Then
        Assertions.assertEquals("Courgette", actual);
    }

    @Test
    void generateCustomHashCodeThroughAbstractClass() {
        //Given
        Vegetable courgette = new Vegetable("Courgette");
        //When
        int actual = courgette.getID();
        //Then
        Assertions.assertEquals(new HCG("Courgette").getHCG(), actual);

    }

}