package InterfaceShop.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Diary extends AbstractProduct implements Product{
    public Diary(String name) {
        super(name);
    }
}
