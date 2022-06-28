package bondProject.com.example.Bond.projecto.finance.controller.mapping.enterprise;

import bondProject.com.example.Bond.projecto.finance.config.EnhancedModelMapper;
import bondProject.com.example.Bond.projecto.finance.entities.Enterprise;
import bondProject.com.example.Bond.projecto.finance.entities.resources.EnterpriseResource;
import bondProject.com.example.Bond.projecto.finance.entities.resources.EnterpriseResourceCreate;
import bondProject.com.example.Bond.projecto.finance.entities.resources.EnterpriseResourceUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class EnterpriseMapper {
    @Autowired
    EnhancedModelMapper mapper;

    //Object Mapping
    public EnterpriseResource toResource(Enterprise model){
        return  mapper.map(model,EnterpriseResource.class);
    }
    public Page<EnterpriseResource> modelListToPage(List<Enterprise> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList,EnterpriseResource.class),pageable, modelList.size());
    }

    public Enterprise toModel(EnterpriseResourceCreate resource){
        return mapper.map(resource,Enterprise.class);
    }

    public Enterprise toModel(EnterpriseResourceUpdate resource){
        return mapper.map(resource,Enterprise.class);
    }

}
