package Shop1;

import Shop1.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Product milk = new Product("Milk", "1");
        Product bread = new Product("Bread", "2");
        Product honey = new Product("Honey", "3");
        Product bagels = new Product("Bagel", "4");
        Product crisps = new Product("Crisps", "5");

        ArrayList<Product> newProductList = new ArrayList<>();
        newProductList.add(milk);
        newProductList.add(bread);
        newProductList.add(honey);
        newProductList.add(bagels);
        newProductList.add(crisps);

        ProductRepo newProductRepo = new ProductRepo(newProductList);




        ArrayList<Product> productList1 = new ArrayList<>();
        productList1.add(milk);
        productList1.add(bread);

        ArrayList<Product> productList2 = new ArrayList<>();
        productList2.add(honey);
        productList2.add(bagels);


        Order firstOrder = new Order("1", productList1);
        Order secondOrder = new Order("2", productList2);

        ArrayList<Order> orderList = new ArrayList<>();
        orderList.add(firstOrder);
        orderList.add(secondOrder);

        OrderRepo newOrderRepo = new OrderRepo(orderList);


        ShopService newShopService = new ShopService(newProductRepo, newOrderRepo);


        System.out.println(newShopService.get(milk));
        System.out.println(newShopService.listProducts());

        System.out.println(newShopService.listOrders());

    }
}
