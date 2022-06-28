package bondProject.com.example.Bond.projecto.finance.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("enhancedModelMapperConfiguration")
public class MappingConfiguration {
    @Bean
    public EnhancedModelMapper modelMapper(){
        return new EnhancedModelMapper();
    }
}
