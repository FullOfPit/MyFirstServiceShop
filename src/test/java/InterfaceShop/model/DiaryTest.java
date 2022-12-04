package InterfaceShop.model;

import InterfaceShop.service.HCG;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaryTest {

    @Test
    void getName() {
        //Given
        Diary cheese = new Diary("Cheese");
        //When
        String actual = cheese.getName();
        //Then
        Assertions.assertEquals("Cheese", actual);

    }

    @Test
    void generateCustomHashCodeThroughAbstractClass() {
        //Given
        Diary cheese = new Diary("Cheese");
        //When
        int actual = cheese.getID();
        //Then
        Assertions.assertEquals(new HCG("Cheese").getHCG(), actual);

    }

}