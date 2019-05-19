package be.springPressOrder.Data;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

@Data
public class RequestTechnicianData {

    public int Id = 0;

    @NotBlank(message = "Message cannot be blank")
    public String message;

    @NotBlank(message = "technician cannot be blank")
    public Integer technicianId;

    public Date sendDate;

    public RequestTechnicianData(){
        sendDate = new Date();
    }

}
