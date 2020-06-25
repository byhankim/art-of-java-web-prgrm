package chap05.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/what")
public class YetAnotherServlet extends HttpServlet{
	@Override
	public void init() throws ServletException {
		System.out.println("[3rdServlet] init()");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[3rdServlet] doGet()");
	}
	
	@Override
	public void destroy() {
		System.out.println("[3rdServlet] destroy()");
	}
}
