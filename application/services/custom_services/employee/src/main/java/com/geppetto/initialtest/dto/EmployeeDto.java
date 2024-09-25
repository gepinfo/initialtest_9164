package com.geppetto.initialtest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;






@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private String _id;
    
    private Number emp_reference;
    
    private String name;
    
    private Number age;
    
    }
