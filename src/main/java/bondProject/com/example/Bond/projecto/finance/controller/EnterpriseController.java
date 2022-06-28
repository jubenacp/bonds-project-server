package bondProject.com.example.Bond.projecto.finance.controller;

import bondProject.com.example.Bond.projecto.finance.controller.mapping.enterprise.EnterpriseMapper;
import bondProject.com.example.Bond.projecto.finance.entities.resources.AuthenticateRequest;
import bondProject.com.example.Bond.projecto.finance.entities.resources.EnterpriseResource;
import bondProject.com.example.Bond.projecto.finance.entities.resources.EnterpriseResourceCreate;
import bondProject.com.example.Bond.projecto.finance.entities.resources.EnterpriseResourceUpdate;
import bondProject.com.example.Bond.projecto.finance.services.EnterpriseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name="enterprise")
@RestController
@RequestMapping("/api/v1/enterpriser")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EnterpriseController {
    private final EnterpriseService enterpriseService;
    private final EnterpriseMapper mapper;

public EnterpriseController(EnterpriseService enterpriseService,EnterpriseMapper mapper){
    this.enterpriseService = enterpriseService;
    this.mapper = mapper;
}

    @GetMapping()
    public Page<EnterpriseResource> getAllEnterprisers(Pageable pageable){

        return mapper.modelListToPage(enterpriseService.getAll(),pageable);
    }
    @GetMapping("{userId}")
    public EnterpriseResource getDriverById(@PathVariable Long userId){
        return mapper.toResource(enterpriseService.getById(userId));
    }
    @PostMapping
    public EnterpriseResource createDriver(@RequestBody EnterpriseResourceCreate request){
        return mapper.toResource(enterpriseService.create(mapper.toModel(request)));
    }
    @PutMapping("{userId}")
    public EnterpriseResource updateDriver(@PathVariable Long userId, @RequestBody EnterpriseResourceUpdate request){
        return mapper.toResource(enterpriseService.update(userId,mapper.toModel(request)));
    }
    @DeleteMapping("{userId}")
    public ResponseEntity<?> deleteDriver(@PathVariable Long userId){
        return  enterpriseService.delete(userId);
    }
    @PostMapping("/auth/log-in")
    public EnterpriseResource authenticate(@RequestBody AuthenticateRequest request){
        return mapper.toResource(enterpriseService.authenticate(request));
    }
}

