package chap06.prac;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login2")
public class SignInServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("[SignInServlet2] init()");
	}

	public void destroy() {
		System.out.println("[SignInServlet2] destroy()");
	}

	// HttpServletResponse를 통한 응답 실습
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");	// setContentType()으로 응답 데이터 종류 설정
		PrintWriter out = response.getWriter();
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		String data = "<html>";
			data += "<body>";
			data += "아이디: " + user_id;
			data += "<br />";
			data += "비밀번호: " + user_pw;
			data += "<br />";
			data += "</body>";
			data += "</html>";
		out.print(data);
	}
}
