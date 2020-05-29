package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;
import com.util.ValidationUtil;

/**
 * Servlet implementation class UserController
 */
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uName = request.getParameter("txtUserName");
		String uEmail = request.getParameter("txtUserEmail");
		String uPassword = request.getParameter("txtUserPassword");
		int uAge = Integer.parseInt(request.getParameter("txtUserAge"));


		// data -->check -->

		UserBean userBean = new UserBean(); // this user bean
		boolean isError = false;

		if (ValidationUtil.isEmpty(uName)) {
			isError = true;
			request.setAttribute("uname", "user name is req*");

		} else {
			userBean.setuName(uName);
		}
		if (ValidationUtil.isEmail(uEmail)) {
			isError = true;
			request.setAttribute("uemail", "user email is not valid*");

		} else {
			userBean.setuEmail(uEmail);
		}

		if (ValidationUtil.isEmpty(uPassword)) {

			isError = true;
			request.setAttribute("upassword", "user name is req*");

		} else {
			userBean.setuPassword(uPassword);
		}
		if (ValidationUtil.isAge(uAge)) {

			isError = true;
			request.setAttribute("uage", "user age must be  18*");
		} else {

			userBean.setuAge(uAge);
		}

		if (!isError) {



			/*
			 * UserDao userDao = new UserDao();
			 * 
			 * userDao.addUser(userBean);
			 */

			if (new UserDao().addUser(userBean)) {

				System.out.println("data inserted..");
				response.sendRedirect("userRegistrationi.jsp");
			}

			else {

				System.out.println("data not inserted");
			}
		} else {

			request.getRequestDispatcher("userRegistrationi.jsp").forward(request, response);
		}

	}

}
