package InterfaceShop.model;


import InterfaceShop.service.HCG;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
public abstract class AbstractProduct implements Product{
   private String name;
   private int ID;

   public AbstractProduct(String name) {
       this.name = name;
       //this.ID = this.generateProductID(name);
       this.ID = new HCG(name).getHCG();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getID() {
        return this.ID;
    }

    @Override
    public String toString() {
        return "AbstractProduct{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractProduct that = (AbstractProduct) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }


}
