package com.cvm.week2.Controller;

import com.cvm.week2.Entity.Employee;
import com.cvm.week2.Resposotries.EmployeeReposotries;
import com.cvm.week2.Service.EmolyeeServies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/emp")
public class EmoloyeeController {


    private final EmolyeeServies empServices;

    public EmoloyeeController(EmolyeeServies empServices) {
        this.empServices = empServices;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
      Employee employee= empServices.findById(id);
      return ResponseEntity.ok(employee);
    }

//    @PostMapping()
//    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee newEmployee) {
//        Employee employee=empServices.saveEmp(newEmployee);
//        return new ResponseEntity<>(employee, HttpStatus.CREATED);
//    }


    @PostMapping
    public Employee savedEmp(@RequestBody Employee newEmp){
        Employee employee=empServices.saveEmp(newEmp);
        return employee;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmp() {
        return ResponseEntity.ok(empServices.findAll());
   }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
        return ResponseEntity.ok(empServices.updateEmployee(employee, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long id) {
      //  return empServices.deleteById(id)
        boolean isDeleted=empServices.deleteById(id);
        if (isDeleted)return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }

    

}
