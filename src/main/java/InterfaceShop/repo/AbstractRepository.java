package InterfaceShop.repo;

import InterfaceShop.service.HCG;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public abstract class AbstractRepository<O> {
    Map<Integer, O> objectMap = new HashMap<>();

    public O get(int ID) {
        if (this.objectMap.get(ID) != null) {
            return this.objectMap.get(ID);
        }
        throw new RuntimeException("ID not registered");

    }





}
