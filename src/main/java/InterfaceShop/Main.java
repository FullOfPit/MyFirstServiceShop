package InterfaceShop;

import InterfaceShop.model.Bakery;
import InterfaceShop.model.Diary;
import InterfaceShop.repo.ProductRepo;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Diary milk = new Diary("Milk");
        Diary cheese = new Diary("Cheese");
        System.out.println(milk.getID());
        System.out.println(cheese.getID());

    }
}
