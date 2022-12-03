package InterfaceShop;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        ProductRepo newProductRepo = new ProductRepo(
                Stream.of(new Bread(), new Cheese(), new Cheese()).collect(Collectors.toList())
        );

        newProductRepo.list().add(new Bread());
        System.out.println(newProductRepo.list());
    }
}
