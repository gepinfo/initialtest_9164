package com.geppetto.initialtest.service;

import com.geppetto.initialtest.dto.EmployeeDto;
import java.util.List;
import java.util.Map;

public interface EmployeeService {

    EmployeeDto create(EmployeeDto employeeDto);


    EmployeeDto getEntityById(String id);


    List<EmployeeDto> getAllValues();


    EmployeeDto update(EmployeeDto employeeDto);


    String delete(String id);


    List<EmployeeDto> search(Map<String, String> allParams);


}
