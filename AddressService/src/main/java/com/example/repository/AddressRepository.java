package com.example.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>  {
	
	Logger logger=LoggerFactory.getLogger(AddressRepository.class);
	
	//address based on a employee id
	
	@Query(nativeQuery=true, value="SELECT ea.id, ea.colony, ea.location FROM microproject.address ea join microproject.employee e on e.id=ea.id;")
	Address findAddressByEmployeeId(@Param("employee_id") int id);
	
	default Address findAddressByEmployeeIdWithLogging(int id) {
        logger.info("Searching address for employee id: {}", id);
        Address address = findAddressByEmployeeId(id);
        if (address == null) {
            logger.warn("No address found for employee id: {}", id);
        }
        return address;
    }
	

}
