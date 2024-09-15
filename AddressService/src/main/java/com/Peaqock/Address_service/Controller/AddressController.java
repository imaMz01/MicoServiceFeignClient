package com.Peaqock.Address_service.Controller;


import com.Peaqock.Address_service.Dto.AddressDto;
import com.Peaqock.Address_service.Service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("Address")
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/list")
    public List<AddressDto> all(){
        return addressService.list();
    }

    @GetMapping("/findById/{id}")
    public AddressDto findById(@PathVariable Long id){
        return addressService.addressById(id);
    }

    @PostMapping("/addAddress")
    public String addAddress(@RequestBody AddressDto addressDto){
        System.out.println(addressDto.toString());
        return  addressService.add(addressDto);
    }

    @PutMapping("/update")
    public AddressDto update(@RequestBody AddressDto addressDto){
        return addressService.update(addressDto);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return addressService.delete(id);
    }

    @GetMapping("/addressByIdEmployee/{id}")
    public AddressDto addressByIdEmployee(@PathVariable Long id){
        return addressService.addressByIdEmployee(id);
    }

}
