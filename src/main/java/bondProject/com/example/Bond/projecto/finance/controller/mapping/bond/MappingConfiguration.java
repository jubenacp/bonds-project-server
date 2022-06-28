package bondProject.com.example.Bond.projecto.finance.controller.mapping.bond;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("BondsMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public BondMapper bondMapper(){
        return new BondMapper();
    }

}
