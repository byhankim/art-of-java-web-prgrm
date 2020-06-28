package prac.sec01;

import java.sql.DriverManager;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class MemberDAO {
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://112.158.188.188:3306/javaweb";
	private static final String user = "root";
	private static final String pwd = "qwer1234";
	private Statement stmt;
	private Connection con;

	public List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			connDB();
			String query = "select * from t_member;";
			System.out.println("[쿼리문]: " + query);
			ResultSet rs = stmt.executeQuery(query);
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
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;	// 조회한 레코드 개수만큼 MEmberVO 객체를 저장한 ArrayList를 반환
	}
	
	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("MySQL driver 로딩 성공");
			con = (Connection) DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection 생성 성공");
			stmt = (Statement) con.createStatement();
			System.out.println("Statement 생성 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
