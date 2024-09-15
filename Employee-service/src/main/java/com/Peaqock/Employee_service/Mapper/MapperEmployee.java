package com.Peaqock.Employee_service.Mapper;

import com.Peaqock.Employee_service.Dto.EmployeeDto;
import com.Peaqock.Employee_service.Entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MapperEmployee {

    MapperEmployee mapperEmployee = Mappers.getMapper(MapperEmployee.class);
    Employee employeeDtoToEmployee(EmployeeDto employeeDto);
    EmployeeDto employeeToEmployeeDto(Employee employee);
    List<Employee> employeeDtoToEmployee(List<EmployeeDto> employeeDto);
    List<EmployeeDto> employeeToEmployeeDto(List<Employee> employee);

}
