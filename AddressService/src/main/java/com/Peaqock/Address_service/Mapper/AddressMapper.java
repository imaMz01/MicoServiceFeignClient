package com.Peaqock.Address_service.Mapper;

import com.Peaqock.Address_service.Dto.AddressDto;
import com.Peaqock.Address_service.Entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AddressMapper {

    AddressMapper addressMapper = Mappers.getMapper(AddressMapper.class);
    AddressDto addressToAddressDto(Address address);
    Address addressDtoToAddress(AddressDto address);
    List<AddressDto> addressToAddressDto(List<Address> address);
    List<Address> addressDtoToAddress(List<AddressDto> address);
}
