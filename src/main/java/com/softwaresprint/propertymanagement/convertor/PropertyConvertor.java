package com.softwaresprint.propertymanagement.convertor;


import com.softwaresprint.propertymanagement.dto.PropertyDTO;
import com.softwaresprint.propertymanagement.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConvertor {
    public PropertyEntity convertDTOtoEntity(PropertyDTO propertyDTO){
        PropertyEntity pe = new PropertyEntity();
        pe.setAddress(propertyDTO.getAddress());
        pe.setDescription(propertyDTO.getDescription());
        pe.setPrice(propertyDTO.getPrice());
        pe.setTitle(propertyDTO.getProperty_title());
        pe.setOwner(propertyDTO.getOwner());
        pe.setEmail(propertyDTO.getEmail());

        return pe;
    }

    public PropertyDTO convertEntityToDTO(PropertyEntity propertyEntity){
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setId(propertyEntity.getId());
        propertyDTO.setProperty_title(propertyEntity.getTitle());
        propertyDTO.setOwner(propertyEntity.getOwner());
        propertyDTO.setEmail(propertyEntity.getEmail());
        propertyDTO.setAddress(propertyEntity.getAddress());
        propertyDTO.setDescription(propertyEntity.getDescription());
        propertyDTO.setPrice(propertyEntity.getPrice());

        return propertyDTO;
    }
}
