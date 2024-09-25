package com.geppetto.initialtest.dao.daoimpl;

import com.geppetto.initialtest.model.Employee;
import com.geppetto.initialtest.repository.EmployeeRepository;
import com.geppetto.initialtest.dao.EmployeeDao;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDaoImpl implements EmployeeDao{

    private final EmployeeRepository employeeRepository;

     public EmployeeDaoImpl(EmployeeRepository employeeRepository) {
       this.employeeRepository = employeeRepository;
}

    @Override
    public Employee create(Employee employee) {
      return employeeRepository.save(employee);
    }


    @Override
    public Optional<Employee> getEntityById(String id) {
      return employeeRepository.findById(id);
    }


    @Override
    public List<Employee> getAllValues() {
      return employeeRepository.findAll();
    }


    @Override
    public Optional<Employee> update(String id) {
      return employeeRepository.findById(id);
    }


    @Override
    public void delete(String id) {
      employeeRepository.deleteById(id);
    }

}
