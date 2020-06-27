package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login5")
public class SignInServlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("[SignInServlet5] init()");
	}

	public void destroy() {
		System.out.println("[SignInServlet5] destroy()");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String uid = request.getParameter("user_id");
		String upw = request.getParameter("user_pw");
		String address = request.getParameter("user_addrs");
		System.out.println("id: " + uid);
		System.out.println("pw: " + upw);
		System.out.println("adrs" + address);
		
		// 전송된 값을 브라우저에 출력
		String data = "<html>";
		data += "<body>";
		data += "아이디: " + uid + "<br />";
		data += "비밀번호: " + upw + "<br />";
		data += "주소: " + address;
		data += "</body></html>";
		
		out.print(data);
	}

}
