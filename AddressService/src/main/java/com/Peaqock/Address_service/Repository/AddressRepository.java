package com.Peaqock.Address_service.Repository;

import com.Peaqock.Address_service.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

    Address findByIdEmployee(long idEmployee);
}
