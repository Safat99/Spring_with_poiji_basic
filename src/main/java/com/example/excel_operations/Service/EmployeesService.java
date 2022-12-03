package com.example.excel_operations.Service;

import com.example.excel_operations.Entity.Employees;
import com.example.excel_operations.Repository.EmployeesRepository;
import com.poiji.bind.Poiji;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeesService {
    private final EmployeesRepository employeesRepository;
    public EmployeesService(EmployeesRepository employeesRepository){
        this.employeesRepository = employeesRepository;
    }

    //////////////////////////// read operation ///////////////////////////
    public List<Employees> getAllEmployees(){
        List<Employees> employees = new ArrayList<>();
        employeesRepository.findAll().forEach(employees::add);
        return employees;
    }

    public List<Employees> getAllEmployeesFromExcel(){
        List<Employees> employees = Poiji.fromExcel(new File("employees.xls"), Employees.class);
//        int length = employees.size();
        return new ArrayList<Employees>(employees);
    }
}
