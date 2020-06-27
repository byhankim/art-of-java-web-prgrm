package sec08.prac;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gugu")
public class GuguServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("[GuguServlet] init()");
	}

	public void destroy() {
		System.out.println("[GuguServlet] destroy()");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int dan = Integer.parseInt(request.getParameter("dan"));
		System.out.println("단 수: " + dan);
		
		// if input exists
		// 	if input in range 1~9
		// 	 draw table
		//	else return
		// else return
		out.print("<html><body>");
		if (dan > 0 && dan < 10) {
			out.print("<table border=1 width=777 align=center>");
			out.print("<tr align=center bgcolor=#FFFF66>");
			out.print("<td colspan=2>" + dan + "단 출력 </td>");
			out.print("</tr>");
			for (int i = 1; i < 10; i++) {
				out.print("<tr align=center>");		// <table> : 표
				out.print("<td width=777/2>");		// <tr>	   : 행
				out.print(dan + " x " + i);			// <td>	   : 셀
				out.print("</td>");
				out.print("<td width=777/2>");
				out.print(i * dan);
				out.print("</td>");
				out.print("</tr>");
			}
			out.print("</table>");
		} else {
			out.print("Enter number between 1~9");
			out.print("<br />");
			out.print("<a href='/ch06/test00/gugu.html'>Return</a>");
		}
		out.print("</body></html>");
	}

}
