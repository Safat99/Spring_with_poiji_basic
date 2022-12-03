package com.example.excel_operations.Controller;

import com.example.excel_operations.Entity.Employees;
import com.example.excel_operations.Service.EmployeesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RestController
public class EmployeesController {
    private final EmployeesService employeesService;
    public EmployeesController(EmployeesService employeesService){
        this.employeesService = employeesService;
    }

    @GetMapping("/showAll")
    public ResponseEntity<List<Employees>> getAllEmployees(){
        return new ResponseEntity<>(employeesService.getAllEmployees(), HttpStatus.OK);
    }
}
