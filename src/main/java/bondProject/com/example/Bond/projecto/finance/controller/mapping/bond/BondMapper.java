package bondProject.com.example.Bond.projecto.finance.controller.mapping.bond;

import bondProject.com.example.Bond.projecto.finance.config.EnhancedModelMapper;
import bondProject.com.example.Bond.projecto.finance.entities.Bond;
import bondProject.com.example.Bond.projecto.finance.entities.resources.BondResource;
import bondProject.com.example.Bond.projecto.finance.entities.resources.BondResourceCreate;
import bondProject.com.example.Bond.projecto.finance.entities.resources.BondResourceUpdate;
import bondProject.com.example.Bond.projecto.finance.entities.resources.Bonds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class BondMapper {
    @Autowired
    EnhancedModelMapper mapper;

    public BondResource toResource(Bond model){
        return mapper.map(model,BondResource.class);

    }
    public Bonds toResourceList(Bond model){
        return mapper.map(model,Bonds.class);
    }

    public Page<BondResource> modelToListToPage(List<Bond> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList,BondResource.class),pageable,modelList.size());
    }
    public Page<Bonds> modelToListToPage2(List<Bond> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList,Bonds.class),pageable,modelList.size());
    }
    public Bond toModel(BondResourceCreate resource){
        return  mapper.map(resource,Bond.class);
    }
    public Bond toModel(BondResourceUpdate resource){
        return  mapper.map(resource,Bond.class);
    }
}
