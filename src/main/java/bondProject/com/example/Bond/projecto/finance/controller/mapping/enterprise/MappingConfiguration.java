package bondProject.com.example.Bond.projecto.finance.controller.mapping.enterprise;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("EnterprisesMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public EnterpriseMapper enterpriseMapper(){
        return new EnterpriseMapper();
    }
}
