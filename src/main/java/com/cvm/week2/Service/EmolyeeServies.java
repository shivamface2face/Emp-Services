package com.cvm.week2.Service;


import com.cvm.week2.Entity.Employee;
import com.cvm.week2.Resposotries.EmployeeReposotries;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmolyeeServies {

    private final EmployeeReposotries empRepo;
    private final ModelMapper modelMapper;

    public EmolyeeServies(EmployeeReposotries empRepo, ModelMapper modelMapper) {
        this.empRepo = empRepo;
        this.modelMapper = modelMapper;
    }

    public Employee findById(Long id){
       Employee employee=empRepo.findById(id).orElse(null);
     return employee;
    }

//
//   public Employee saveEmp(Employee newEmployee) {
//        Employee saveEmp=empRepo.save(newEmployee);
//        return saveEmp;
//    }

    public Employee saveEmp(Employee newEmp){
        Employee employee=empRepo.save(newEmp);
        return employee;
    }

    public List<Employee> findAll() {
       List<Employee>employeeList=empRepo.findAll();
     return  employeeList;
    }

    public Employee updateEmployee(Employee employee, Long id) {
        Employee empToUpdate=empRepo.findById(id).orElse(null);
        if (empToUpdate!=null){
            employee.setId(id);
            Employee savedEmp=empRepo.save((employee));
            return savedEmp;
        }else {
            return null;
        }

    }

    public Boolean isExistById(Long id){
       return empRepo.existsById(id);
    }

    public boolean deleteById(Long id) {
        boolean isExist=isExistById(id);
        if(!isExist){return false;}
        empRepo.deleteById(id);
        return true;
    }


}
