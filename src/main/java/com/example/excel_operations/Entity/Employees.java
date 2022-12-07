package com.example.excel_operations.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employees {

    @JsonIgnore
    @Transient
    private int rowIndex;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long employeeId;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private int age;

    @Column
    private boolean single;

//    @Column(columnDefinition = "VARCHAR(255)") // array rakhar jonne datatype e columnDefinition use korte hobe

    @ElementCollection
    @CollectionTable(name = "emails" , joinColumns = @JoinColumn(name="employee_id"))
    private List<String> emails = new ArrayList<>();


    @ElementCollection
    @CollectionTable(name="bills", joinColumns = @JoinColumn(name = "employee_id"))
    private List<BigInteger> bills;

    public Employees() {
    }

    public Employees(long employeeId, String name, String surname, int age, boolean single, List<String> emails, List<BigInteger> bills) {
        this.employeeId = employeeId;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.single = single;
        this.emails = emails;
        this.bills = bills;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSingle(boolean single) {
        this.single = single;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public void setBills(List<BigInteger> bills) {
        this.bills = bills;
    }

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

    public List<BigInteger> getBills() {
        return bills;
    } // maybe poiji ignores comma inside excel

}