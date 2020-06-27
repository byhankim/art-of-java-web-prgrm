package sec08.prac;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signin2")
public class SignInTestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("[SignInTestServlet2] init()");
	}

	public void destroy() {
		System.out.println("[SignInTestServlet2] destroy()");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// end, mime type?
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// id, pw, sysout
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		System.out.println("id: " + id);
		System.out.println("pw: " + pw);
		
		// id가 admin일시 관리자페이지 출력 및 회원관리, 회원삭제 기능 보여주기
		// 아닐 경우 null여부에 따라 다른 페이지 출력
		out.print("<html><body>");
		if ((id != null) && id.length() != 0) {
			if ("admin".equals(id)) {
				out.print("<font size=12>HELLO ADMIN!</font><br />");
				out.print("<input type='button' value='회원관리'> <input type='button' value='회원삭제'>");
			} else {
				out.print("hello, user "+id);
			}
		} else {
			out.print("You must enter right id/pw");
			out.print("<br />");
			out.print("<a href='/ch06/test00/signin2.html'>돌아가기</a>");
		}
		out.print("</body></html>");
	}

}
