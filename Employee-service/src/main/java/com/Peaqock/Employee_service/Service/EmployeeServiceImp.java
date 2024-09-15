package com.Peaqock.Employee_service.Service;

import com.Peaqock.Employee_service.Dto.AddressDto;
import com.Peaqock.Employee_service.Dto.EmployeeDto;
import com.Peaqock.Employee_service.Entity.Employee;
import com.Peaqock.Employee_service.FeignClient.AddressClient;
import com.Peaqock.Employee_service.Mapper.MapperEmployee;
import com.Peaqock.Employee_service.Repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImp implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final AddressClient addressClient;

    @Override
    public String add(EmployeeDto employee) {
        Employee employeeSaved = MapperEmployee.mapperEmployee.employeeDtoToEmployee(employee);
        employeeRepository.save(employeeSaved);
        return "Employee saved successfully";
    }

    @Override
    public List<EmployeeDto> list() {
        List<Employee> employees=employeeRepository.findAll();
        return MapperEmployee.mapperEmployee.employeeToEmployeeDto(employees);
    }

    @Override
    public EmployeeDto update(EmployeeDto employee) {
        Employee employee1 = MapperEmployee.mapperEmployee.employeeDtoToEmployee(employee);
        Employee employeeserched = employeeRepository.findById(employee.getId()).orElseThrow(()-> new RuntimeException("Employee doesn't exist"));
        employeeserched.setAge(employee1.getAge());
        employeeserched.setNom(employee1.getNom());
        employeeserched.setEmail(employee1.getEmail());
        return MapperEmployee.mapperEmployee.employeeToEmployeeDto(employeeRepository.save(employeeserched));
    }

    @Override
    public String delete(Long id) {
        employeeRepository.deleteById(id);
        return "Employee is deleted";
    }

    @Override
    public EmployeeDto employeeById(Long id) {
        return MapperEmployee.mapperEmployee.employeeToEmployeeDto(
                employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee doesn't exist"))
        );
    }

    @Override
    public AddressDto addressEmployee(Long id) {
        return addressClient.addressByIdEmployee(id);
    }
}
