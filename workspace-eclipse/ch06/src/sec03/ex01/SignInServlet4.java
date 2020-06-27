package sec03.ex01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login4")
public class SignInServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("[SignInServlet4] init()");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[SignInServlet4] doGet() 호출");
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[SignInServlet4] doPost() 호출");
		doHandle(request, response);
	}
	
	// 메소드를 따로 분리하여 get과 post 모든 방식에 대해 처리를 진행한다
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");		// no more typo!!
		String user_id = request.getParameter("user_id");
		System.out.println("doHandle() 호출");
		String user_pw = request.getParameter("user_pw");
		System.out.println("id: " + user_id);
		System.out.println("pw: " + user_pw);
	}
	
	@Override
	public void destroy() {
		System.out.println("[SignInServlet4] destroy()");
	}
}
