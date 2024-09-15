package com.Peaqock.Employee_service.Controller;

import com.Peaqock.Employee_service.Dto.AddressDto;
import com.Peaqock.Employee_service.Dto.EmployeeDto;
import com.Peaqock.Employee_service.Service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/list")
    public List<EmployeeDto> all(){

        return employeeService.list();
    }

    @GetMapping("/findById/{id}")
    public EmployeeDto findById(@PathVariable Long id){
        return employeeService.employeeById(id);
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@RequestBody EmployeeDto employeeDto){
        System.out.println(employeeDto.toString());
        return  employeeService.add(employeeDto);
    }

    @PutMapping("/update")
    public EmployeeDto update(@RequestBody EmployeeDto employeeDto){
        return employeeService.update(employeeDto);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return employeeService.delete(id);
    }

    @GetMapping("/addressByIdEmployee/{id}")
    public AddressDto addressEmployee(@PathVariable Long id){
        return employeeService.addressEmployee(id);
    }
}
