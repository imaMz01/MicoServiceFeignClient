package com.Peaqock.Employee_service.Service;

import com.Peaqock.Employee_service.Dto.AddressDto;
import com.Peaqock.Employee_service.Dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    public String add(EmployeeDto employee);
    public List<EmployeeDto> list();
    public EmployeeDto update(EmployeeDto employee);
    public String delete(Long id);
    EmployeeDto employeeById(Long id);
    AddressDto addressEmployee(Long id);
}
