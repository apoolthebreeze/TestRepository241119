package jspMVCMisoShopping.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspMVCMisoShopping.service.user.IDCheckService;
import jspMVCMisoShopping.service.user.UserWriteService;

public class UserFrontController extends HttpServlet {
	protected void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/userAgree.nhn")) {
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("user/userAgree.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/userWrite.nhn")) {
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("user/userForm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/userRegist.nhn")) {
			UserWriteService action = new UserWriteService();
			action.execute(request);
			response.sendRedirect(request.getContextPath());//메인페이지로 이동
		}else if(command.equals("/idCheck.nhn")) {
			IDCheckService action = new IDCheckService();
			action.execute(request);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("user/idCheck.jsp");
			dispatcher.forward(request, response);
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
}
