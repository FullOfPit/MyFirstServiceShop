package InterfaceShop.repo;



import InterfaceShop.model.Order;
import InterfaceShop.model.Product;
import InterfaceShop.service.HCG;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
public class OrderRepo {
    public Map<Integer, LinkedList<Order>> orderMap = new HashMap<>();

    public Map<Integer, LinkedList<Order>> list() {
        return this.orderMap;
    }

    public LinkedList<Order> get(int ID) {
        return this.orderMap.get(ID);
    }

    public void addOrder(List<Product> productList) {
        int hashCode = new HCG("Unknown recipient").getHCG();
        Order newOrder = new Order("Unknown recipient", productList);
        if (this.orderMap.get(hashCode) == null) {
            this.orderMap.put(hashCode, new LinkedList<>());
            this.orderMap.get(hashCode).add(newOrder);
        } else {
            this.orderMap.get(hashCode).add(newOrder);
        }

    }

    public void addOrder(Order order) {
        int hashCode = new HCG(order.getRecipient()).getHCG();
        if (this.orderMap.get(hashCode) == null) {
            this.orderMap.put(hashCode, new LinkedList<>());
            this.orderMap.get(hashCode).add(order);
        } else {
            this.orderMap.get(hashCode).add(order);
        }
    }
    public void addOrder(int ID, Order order) {
        if (this.orderMap.get(ID) == null) {
            this.orderMap.put(ID, new LinkedList<>());
            this.orderMap.get(ID).add(order);
        } else {
            this.orderMap.get(ID).add(order);
        }



    }






}
