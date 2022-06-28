package bondProject.com.example.Bond.projecto.finance.entities.resources;

import javax.validation.constraints.NotNull;

public class EnterpriseResourceUpdate {

    private Long id;
    @NotNull
    private String SocialReason;
    @NotNull
    private  String email;
    @NotNull
    private  String password;

}
