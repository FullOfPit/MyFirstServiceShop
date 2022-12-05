package InterfaceShop.repo;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface RepoInterface<O> {
    List<O> list();
    O get(O object);
    void add(O object);

}
