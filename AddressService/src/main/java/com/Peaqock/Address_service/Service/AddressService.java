package com.Peaqock.Address_service.Service;

import com.Peaqock.Address_service.Dto.AddressDto;

import java.util.List;


public interface AddressService {

    public String add(AddressDto addressDto);
    public List<AddressDto> list();
    public AddressDto update(AddressDto addressDto);
    public String delete(Long id);
    AddressDto addressById(Long id);
    AddressDto addressByIdEmployee(Long id);
}
