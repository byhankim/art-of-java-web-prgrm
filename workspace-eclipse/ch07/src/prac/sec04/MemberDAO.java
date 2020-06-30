package prac.sec04;

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

public class MemberDAO {
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
	
	public List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
//			connDB();
			con = dataFactory.getConnection();	// DataSource를 이용해 데이터베이스에 연결
			String query = "select * from t_member ;";
			System.out.println("[prepqreStatement: " + query);
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
	
	public void addMember(MemberVO memVO) {
		try {
			con = dataFactory.getConnection();	// DataSource를 이용해 데이터베이스와 연결
			String id = memVO.getId();	// 테이블에 저장할 회원정보
			String pw = memVO.getPw();
			String name = memVO.getName();
			String email = memVO.getEmail();
			String query = "INSERT INTO t_member";	// INSERT 문을 문자로 만든다
			query += " (id, pw, name, email) ";
			query += " values (?, ?, ?, ?)";
			System.out.println("prepareStatememt: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);		// INSERT문의 각 ? 에 순서대로 회원정보를 세팅
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();		// 회원정보를 데이터에 추가
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delMember(String id) {
		try {
			con = dataFactory.getConnection();
			String query = "DELETE FROM t_member " + "WHERE id=?";
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);	// 첫번째 ? 에 전달된 ID를 인자로 넣는다
			pstmt.executeUpdate();	// delete문 실행 및 회원삭제
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
