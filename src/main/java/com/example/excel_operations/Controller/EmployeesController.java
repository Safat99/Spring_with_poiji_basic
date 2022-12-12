package com.example.excel_operations.Controller;

import com.example.excel_operations.DTO.EmployeesDTO;
import com.example.excel_operations.Entity.Employees;
import com.example.excel_operations.Repository.EmployeesRepository;
import com.example.excel_operations.Service.EmployeesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api")
@RestController
public class EmployeesController {
    private final EmployeesService employeesService;
    private final EmployeesRepository employeesRepository;
    public EmployeesController(EmployeesService employeesService, EmployeesRepository employeesRepository){
        this.employeesService = employeesService;
        this.employeesRepository = employeesRepository;
    }


    ///////////////////////////////////////////   READ/GET Operation ///////////////////////////////////
    @GetMapping("/showAllDB")
    public ResponseEntity<List<Employees>> getAllEmployees(){
        return new ResponseEntity<List<Employees>>(employeesService.getAllEmployees(), HttpStatus.OK);
    }
    @GetMapping("/showAllFromExcel")
    public ResponseEntity<List<EmployeesDTO>> getAllEmployeesFromExcel(){
        return new ResponseEntity<List<EmployeesDTO>>(employeesService.getAllEmployeesFromExcel(), HttpStatus.OK);
    }

    @GetMapping("/showAllEmployees/single")
    public ResponseEntity<Map<String, Object>> findBySingle(
                @RequestParam(required = true) boolean single,
                @RequestParam(defaultValue = "0") int page,
                @RequestParam(defaultValue = "1") int size
    ){
        List<Employees> employees = new ArrayList<>();
        Pageable pageable = PageRequest.of(page, size);

        Page<Employees>  pageEmployees;
        pageEmployees = employeesRepository.findBySingle(single, pageable);
        employees = pageEmployees.getContent();

        // to return the values
        Map<String, Object> response = new HashMap<>();
        response.put("employees", employees);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /////////////////////////////// add db from excel ///////////////////////////////////////
    @PostMapping("/addEmployeeFromExcel")
    public ResponseEntity<List<Employees>> addEmployeeFromExcel(){
        return new ResponseEntity<>(employeesService.addEmployeeFromExcel(),HttpStatus.CREATED);
    }

}
