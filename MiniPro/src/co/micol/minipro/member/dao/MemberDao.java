package co.micol.minipro.member.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.minipro.common.DAO;
import co.micol.minipro.common.DbInterface;
import co.micol.minipro.member.service.MemberVo;

public class MemberDao extends DAO implements DbInterface<MemberVo> {
	private PreparedStatement psmt;
	private ResultSet rs;

	

	@Override
	public ArrayList<MemberVo> selectList() {
		// 회원 전체 리스트를 반환한다.
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		MemberVo vo = new MemberVo();
		String SQL = "SELECT * FROM MEMBER";

		try {
			psmt = conn.prepareStatement(SQL);
			rs = psmt.executeQuery();

			while (rs.next()) {
				vo = new MemberVo();
				vo.setmId(rs.getString("mid"));
				vo.setmName(rs.getString("mname"));
				vo.setmAuth(rs.getString("mauth"));

				// 비밀번호는 관리자도 볼 수 없기 때문에 반환하지 않는다.

				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	@Override
	public MemberVo select(MemberVo vo) { // 한명의 레코드를 찾아오는 메소드

		 String sql = "SELECT * FROM MEMBER WHERE MID = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getmId());
			rs = psmt.executeQuery();
			if (rs.next()) { // 값이 있으면 해당하는 권한과 이름을 담는다
				vo.setmAuth(rs.getString("mauth"));
				vo.setmName(rs.getString("mname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	@Override
	public int insert(MemberVo vo) {
		String sql = "INSERT INTO MEMBER(MID, MNAME, MPASSWORD) VALUES(?, ?, ?)";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getmId());
			psmt.setString(2, vo.getmName());
			psmt.setString(3, vo.getmPassword());

			System.out.println(vo.getmId());

			n = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return n;
	}

	@Override
	public int update(MemberVo vo) {
		// 권한, PW을 변경하는 메소드(id는 PK이기 때문에 변경X)
		// 무엇을 변경할 지 모르기 때문에 
		String sql = null;
		int n = 0;

		if (vo.getmPassword() != null) {
			sql = "UPDATE MEMBER SET MPASSWORD = ? WHERE MID = ?"; // pw 변경
		} else if (vo.getmAuth() != null) {
			sql = "UPDATE MEMBER SET MAUTH = ? WHERE MID = ?"; // 권한 변경
		}

		try {
			psmt = conn.prepareStatement(sql);
			if (vo.getmPassword() != null) {
				psmt.setString(1, vo.getmPassword()); // pw 변경할 때
			} else {
				psmt.setString(1, vo.getmAuth()); // 권한 변경할 때
			}

			psmt.setString(2, vo.getmId());
			n = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public int delete(MemberVo vo) {
		// 한 회원 정보 삭제
		String sql = "DELETE FROM MEMBER WHERE MID = ?";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getmId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	public boolean isidCheck(String id) { // id 중복 체크를 위한 메소드, IsXXX = boolean 타입의 메소드
		boolean bool = true;
		String sql = "select mid from member where mid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) { // rs에 값이 존재한다면?
				bool = false;
			}
		} catch (SQLException e) {
			e.printStackTrace(); // 콘솔창에 무슨 오류인지를 알려준다. 또는 내가 입력한 메세지로 뜬다.
		} finally {
			close();
		}
		return bool;
	}

	public MemberVo login(MemberVo vo) { // 로그인에서 사용되는 메소드
		
		String sql = "SELECT * FROM MEMBER WHERE MID = ? AND mpassword = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getmId());
			psmt.setString(2, vo.getmPassword());
			rs = psmt.executeQuery();
			if (rs.next()) { // 값이 있으면 해당하는 권한과 이름을 담는다
				vo.setmAuth(rs.getString("mauth"));
				vo.setmName(rs.getString("mname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
