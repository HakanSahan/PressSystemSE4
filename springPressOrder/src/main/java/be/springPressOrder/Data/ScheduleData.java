package be.springPressOrder.Data;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

@Data
public class ScheduleData {

    public Integer id = 0;

    @NotBlank(message = "Machine cannot be blank")
    public Integer machineId;

    @NotBlank(message = "Press order cannot be blank")
    public Integer pressOrderId;

    @NotBlank(message = "Begin hour cannot be blank")
    public Date beginHour;

    @NotBlank(message = "End hour cannot be blank")
    public Date endHour;

}
