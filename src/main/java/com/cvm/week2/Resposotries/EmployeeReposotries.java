package com.cvm.week2.Resposotries;

import com.cvm.week2.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeReposotries extends JpaRepository<Employee,Long> {

   Employee findByName(String name);

}
