package com.sanqing.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sanqing.bean.Employee;
import com.sanqing.dao.EmployeeDAO;
import com.sanqing.factory.EmployeeDAOFactory;

/**
 * Servlet implementation class StatusRecognise
 */
@WebServlet("/StatusRecogniseAction")
public class StatusRecognise extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatusRecognise() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context=getServletContext();
		RequestDispatcher dispatcher=null;
		String employeeID=request.getParameter("employeeID");
		String password=request.getParameter("password");
		if (employeeID==null||"".equals(employeeID)) {
			request.setAttribute("error", "请输入员工编号");
			dispatcher=context.getRequestDispatcher("/statusRecognis.jsp");//设置跳转页面
		}else {
			if (password==null||"".equals(password)) {
				request.setAttribute("error", "请输入系统口令");
				dispatcher=context.getRequestDispatcher("/statusRecognis.jsp");
			}else {
				EmployeeDAO employeeDAO=EmployeeDAOFactory.getEmployeeDAOInstance();
				Employee employee=employeeDAO.findEmployeeByID(Integer.parseInt(employeeID));
				if (employee==null) {
					request.setAttribute("error", "该员工编号不存在");
					dispatcher=context.getRequestDispatcher("/statusRecognis.jsp");
				}else {
					if (password.equals(employee.getPassword())) {
						request.getSession().setAttribute("employee", employee);
						response.sendRedirect("index.jsp");
						return;
					}else {
						request.setAttribute("error", "系统口令不正确");
						dispatcher=context.getRequestDispatcher("/statusRecognis.jsp");
					}
				}
			}
		}
		dispatcher.forward(request, response);//进行跳转
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
