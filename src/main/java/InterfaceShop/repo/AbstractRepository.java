package InterfaceShop.repo;

import InterfaceShop.service.HCG;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
public abstract class AbstractRepository<O> {
    Map<Integer, O> objectMap = new HashMap<>();




}
