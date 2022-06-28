package bondProject.com.example.Bond.projecto.finance.services;

import bondProject.com.example.Bond.projecto.finance.entities.resources.AuthenticateRequest;
import bondProject.com.example.Bond.projecto.finance.entities.Enterprise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EnterpriseService {
    List<Enterprise> getAll();
    Page<Enterprise> getAll(Pageable pageable);
    Enterprise getById(Long enterpriseId);
    Enterprise create(Enterprise enterprise);
    Enterprise update(Long enterpriseId, Enterprise request);
    ResponseEntity<?> delete(Long enterpriseId);
    Enterprise authenticate (AuthenticateRequest request);
}
