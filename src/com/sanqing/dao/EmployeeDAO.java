package com.sanqing.dao;

import java.util.List;

import com.sanqing.bean.Employee;

public interface EmployeeDAO {
	public void addEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public void deleteEmployee(int emplyeeID);
	public List<Employee> findAllEmployee();
	public Employee findEmployeeByID(int emplyeeID);
}
