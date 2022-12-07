package com.example.excel_operations.DTO;


import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelRow;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class EmployeesDTO {

    @ExcelRow
    private int rowIndex;
    @ExcelCell(0)
    private long employeeId;
    @ExcelCell(1)
    private String name;

    @ExcelCell(2)
    private String surname;
    @ExcelCell(3)
    private int age;

    @ExcelCell(4)
    private boolean single;

    @ExcelCellName("EMAILS")
    private List<String> emails;

    @ExcelCell(5)
    private List<BigDecimal> bills;

    public long getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
    public int getAge() {
        return age;
    }
    public boolean isSingle() {
        return single;
    }
    public List<String> getEmails() {
        return emails;
    }
    public List<BigDecimal> getBills() {
        return bills;
    }
}
