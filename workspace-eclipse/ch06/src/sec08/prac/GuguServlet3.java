package sec08.prac;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gugu3")
public class GuguServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("[GuguServlet3] init()");
	}

	public void destroy() {
		System.out.println("[GuguServlet3] destroy()");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int dan = -1;
		try {
			dan = Integer.parseInt(request.getParameter("dan"));
			
		} catch (NumberFormatException e) {
			System.out.println("[NumberFormatException] Integer.parseInt() cannot transform input value into integer");
			System.out.println("Exception message: " + e);
			out.print("<html><body>");
			out.print("YOU MUST ENTER A NUMBER!!");
			out.print("<br />");
			out.print("<a href='/ch06/test00/gugu3.html'>Return</a>");
			out.print("</body></html>");
			return;
		}
		System.out.println("단 수: " + dan);
		out.print("<html><body>");
		
		if (dan > 0 && dan < 10) {
			out.print("<table border=1 align=center>");
			out.print("<tr align=center bgcolor=#FFFF66>");
			out.print("<td colspan=4>" + dan + "단 출력 </td>");
			out.print("</tr>");
			for (int i = 1; i < 10; i++) {
				if (i % 2 == 0) {
					out.print("<tr align=center bgcolor='#ACFA58'>");
				} else {
					out.print("<tr align=center bgcolor='#81BEF7'>");
				}
				// radiobox & checkbox for every row
				out.print("<td width=100>");
				out.print("<input type='radio' />" + i);
				out.print("</td>");
				out.print("<td width=100>");
				out.print("<input type='checkbox' />" + i);
				out.print("</td>");
				
				out.print("<td width=300>");
				out.print(dan + " x " + i);
				out.print("</td>");
				out.print("<td width=300>");
				out.print(i * dan);
				out.print("</td>");
				out.print("</tr>");
			}
			out.print("</table>");
		} else {
			out.print("Enter number between 1~9");
			out.print("<br />");
			out.print("<a href='/ch06/test00/gugu3.html'>Return</a>");
		}
		out.print("</body></html>");
	}

}
