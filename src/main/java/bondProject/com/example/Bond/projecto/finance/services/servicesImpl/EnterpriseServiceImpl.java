package bondProject.com.example.Bond.projecto.finance.services.servicesImpl;

import bondProject.com.example.Bond.projecto.finance.entities.resources.AuthenticateRequest;
import bondProject.com.example.Bond.projecto.finance.config.ResourceNotFoundException;
import bondProject.com.example.Bond.projecto.finance.config.ResourceValidationException;
import bondProject.com.example.Bond.projecto.finance.entities.Enterprise;
import bondProject.com.example.Bond.projecto.finance.repository.EnterpriseRepository;
import bondProject.com.example.Bond.projecto.finance.services.EnterpriseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    private static final  String ENTITY="enterprise";
    private final EnterpriseRepository enterpriseRepository;
    private final Validator validator;

    public EnterpriseServiceImpl(EnterpriseRepository enterpriseRepository, Validator validator) {
        this.enterpriseRepository = enterpriseRepository;
        this.validator = validator;
    }

    @Override
    public List<Enterprise> getAll() {
        return enterpriseRepository.findAll();
    }

    @Override
    public Page<Enterprise> getAll(Pageable pageable) {
        return enterpriseRepository.findAll(pageable);
    }

    @Override
    public Enterprise getById(Long userId) {
        return enterpriseRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException(ENTITY,userId));
    }

    @Override
    public Enterprise create(Enterprise enterprise) {
        Set<ConstraintViolation<Enterprise>> violations =validator.validate(enterprise);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY,violations);
        Enterprise enterpriseWithEmail=enterpriseRepository.findByEmail(enterprise.getEmail());

        if(enterpriseWithEmail!=null){
            throw new ResourceValidationException(ENTITY,"An enterprise with the same Email already exist");
        }
        return enterpriseRepository.save(enterprise);
    }

    @Override
    public Enterprise update(Long enterpriseId, Enterprise request) {
        Set<ConstraintViolation<Enterprise>> violations =validator.validate(request);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY,violations);
        Enterprise enterpriseByEmail = enterpriseRepository.findByEmail(request.getEmail());
        if(enterpriseByEmail!=null&& !enterpriseByEmail.getId().equals(enterpriseId)){
            throw new ResourceValidationException(ENTITY,"A post with the same email already exist");
        }
        return enterpriseRepository.findById(enterpriseId).map(post->enterpriseRepository.save(post
                        .withSocialReason(request.getSocialReason())
                        .withEmail(request.getEmail())
                        .withPassword(request.getPassword())
                ))
                .orElseThrow(()->new ResourceNotFoundException(ENTITY,enterpriseId));
    }

    @Override
    public ResponseEntity<?> delete(Long userId) {
        return enterpriseRepository.findById(userId).map(enterprise->{
            enterpriseRepository.delete(enterprise);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ResourceNotFoundException(ENTITY,userId));
    }

    @Override
    public Enterprise authenticate(AuthenticateRequest request) {
        Enterprise enterpriseRepositoryByEmail=enterpriseRepository.findByEmail(request.getEmail());
        return enterpriseRepository.findById(enterpriseRepositoryByEmail.getId()).orElseThrow(()->new ResourceNotFoundException(ENTITY,enterpriseRepositoryByEmail.getId()));
    }

}
