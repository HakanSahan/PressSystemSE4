package be.springPressOrder.Data;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Data
public class OrderData {

    public Integer id = 0;

    @NotNull(message = "Fruit amount cannot be empty")
    public Integer fruitAmount;

    @NotNull(message = "Fruit amount cannot be empty")
    public Integer fruitId;

    public Integer clientId;

}
