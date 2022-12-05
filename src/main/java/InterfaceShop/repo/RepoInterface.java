package InterfaceShop.repo;


import java.util.List;
import java.util.Map;

public interface RepoInterface<O> {
    Map<Integer, O> list();
    O get(O object);
    void add(O object);

}
