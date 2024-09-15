package com.Peaqock.Address_service.Service;

import com.Peaqock.Address_service.Dto.AddressDto;
import com.Peaqock.Address_service.Entity.Address;
import com.Peaqock.Address_service.Mapper.AddressMapper;
import com.Peaqock.Address_service.Repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImp implements  AddressService{

    private final AddressRepository addressRepository;

    @Override
    public String add(AddressDto addressDto) {
        Address address = AddressMapper.addressMapper.addressDtoToAddress(addressDto);
        System.out.println(address.toString());
        addressRepository.save(address);
        return "Address saved successfully";
    }

    @Override
    public List<AddressDto> list() {
        return AddressMapper.addressMapper.addressToAddressDto(addressRepository.findAll());
    }

    @Override
    public AddressDto update(AddressDto addressDto) {
        Address address = AddressMapper.addressMapper.addressDtoToAddress(addressDto);
        Address addressserched = addressRepository.findById(address.getId()).orElseThrow(()-> new RuntimeException("Address doesn't exist"));
        addressserched.setCity(address.getCity());
        addressserched.setState(address.getState());
        return AddressMapper.addressMapper.addressToAddressDto((addressRepository.save(addressserched)));

    }

    @Override
    public String delete(Long id) {
        addressRepository.deleteById(id);
        return "Address is deleted successfully";
    }

    @Override
    public AddressDto addressById(Long id) {
        return AddressMapper.addressMapper.addressToAddressDto(
                addressRepository.findById(id).orElseThrow(()->new RuntimeException("Address doesn't exist"))
        );
    }

    @Override
    public AddressDto addressByIdEmployee(Long id) {
        return AddressMapper.addressMapper.addressToAddressDto(addressRepository.findByIdEmployee(id));

    }
}
