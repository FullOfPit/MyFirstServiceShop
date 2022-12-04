package InterfaceShop.repo;



import InterfaceShop.model.Order;
import InterfaceShop.model.Product;
import InterfaceShop.service.HCG;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
public class OrderRepo {
    public Map<Integer, Order> orderMap = new HashMap<>();
    public Map<Integer, LinkedList<Order>> orderMapL = new HashMap<>();

    public void addOrder(List<Product> productList) {
        int hashCode = new HCG("Unknown recipient").getHCG();
        Order newOrder = new Order("Unknown recipient", productList);
        if (this.orderMapL.get(hashCode) == null) {
            this.orderMapL.put(hashCode, new LinkedList<>());
            this.orderMapL.get(hashCode).add(newOrder);
        }

    }

    public void addOrder(Order order) {
        this.orderMap.put(new HCG(order.getRecipient()).getHCG(), order );
    }
    public void addOrder(int ID, Order order) {
        this.orderMap.put(ID, order);
    }






}
