package bondProject.com.example.Bond.projecto.finance.repository;

import bondProject.com.example.Bond.projecto.finance.entities.Bond;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BondRepository extends JpaRepository<Bond, Long> {
    List<Bond> findByEnterpriseId(Long enterpriseId);
    Page<Bond> findByEnterpriseId(Long enterpriseId, Pageable pageable);
    Optional<Bond> findByIdAndEnterpriseId(Long id, Long userId);
    Optional<Bond>findById(Long id);
}
