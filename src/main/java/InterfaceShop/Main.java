package InterfaceShop;

import InterfaceShop.model.Bakery;
import InterfaceShop.model.Diary;
import InterfaceShop.model.Vegetable;
import InterfaceShop.repo.ProductRepo;
import InterfaceShop.service.HCG;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ProductRepo newTestProductRepo = new ProductRepo();
        newTestProductRepo.productMap.put(1, new Vegetable());
        System.out.println(newTestProductRepo.productMap.get(1));

        Map<Integer, String> mappy = new HashMap<>();
        mappy.put(1, "Hello");
        mappy.get(1);

    }
}
