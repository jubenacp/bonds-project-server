package bondProject.com.example.Bond.projecto.finance.entities.resources;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class BondResource {

    private Long id;
    private  Long userId;
    private Float nominalValue;
    private Float couponRate;
    private Long paymentFrequency;
    private Float deadlineDate;
    private  Float negotiatedRate;

}
