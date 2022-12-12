package com.example.excel_operations.Repository;

import com.example.excel_operations.Entity.Employees;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Long> {
    Page<Employees> findBySingle(boolean single, Pageable pageable);
    Page<Employees> findByAgeGreaterThan(int age, Pageable pageable);
}
