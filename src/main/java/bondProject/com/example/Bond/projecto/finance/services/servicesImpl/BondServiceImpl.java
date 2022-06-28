package bondProject.com.example.Bond.projecto.finance.services.servicesImpl;

import bondProject.com.example.Bond.projecto.finance.config.ResourceNotFoundException;
import bondProject.com.example.Bond.projecto.finance.config.ResourceValidationException;
import bondProject.com.example.Bond.projecto.finance.entities.Bond;
import bondProject.com.example.Bond.projecto.finance.repository.BondRepository;
import bondProject.com.example.Bond.projecto.finance.repository.EnterpriseRepository;
import bondProject.com.example.Bond.projecto.finance.services.BondService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class BondServiceImpl implements BondService {
    private static final  String ENTITY="bonds";
    private final BondRepository bondRepository;
    private final EnterpriseRepository enterpriseRepository;
    private final Validator validator;

    public BondServiceImpl(BondRepository bondRepository, EnterpriseRepository enterpriseRepository, Validator validator){
        this.bondRepository = bondRepository;
        this.enterpriseRepository = enterpriseRepository;
        this.validator = validator;

    }

    @Override
    public List<Bond> getAll() {
        return null;
    }

    @Override
    public List<Bond> getAllByUserId(Long userId) {
        return  bondRepository.findByEnterpriseId(userId);
    }

    @Override
    public Page<Bond> getAllByUserId(Long userId, Pageable pageable) {
        return  bondRepository.findByEnterpriseId(userId,pageable);
    }

    @Override
    public Bond getById(Long bondId) {
        return bondRepository.findById(bondId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, bondId));
    }

    @Override
    public Bond create(Long userId, Bond request) {
        Set<ConstraintViolation<Bond>> violations=validator.validate(request);
        if(!violations.isEmpty()){
            throw new ResourceValidationException(ENTITY,violations);
        }

        return enterpriseRepository.findById(userId).map(nuevito -> {
            request.setEnterprise(nuevito);
            return bondRepository.save(request);
        }).orElseThrow(()-> new ResourceNotFoundException("User",userId));
    }

    @Override
    public Bond update(Long userId, Long bondId, Bond request) {
        Set<ConstraintViolation<Bond>> violations = validator.validate(request);
        if(!violations.isEmpty()){
            throw new ResourceValidationException(ENTITY,violations);
        }

        if (!enterpriseRepository.existsById(userId))
            throw new ResourceNotFoundException("Post",userId);
        return bondRepository.findById(bondId).map(comment ->
                        bondRepository.save(
                                comment.withUserId(request.getUserId())
                                        .withNominalValue(request.getNominalValue())
                                        .withCouponRate(request.getCouponRate())
                                        .withPaymentFrequency(request.getPaymentFrequency())
                                        .withDeadlineDate(request.getDeadlineDate())
                                        .withNegotiatedRate(request.getNegotiatedRate())
                        ))
                .orElseThrow(()->new ResourceNotFoundException(ENTITY,userId));
    }

    @Override
    public ResponseEntity<?> delete(Long userId, Long bondId) {

        return bondRepository.findById(bondId).map(driver->{
            bondRepository.delete(driver);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ResourceNotFoundException(ENTITY,userId));
    }

}
