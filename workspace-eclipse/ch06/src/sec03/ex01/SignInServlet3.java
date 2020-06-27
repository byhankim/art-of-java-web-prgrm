package sec03.ex01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login3")
public class SignInServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("[SignInServlet3] init()");
	}

	public void destroy() {
		System.out.println("[SignInServlet3] destroy()");
	}
	
	// Post 방식 데이터 전송
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		System.out.println("user id: " + user_id);
		System.out.println("user pw: " + user_pw);
	}

}
