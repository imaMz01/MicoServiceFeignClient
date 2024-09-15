package com.Peaqock.Employee_service.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressDto {

    private Long id;
    private String city;
    private String state;
    private Long idEmployee;
}