package com.cvm.week2.controller;


import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.cvm.week2.Controller.EmoloyeeController;
import com.cvm.week2.Entity.Employee;
import com.cvm.week2.Service.EmolyeeServies;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class EmoloyeeControllerTest {

    private EmoloyeeController emoloyeeController;
    private EmolyeeServies empServices;

    @BeforeEach
    void setUp() {
        empServices = mock(EmolyeeServies.class);
        emoloyeeController = new EmoloyeeController(empServices);
    }

    @Test
    void getEmployeeById_ReturnsEmployee_WhenEmployeeExists() {
        Employee employee = new Employee();
        when(empServices.findById(1L)).thenReturn(employee);

        ResponseEntity<Employee> response = emoloyeeController.getEmployeeById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(employee, response.getBody());
    }

    @Test
    void getEmployeeById_ReturnsNotFound_WhenEmployeeDoesNotExist() {
        when(empServices.findById(1L)).thenReturn(null);

        ResponseEntity<Employee> response = emoloyeeController.getEmployeeById(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void savedEmp_CreatesAndReturnsEmployee() {
        Employee employee = new Employee();
        when(empServices.saveEmp(employee)).thenReturn(employee);

        Employee result = emoloyeeController.savedEmp(employee);

        assertEquals(employee, result);
    }

    @Test
    void getAllEmp_ReturnsListOfEmployees() {
        List<Employee> employees = Arrays.asList(new Employee(), new Employee());
        when(empServices.findAll()).thenReturn(employees);

        ResponseEntity<List<Employee>> response = emoloyeeController.getAllEmp();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(employees, response.getBody());
    }

    @Test
    void updateEmployee_UpdatesAndReturnsEmployee() {
        Employee employee = new Employee();
        when(empServices.updateEmployee(employee, 1L)).thenReturn(employee);

        ResponseEntity<Employee> response = emoloyeeController.updateEmployee(employee, 1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(employee, response.getBody());
    }

    @Test
    void deleteEmployeeById_DeletesEmployee_WhenEmployeeExists() {
        when(empServices.deleteById(1L)).thenReturn(true);

        ResponseEntity<Boolean> response = emoloyeeController.deleteEmployeeById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody());
    }

    @Test
    void deleteEmployeeById_ReturnsNotFound_WhenEmployeeDoesNotExist() {
        when(empServices.deleteById(1L)).thenReturn(false);

        ResponseEntity<Boolean> response = emoloyeeController.deleteEmployeeById(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void getEmpByName_ReturnsEmployee_WhenEmployeeExists() {
        Employee employee = new Employee();
        when(empServices.getEmpByName("John")).thenReturn(employee);

        Employee result = emoloyeeController.getEmpByName("John");

        assertEquals(employee, result);
    }
}