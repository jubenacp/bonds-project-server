package bondProject.com.example.Bond.projecto.finance.entities.resources;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class BondResourceCreate {

    @NotNull
    private Long id;
    @NotNull
    private  Long userId;
    @NotNull
    private Float nominalValue;
    @NotNull
    private Float couponRate;
    @NotNull
    private Long paymentFrequency;
    @NotNull
    private Float deadlineDate;
    @NotNull
    private  Float negotiatedRate;
}
