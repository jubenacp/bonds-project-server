package bondProject.com.example.Bond.projecto.finance.entities.resources;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
@Getter
@Setter
public class AuthenticateRequest {

    @NotNull
    private String email;
    @NotNull
    private String password;

}
