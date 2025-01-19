package com.cvm.week2.Service;

import com.cvm.week2.Entity.Employee;
import com.cvm.week2.Resposotries.EmployeeReposotries;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class EmolyeeServiesTest {

    @Autowired
    private EmployeeReposotries employeeReposotries;

    @Test
    public void testAdd(){
        assertEquals(4,2+2);
    }


//    @Test
//    public void testGetEmpByName(){
//        assertNotNull(employeeReposotries.findByName("rupali"));
//    }


    @ParameterizedTest
    @CsvSource({
            "rupali",
            "cvm",

    })
    public void testGetEmpByName(String name){
        assertNotNull(employeeReposotries.findByName(name),"failed for :"+name);
    }

    @Test
    public void testEmpEmail(){
        Employee employee=employeeReposotries.findByName("rupali");
         assertTrue(!employee.getEmail().isEmpty());

    }
}
