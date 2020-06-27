package chap06.prac;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/input2")
public class MultipleInputServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("[MultipleInputServlet2] init()");
	}

	public void destroy() {
		System.out.println("[MultipleInputServlet2] destroy()");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전송된 name 속성들만 Enumeration 타입으로 받아옴
		Enumeration enu = request.getParameterNames();
		while (enu.hasMoreElements()){
			String name = (String) enu.nextElement(); // 원래는 Object type next element를 반환한다
			String[] values = request.getParameterValues(name);
			for (String str : values)
				System.out.println("name= " + name + ", value= " + str);
		}
	}

}
