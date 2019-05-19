package be.springPressOrder.Data;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Data
public class PressOrderData {

    public Integer id = 0;

    @NotNull(message = "Amount of fruit cannot be empty")
    public Integer fruitAmount;

    @NotNull(message = "Fruit cannot be empty")
    public Integer fruitId;

    @NotNull(message = "Client id cannot be empty")
    public Integer clientId;

    public Integer maxJuiceAmount;
}
