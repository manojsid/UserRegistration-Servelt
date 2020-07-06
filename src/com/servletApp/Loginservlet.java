package com.servletApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginservlet")
public class Loginservlet extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname="mnjsid";
		String username = req.getParameter("Username");
		String pass = req.getParameter("pswd");
		String ffname=req.getParameter("fname");
		//password matching.....
		String pmatch="^([a-zA-Z0-9]*)[^a-zA-Z_0-9\\s]([a-zA-Z0-9]*)$";
		Pattern p = Pattern.compile(pmatch);
		Matcher m = p.matcher(pass);
		boolean is_validPassword = m.matches();
		//firstname matching.....
		String fmatch="^[A-Z]{1}+[A-Za-z]{2,}$";
		Pattern pp = Pattern.compile(fmatch);
		Matcher mm = pp.matcher(ffname);
		boolean is_validFirstname = mm.matches();
		
	
		

		PrintWriter out = resp.getWriter();
		if (username.equals(uname) && is_validPassword==true && is_validFirstname == true ) {
			String htmlresponse = "<html>";
			htmlresponse+="<h1>User is Sucessfully valid: "+username+"</h1>";
			htmlresponse+="<h1>Login Successfull "+"</h1>";
			htmlresponse+="<h1>Valid Firstname"+ffname+"</h1>";
			htmlresponse+="</html>";
			out.println(htmlresponse);
		
			
		}
		else {
			String errorresponse = "<html>";
			errorresponse+="<h1>Given user not found "+username+"</h1>";
			errorresponse+="<h1>Login failed "+"</h1>";
			errorresponse+="<h1>First name is not valid "+ffname+"</h1>";
			errorresponse+="</html>";
			out.println(errorresponse);
			
		}
		//System.out.println("Username is: "+username);
		//System.out.println("Password is: "+pass);
		
		
	}
}
