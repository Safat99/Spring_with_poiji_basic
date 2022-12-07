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
    private List<BigInteger> bills;

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSingle() {
        return single;
    }

    public void setSingle(boolean single) {
        this.single = single;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public List<BigInteger> getBills() {
        return bills;
    }

    public void setBills(List<BigInteger> bills) {
        this.bills = bills;
    }

}