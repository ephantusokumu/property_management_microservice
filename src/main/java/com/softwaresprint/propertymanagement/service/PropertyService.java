package com.softwaresprint.propertymanagement.service;

import com.softwaresprint.propertymanagement.dto.PropertyDTO;

import java.util.List;

public interface PropertyService {
     PropertyDTO saveProperty(PropertyDTO propertyDTO);
     List<PropertyDTO> getAllProperties();

     PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId);
     void deleteProperty(Long propertyId);
}
