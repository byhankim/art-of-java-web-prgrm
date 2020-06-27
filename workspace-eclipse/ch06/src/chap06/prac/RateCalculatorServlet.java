package chap06.prac;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class RateCalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("[RateCalculatorServlet] init()");
	}

	public void destroy() {
		System.out.println("[RateCalculatorServlet] destroy()");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		String command = request.getParameter("command");	// 수행할 요청을 받아온다
		String won  =request.getParameter("won");			// 변환할 원화를 받아온다
		String operator = request.getParameter("operator");	// 변환할 외화 종류를 받아온다
		
		// 최초요청시 cmd가 null이면 계산기 화면을 출력하고 calc면 결과를 출력
		if (command != null && command.equals("calculate")) {
			String result = calculate(Float.parseFloat(won), operator);
			pw.print("<html><font size=10>변환 결과:</font><br />");
			pw.print("<html><font size=10>" + result + "</font><br />");
			pw.print("<a href='/ch06/calc'>환율 계산기</a>");
			return ;
		}
		
		pw.print("<html><title>환율 계산기</title>");
		pw.print("<font size=5>환율 계산기</font><br />");
		pw.print("<form name='formCalc' method='get' action='/ch06/calc' />");	//원화 입력후 calc로 요청
		pw.print("원화: <input type='text' name='won' size=10 />");
		pw.print("<select name='operator'>");
		pw.print("<option value='dollar'>달러</option>");
		pw.print("<option value='yuan'>위안</option>");
		pw.print("<option value='pound'>파운드</option");
		pw.print("<option value='euro'>유로</option>");
		pw.print("<option value='sgd'>싱가포르 달러</option>");
		pw.print("</select>");
		// hidden 태그를 이용해 계산기에서 서블릿으로 수행할 요청 전달
		pw.print("<input type='hidden' name='command' value='calculate' />");
		pw.print("<input type='submit' value='변환' />");
		pw.print("</form>");
		pw.print("</html>");
	}
	
	private static String calculate(float won, String operator) {
		String result = null;
		if ("dollar".equals(operator)) {
			result = String.format("%.6f", won / 1203.5);
		} else if ("yuan".equals(operator)) {
			result = String.format("%.6f", won / 169.94);
		} else if ("pound".equals(operator)) {
			result = String.format("%.6f", won / 1497.52);
		} else if ("euro".equals(operator)) {
			result = String.format("%.6f", won / 1349.42);
		} else if ("sgd".equals(operator)) {
			result = String.format("%.6f", won / 1080.3);
		}
		return result;
	}

}
