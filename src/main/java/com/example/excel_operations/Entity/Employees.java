package com.example.excel_operations.Entity;

import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelRow;
import jakarta.persistence.*;


import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employees {

    @ExcelRow
    private int rowIndex;
    @ExcelCell(0)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long employeeId;

    @ExcelCell(1)
    @Column
    private String name;

    @ExcelCell(2)
    @Column
    private String surname;

    @ExcelCell(3)
    @Column
    private int age;

    @ExcelCell(4)
    @Column
    private boolean single;

    @ExcelCellName("EMAILS")
    @Column
    private List<String> emails;

    @ExcelCell(5)
    @Column
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