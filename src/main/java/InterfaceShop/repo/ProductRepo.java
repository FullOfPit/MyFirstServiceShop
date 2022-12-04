package InterfaceShop.repo;

import InterfaceShop.model.Product;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class ProductRepo extends AbstractRepository<Product>{
    public ProductRepo(List<Product> objectList) {
        for (Product product : objectList) {
            this.add(product);
        }
    }

    @Override
    public Product get(String name) {
        return this.objectMap.get(
                generateObjectID(name));
    }


    @Override
    public Product get(Product object) {
        return this.objectMap.get(
                generateObjectID(object.getName()));
    }

    public void add(Product object) {
        this.objectMap.putIfAbsent(
                generateObjectID(object.getName()),
                object);
    }
}
