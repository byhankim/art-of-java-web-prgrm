package prac.sec02;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member2")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("[MemberServlet(2nd)] init()");
	}

	public void destroy() {
		System.out.println("[MemberServlet(2nd)] destroy()");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		MemberDAO dao = new MemberDAO();	// sql문으로 조회할 MemberDAO 객체 생성
		List<MemberVO> list = dao.listMembers();	// listMembers() 메소드로 회원정보를 조회
		
		out.print("<html><body>");
		out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		out.print("<td>아이디</td><td>비번</td><td>이름</td><td>이메일</td><td>가입일</td></tr>");
		
		for (int i = 0; i < list.size(); ++i) {
			MemberVO memberVO = (MemberVO) list.get(i);
			String id = memberVO.getId();
			String pw = memberVO.getPw();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			Date joinDate = memberVO.getJoinDate();
			out.print("<tr><td>" + id + "</td><td>" + pw + "</td><td>" + name + "</td><td>" + email
					+ "</td><td>" + joinDate + "</td></tr>");
		}
		out.print("</body></html>");
	}

}
