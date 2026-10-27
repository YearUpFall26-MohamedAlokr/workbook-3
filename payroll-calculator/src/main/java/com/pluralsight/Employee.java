package com.pluralsight;

public class Employee {
    private int employeeId;
    private String name;
    private double hoursWorked;
    private double payRat;


    private double grossPay;

    public Employee(int employeeId, String name, double hoursWorked, double payRat) {
        this.employeeId = employeeId;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRat = payRat;
        this.grossPay=payRat*hoursWorked;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    public double getHoursWorked() {
        return hoursWorked;
    }
    public void setPayRat(double payRat) {
        this.payRat = payRat;
    }
    public double getPayRat() {
        return payRat;
    }
    public double getGrossPay() {
        return grossPay;
    }
}
