package bondProject.com.example.Bond.projecto.finance.repository;

import bondProject.com.example.Bond.projecto.finance.entities.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository  extends JpaRepository<Enterprise, Long> {
    Enterprise findByEmail(String dni);
}
