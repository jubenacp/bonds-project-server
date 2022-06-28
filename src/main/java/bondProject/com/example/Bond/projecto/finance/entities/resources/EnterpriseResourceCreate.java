package bondProject.com.example.Bond.projecto.finance.entities.resources;

import lombok.*;

import javax.validation.constraints.NotNull;
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class EnterpriseResourceCreate {

    @NotNull
    private String SocialReason;
    @NotNull
    private  String email;
    @NotNull
    private  String password;

}
