package com.example.excel_operations.Controller;

import com.example.excel_operations.DTO.EmployeesDTO;
import com.example.excel_operations.Entity.Employees;
import com.example.excel_operations.Service.EmployeesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/showAllDB")
    public ResponseEntity<List<Employees>> getAllEmployees(){
        return new ResponseEntity<List<Employees>>(employeesService.getAllEmployees(), HttpStatus.OK);
    }
    @GetMapping("/showAllFromExcel")
    public ResponseEntity<List<EmployeesDTO>> getAllEmployeesFromExcel(){
        return new ResponseEntity<List<EmployeesDTO>>(employeesService.getAllEmployeesFromExcel(), HttpStatus.OK);
    }
    /////////////////////////////// add db from excel ///////////////////////////////////////
    @PostMapping("/addEmployeeFromExcel")
    public ResponseEntity<List<Employees>> addEmployeeFromExcel(){
        return new ResponseEntity<>(employeesService.addEmployeeFromExcel(),HttpStatus.CREATED);
    }

}
