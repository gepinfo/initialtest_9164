package com.geppetto.initialtest.service.serviceimpl;

import com.geppetto.initialtest.dao.EmployeeDao;
import com.geppetto.initialtest.model.Employee;
import com.geppetto.initialtest.dto.EmployeeDto;
import com.geppetto.initialtest.service.EmployeeService;
import com.geppetto.initialtest.exception.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

      private final EmployeeDao employeeDao;

      private final MongoTemplate mongoTemplate;
      public EmployeeServiceImpl(EmployeeDao  employeeDao,MongoTemplate mongoTemplate) {
          this. employeeDao =  employeeDao;
          this.mongoTemplate=mongoTemplate;
}

    @Override
    public EmployeeDto create(EmployeeDto employeeDto){
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        Employee createdEmployee= employeeDao.create(employee);
        BeanUtils.copyProperties(createdEmployee, employeeDto);
        return employeeDto;
    }


    @Override
    public EmployeeDto getEntityById(String id) {
    EmployeeDto employeeDto = new EmployeeDto();
    Optional<Employee> result = employeeDao.getEntityById(id);
        if (result.isPresent()) {
            BeanUtils.copyProperties(result.get(), employeeDto);
        } else {
            throw new EntityNotFoundException("Data not found for ID: " + id);
        }
        return employeeDto;
    }


    @Override
    public List<EmployeeDto> getAllValues() {
        List<Employee> employeeEntities = employeeDao.getAllValues();
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        for (Employee employeeEntity : employeeEntities) {
            EmployeeDto employeeDto = new EmployeeDto();
            BeanUtils.copyProperties(employeeEntity, employeeDto);
            employeeDtoList.add(employeeDto);
        }
        return employeeDtoList;
    }



    @Override
    public EmployeeDto update(EmployeeDto employeeDto) {
    Optional<Employee> result = employeeDao.update(employeeDto.get_id());
        if (result.isPresent()) {
           Employee employee = result.get();
           BeanUtils.copyProperties(employeeDto, employee);
           employeeDao.create(employee);
           return employeeDto;
        } else {
        throw new EntityNotFoundException("Data not found for update with ID: " + employeeDto.get_id());
        }
    }


    @Override
    public String delete(String id) {
    Optional<Employee> result = employeeDao.getEntityById(id);
        if (result.isPresent()) {
            employeeDao.delete(id);
        }else{
        throw new EntityNotFoundException("No entry found with ID: " + id + ". Unable to delete.");
        }
        return "Data Deleted Successfully";
    }


    @Override
    public List<EmployeeDto> search(Map<String, String> allParams) {
        Query query = new BasicQuery(constructQuery(allParams));
        List<Employee> employeeEntities= mongoTemplate.find(query, Employee.class);
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        for (Employee employeeEntity : employeeEntities) {
             EmployeeDto employeeDto = new EmployeeDto();
             BeanUtils.copyProperties(employeeEntity, employeeDto);
             employeeDtoList.add(employeeDto);
            }
        return employeeDtoList;
    }


    private String constructQuery(Map<String, String> params) {
       StringBuilder queryBuilder = new StringBuilder("{ ");
         for (Map.Entry<String, String> entry : params.entrySet()) {
         queryBuilder.append(entry.getKey()).append(": '").append(entry.getValue()).append("', ");
    }
        queryBuilder.delete(queryBuilder.length() - 2, queryBuilder.length()).append(" }");
        return queryBuilder.toString();
    }
}