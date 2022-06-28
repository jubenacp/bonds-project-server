package bondProject.com.example.Bond.projecto.finance.services;

import bondProject.com.example.Bond.projecto.finance.entities.Bond;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BondService {
    List<Bond> getAll();
    List<Bond> getAllByUserId(Long userId);
    Page<Bond> getAllByUserId(Long userId, Pageable pageable);
    Bond getById(Long bondId);
    Bond create(Long userId, Bond request);
    Bond update(Long userId, Long bondId, Bond request);
    ResponseEntity<?> delete(Long userId, Long bondId);
}
