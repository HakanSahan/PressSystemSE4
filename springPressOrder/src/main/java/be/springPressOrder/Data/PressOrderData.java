package be.springPressOrder.Data;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class PressOrderData {

    public Integer id = 0;

    @NotBlank(message = "Amount of fruit cannot be empty")
    public Integer fruitAmount;

    @NotBlank(message = "Fruit cannot be empty")
    public Integer fruitId;

    @NotBlank(message = "Client id cannot be empty")
    public Integer clientId;

    public Integer maxJuiceAmount;
}
