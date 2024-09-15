package com.Peaqock.Employee_service.Dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDto {
    private Long id;
    private String nom;
    private String email;
    private Integer age;
}
