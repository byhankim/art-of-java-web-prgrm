package chap05.ex01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FourthServlet
 */
@WebServlet("/4")
public class FourthServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("[4thServlet] init()");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[4thServlet] doGet()");
	}
	
	@Override
	public void destroy() {
		System.out.println("[4thServlet] destroy()");
	}
}
