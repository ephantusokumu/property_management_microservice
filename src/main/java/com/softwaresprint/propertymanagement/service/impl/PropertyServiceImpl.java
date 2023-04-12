package com.softwaresprint.propertymanagement.service.impl;

import com.softwaresprint.propertymanagement.convertor.PropertyConvertor;
import com.softwaresprint.propertymanagement.dto.PropertyDTO;
import com.softwaresprint.propertymanagement.entity.PropertyEntity;
import com.softwaresprint.propertymanagement.repository.PropertyRepository;
import com.softwaresprint.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConvertor propertyConvertor;
    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        PropertyEntity pe = propertyConvertor.convertDTOtoEntity(propertyDTO);
        pe = propertyRepository.save(pe);

        propertyDTO   = propertyConvertor.convertEntityToDTO(pe);
        return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> listOfProps = (List<PropertyEntity>) propertyRepository.findAll();
        List<PropertyDTO> propList = new ArrayList<>();
        for (PropertyEntity pe : listOfProps){
            PropertyDTO dto = propertyConvertor.convertEntityToDTO(pe);
            propList.add(dto);
        }
        return propList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if(optEn.isPresent()){
            PropertyEntity pe = optEn.get();
            pe.setAddress(propertyDTO.getAddress());
            pe.setDescription(propertyDTO.getDescription());
            pe.setPrice(propertyDTO.getPrice());
            pe.setTitle(propertyDTO.getProperty_title());
            pe.setOwner(propertyDTO.getOwner());
            pe.setEmail(propertyDTO.getEmail());

            dto = propertyConvertor.convertEntityToDTO(pe);

            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);

    }
}
