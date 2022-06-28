package bondProject.com.example.Bond.projecto.finance.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@With
@Table(name="bond")
public class Bond {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch =FetchType.LAZY,optional = false)
    @JoinColumn(name = "enterprise_id",nullable = false)
    @JsonIgnore
    private Enterprise enterprise;

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
