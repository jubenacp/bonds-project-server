package bondProject.com.example.Bond.projecto.finance.controller;

import bondProject.com.example.Bond.projecto.finance.controller.mapping.bond.BondMapper;
import bondProject.com.example.Bond.projecto.finance.entities.resources.BondResource;
import bondProject.com.example.Bond.projecto.finance.entities.resources.BondResourceCreate;
import bondProject.com.example.Bond.projecto.finance.entities.resources.BondResourceUpdate;
import bondProject.com.example.Bond.projecto.finance.entities.resources.Bonds;
import bondProject.com.example.Bond.projecto.finance.services.BondService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name="bonds")
@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BondController {

    private final BondService bondService;
    private final BondMapper mapper;

    public BondController(BondService bondService, BondMapper mapper) {
        this.bondService = bondService;
        this.mapper = mapper;
    }
    @GetMapping("bonds/{bondId}")
    public BondResource getPostById(@PathVariable Long bondId){
        return mapper.toResource(bondService.getById(bondId));
    }

    @GetMapping("user/{userId}/bonds")
    public Page<Bonds> getAllTravelEventsByPostId(@PathVariable Long userId, Pageable pageable){
        return mapper.modelToListToPage2(bondService.getAllByUserId(userId),pageable);
    }
    @PostMapping("user/{userId}/bonds")
    public BondResource createTravelEvent(@PathVariable Long userId, @RequestBody BondResourceCreate request){
        return mapper.toResource(bondService.create(userId,mapper.toModel(request)));
    }
    @PutMapping("user/{userId}/bonds/{bondId}")
    public BondResource updateComment(@PathVariable Long userId,@PathVariable Long bondId, @RequestBody BondResourceUpdate request){
        return mapper.toResource(bondService.update(userId,bondId,mapper.toModel(request)));
    }
    @DeleteMapping("user/{userId}/bonds/{bondId}")
    public ResponseEntity<?> deleteComment(@PathVariable Long userId, @PathVariable Long bondId){
        return bondService.delete(userId,bondId);
    }

}
