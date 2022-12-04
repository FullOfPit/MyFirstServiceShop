package InterfaceShop.repo;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
public abstract class AbstractRepository<O> implements RepoInterface<O>{
    Map<Integer, O> objectMap = new HashMap<>();

    public AbstractRepository(List<O> objectList) {
        for (O object : objectList) {
            this.add(object);
        }
    }

    public O get(String name) {
        O object = this.objectMap.get(generateObjectID(name));
        if (object == null) {
            throw new RuntimeException("ID not registered");
        }
        return object;
    }

    public List<O> list() {
        return new ArrayList<>(this.objectMap.values());
    }


    public int generateObjectID(@NotNull String name) {
        int objectID = 0;
        for(int i = 0; i < name.length(); i++) {
            int temp = name.charAt(i) * 5;
            temp += 13;
            temp += (int)Math.sqrt(name.charAt(i)) * 3;
            objectID += temp;
            temp = 0;
        }
        return objectID;
    }






    /*
    Map<Integer, O> objectMap = new HashMap<>();

    public AbstractClass(List<O> objectList) {
        for (O object : objectList) {
            this.add(object);
        }
    }
    @Override
    public List<O> list() {
        return new ArrayList<O>(
                this.objectMap.values()
        );
    }

    @Override
    public O get(O object) {
        if (this.objectMap.get((int)object) != null) {
            return this.objectMap.get((int)object);
        }
        throw new RuntimeException("ID not registered");
    }

     */

}
