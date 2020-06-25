package chap05.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnotherServlet extends HttpServlet{
	@Override
	public void init() throws ServletException {
		System.out.println("[AnotherServlet] init()");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[AnotherServlet] doGet()");
	}
	
	@Override
	public void destroy() {
		System.out.println("[AnotherServlet] destroy()");
	}
}
