package prac.sec03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
//import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
//import javax.naming.NamingException;
import javax.sql.DataSource;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;

public class MemberDAO {
//	private static final String driver = "com.mysql.jdbc.Driver";
//	private static final String url = "jdbc:mysql://112.158.188.188:3306/javaweb";
//	private static final String user = "root";
//	private static final String pwd = "qwer1234";
	
	private Connection con;
	private PreparedStatement pstmt;	// precompiled sql statment, not String
	private DataSource dataFactory;
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env"); // JNDI에 접근하기 위한 기본경로 지정
			dataFactory = (DataSource) envContext.lookup("jdbc/mysql"); // 톰캣 context.xml에 설정한 name값을 이용해 톰캣이 미리 설정한 DataSource를 받아온다
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public List listMembers() {
		List list = new ArrayList();
		try {
//			connDB();
			con = dataFactory.getConnection();	// DataSource를 이용해 데이터베이스에 연결
			String query = "select * from t_member ;";
			System.out.println("[Query]: " + query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPw(pw);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

//	private void connDB() {
//		try {
//			Class.forName(driver);
//			System.out.println("MySQL 드라이버 로딩 성공");
//			con = (Connection) DriverManager.getConnection(url, user, pwd);
//			System.out.println("Connection 생성 성공");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
