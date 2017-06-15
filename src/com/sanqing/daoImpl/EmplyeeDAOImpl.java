package com.sanqing.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.sanqing.bean.Employee;
import com.sanqing.dao.EmployeeDAO;
import com.sanqing.util.DBConnection;

public class EmplyeeDAOImpl implements EmployeeDAO{

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(int emplyeeID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employee> findAllEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee findEmployeeByID(int emplyeeID) {
		Connection connection=DBConnection.getConnection();
		String findByIDSql="select * from"+
		"tb_employee where employeeID=?";
		PreparedStatement psmt=null;
		ResultSet rs=null;
		Employee employee=null;
		try {
			psmt=connection.prepareStatement(findByIDSql);
			psmt.setInt(1, emplyeeID);
			rs=psmt.executeQuery();
			if (rs.next()) {
				employee=new Employee();
				employee.setEmployeeID(rs.getInt(1));
				employee.setEmployeeName(rs.getString(2));
				employee.setEmployeeSex(rs.getBoolean(3));
				employee.setEmployeeBirth(rs.getDate(4));
				employee.setEmployeePhone(rs.getString(5));
				employee.setEmployeePlace(rs.getString(6));
				employee.setJoinTime(rs.getDate(7));
				employee.setIsLead(rs.getBoolean(9));
				employee.setPassword(rs.getString(8));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.close(connection);
			DBConnection.close(psmt);
			DBConnection.close(rs);
		}
		return employee;
	}

}
