package com.example.excel_operations.Service;

import com.example.excel_operations.DTO.EmployeesDTO;
import com.example.excel_operations.Entity.Employees;
import com.example.excel_operations.Repository.EmployeesRepository;
import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import org.springframework.stereotype.Service;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeesService {
    private final EmployeesRepository employeesRepository;
    public EmployeesService(EmployeesRepository employeesRepository){
        this.employeesRepository = employeesRepository;
    }
    PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings()
            .addListDelimiter(";")
            .build();

    //////////////////////////// read operation ///////////////////////////
    public List<Employees> getAllEmployees(){
        List<Employees> employees = new ArrayList<>();
        employeesRepository.findAll().forEach(employees::add);
        return employees;
    }

    public List<EmployeesDTO> getAllEmployeesFromExcel(){
        List<EmployeesDTO> employees = Poiji.fromExcel(new File("employees.xls"), EmployeesDTO.class, options);
//        int length = employees.size();
        return new ArrayList<EmployeesDTO>(employees);
    }
    /////////////////////////////// add or insert operation ////////////////////////////////
    public List<Employees> addEmployeeFromExcel(){
        List<EmployeesDTO> allEmployeesDTO = Poiji.fromExcel(new File("employees.xls"), EmployeesDTO.class, options);
        List<Employees> allEmployees = new ArrayList<>();
//        employees = employeesDTO;
        List<BigDecimal> bills = new ArrayList<>();
        List<String> emails = new ArrayList<>();

        for (int i=0; i<allEmployeesDTO.size();i++){
            bills.clear();
            emails.clear();
            EmployeesDTO _employeeDto = allEmployeesDTO.get(i);
            List<BigDecimal> _bills = _employeeDto.getBills();
            List<String> _emails = _employeeDto.getEmails();
//            System.out.println(bill);
            bills.addAll(_bills);
            emails.addAll(_emails);

            Employees _employee = new Employees();
            _employee.setEmployeeId(_employeeDto.getEmployeeId());
            _employee.setName(_employeeDto.getName());
            _employee.setSurname(_employeeDto.getSurname());
            _employee.setAge(_employeeDto.getAge());
            _employee.setSingle(_employeeDto.isSingle());
            _employee.setBills(bills);
            _employee.setEmails(emails);
//            System.out.println(employeeDto.getBills());
            employeesRepository.save(_employee);
            allEmployees.add(_employee);
        }
        return allEmployees;
    }
}
