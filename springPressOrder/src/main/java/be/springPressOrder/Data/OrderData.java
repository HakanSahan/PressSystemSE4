package be.springPressOrder.Data;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class OrderData {

    public Integer id = 0;

    @NotBlank(message = "Fruit amount cannot be empty")
    public Integer fruitAmount;

    public Integer fruitId;

    public Integer clientId;

}
