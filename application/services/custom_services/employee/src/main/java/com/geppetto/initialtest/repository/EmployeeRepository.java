package com.geppetto.initialtest.repository;

import com.geppetto.initialtest.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,String>  {

}
