package InterfaceShop.model;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Vegetable extends AbstractProduct implements Product{
    public Vegetable(String name) { super(name); }

}
