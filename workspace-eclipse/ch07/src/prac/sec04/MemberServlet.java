package prac.sec04;

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

@WebServlet("/member4")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("[MemberServlet(4th)] init()");
	}

	public void destroy() {
		System.out.println("[MemberServlet(4th)] destroy()");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		MemberDAO dao = new MemberDAO();	// sql문으로 조회할 MemberDAO 객체 생성
		PrintWriter out = response.getWriter();
		String cmd = request.getParameter("command");
		if (cmd != null && cmd.equals("addMember")) {
			String _id = request.getParameter("id");
			String _pw = request.getParameter("pw");
			String _name = request.getParameter("name");
			String _email = request.getParameter("email");
			
			MemberVO vo = new MemberVO();
			vo.setId(_id);
			vo.setPw(_pw);
			vo.setName(_name);
			vo.setEmail(_email);
			
			dao.addMember(vo);
		} else if (cmd != null && cmd.equals("delMember")) {
			String id = request.getParameter("id");
			dao.delMember(id);	// id를 가져와 SQL문으로 전달하여 삭제
		}
		List list = dao.listMembers();
		out.print("<html><body>");
		out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		out.print("<td>아이디</td><td>비번</td><td>이름</td><td>이메일</td><td>가입일</td><td>삭제</td>");
		
		for (int i = 0; i < list.size(); ++i) {
			MemberVO memberVO = (MemberVO) list.get(i);
			String id = memberVO.getId();
			String pw = memberVO.getPw();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			Date joinDate = memberVO.getJoinDate();
			out.print("<tr><td>" + id + "</td><td>"
						+ pw + "</td><td>"
						+ name + "</td><td>"
						+ email + "</td><td>"
						+ joinDate + "</td><td>"
						+ "<a href='/ch07/member4?command=delMember&id=" + id + "'>삭제</a></td></tr>");
		}
		out.print("</table></body></html>");
		out.print("<a href='/ch07/memberForm.html'>새 회원 등록하기</a>");
	}

}
