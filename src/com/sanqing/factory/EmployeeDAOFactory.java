package com.sanqing.factory;

import com.sanqing.dao.EmployeeDAO;
import com.sanqing.daoImpl.EmplyeeDAOImpl;

public class EmployeeDAOFactory {
	public static EmployeeDAO	 getEmployeeDAOInstance() {
		return new EmplyeeDAOImpl();
	}
}
