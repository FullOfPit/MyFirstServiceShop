package InterfaceShop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class hashCodeGeneratorTest {

    //Setup methods
    @Test
    void generateIntForOneCharacter() {
        //Given
        String a = "a";
        //When
        int actual = a.charAt(0);
        //Then
        Assertions.assertEquals(97, actual);
    }

    @Test
    void generateIntForOneCharacterTimesFive() {
        //Given
        String a = "a";
        //When
        int actual = a.charAt(0);
        actual *= 5;
        //Then
        Assertions.assertEquals(97 * 5, actual);
    }

    @Test
    void generateIntForOneCharacterTimes_FivePlus13() {
        //Given
        String a = "a";
        //When
        int actual = a.charAt(0);
        actual *= 5;
        actual += 13;
        //Then
        Assertions.assertEquals(97 * 5 + 13, actual);
    }

    @Test
    void generateIntForOneCharacterTimesFive_Plus13_PlusSqRtOfCharacter() {
        //Given
        String a = "a";
        //When
        int actual = a.charAt(0);
        actual *= 5;
        actual += 13;
        actual += (int)Math.sqrt(a.charAt(0));
        //Then
        Assertions.assertEquals(97 * 5 + 13 + (int)Math.sqrt('a'), actual);
    }

    @Test
    void generateIntForOneCharacterTimesFive_Plus13_PlusSqRtOfCharacterTimesThree() {
        //Given
        String a = "a";
        //When
        int actual = a.charAt(0);
        actual *= 5;
        actual += 13;
        actual += (int)Math.sqrt(a.charAt(0)) * 3;
        //Then
        Assertions.assertEquals(97 * 5 + 13 + (int)Math.sqrt('a') * 3, actual);
    }

    @Test
    void generateIntFunctionForOneCharacter() {
        //Given
        //(int) 'a' = 97
        HCG testCode = new HCG("a");
        //When
        int actual = testCode.getHCG();
        //Then
        Assertions.assertEquals(97 * 5 + 13 + (int)Math.sqrt('a') * 3, actual);
    }

    @Test
    void generateIntFunctionForTwoCharacters() {
        //Given
        //(int) 'a' = 97
        HCG testCode = new HCG("ao");
        //When
        int actual = testCode.getHCG();
        //Then
        Assertions.assertEquals(
                (97 * 5 + 13 + (int)Math.sqrt('a') * 3) +
                        (111 * 5 + 13 + (int)Math.sqrt('o') * 3),
                actual);
    }

    @Test
    void generateIntFunctionForThreeCharacters() {
        //Given
        //(int) 'a' = 97
        HCG testCode = new HCG("aok");
        //When
        int actual = testCode.getHCG();
        //Then
        Assertions.assertEquals(
                (97 * 5 + 13 + (int)Math.sqrt('a') * 3) +
                        (107 * 5 + 13 + (int)Math.sqrt('k') * 3) +
                        (111 * 5 + 13 + (int)Math.sqrt('o') * 3),
                actual);
    }





}