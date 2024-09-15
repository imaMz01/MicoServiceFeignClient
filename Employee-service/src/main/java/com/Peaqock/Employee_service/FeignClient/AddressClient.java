package com.Peaqock.Employee_service.FeignClient;

import com.Peaqock.Employee_service.Dto.AddressDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Address-service", url = "http://localhost:8081/api/Address")
public interface AddressClient {

    @GetMapping("/addressByIdEmployee/{id}")
    public AddressDto addressByIdEmployee(@PathVariable Long id);
}
