package Shop2;

import java.util.List;

public class ShopService implements ProductRepo, OrderRepo{
    public ProductRepo productRepo;
    public OrderRepo orderRepo;

    public ShopService() {

    }
    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;

    }

    @Override
    public List<Order> orders() {
        return null;
    }

    @Override
    public List<Order> add() {
        return null;
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public String id() {
        return null;
    }

    @Override
    public List<Product> products() {
        return null;
    }

    @Override
    public List<Product> list() {
        return null;
    }

    @Override
    public Product get() {
        return null;
    }
}
