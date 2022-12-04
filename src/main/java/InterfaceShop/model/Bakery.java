package InterfaceShop.model;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Bakery extends AbstractProduct implements Product{
    public Bakery(String name) {
        super(name);
    }
}
