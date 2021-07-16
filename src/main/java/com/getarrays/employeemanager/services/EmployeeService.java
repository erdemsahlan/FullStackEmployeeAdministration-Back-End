package com.getarrays.employeemanager.services;

import com.getarrays.employeemanager.exception.UserNotFoundException;
import com.getarrays.employeemanager.model.Employee;
import com.getarrays.employeemanager.repo.EmployeeRepository;
import lombok.AllArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> findALlEmployees(){
        return employeeRepository.findAll();
    }
    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }
    public Employee findEmployeeById(Long id){

        return employeeRepository.findEmployeeById(id)
                .orElseThrow(()-> new UserNotFoundException("User by id"+id+"was not found"));

    }
}
