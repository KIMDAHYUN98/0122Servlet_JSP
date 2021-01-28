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
		// ȸ�� ��ü ����Ʈ�� ��ȯ�Ѵ�.
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

				// ��й�ȣ�� �����ڵ� �� �� ���� ������ ��ȯ���� �ʴ´�.

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
	public MemberVo select(MemberVo vo) { // �Ѹ��� ���ڵ带 ã�ƿ��� �޼ҵ�

		 String sql = "SELECT * FROM MEMBER WHERE MID = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getmId());
			rs = psmt.executeQuery();
			if (rs.next()) { // ���� ������ �ش��ϴ� ���Ѱ� �̸��� ��´�
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
		// ����, PW�� �����ϴ� �޼ҵ�(id�� PK�̱� ������ ����X)
		// ������ ������ �� �𸣱� ������ 
		String sql = null;
		int n = 0;

		if (vo.getmPassword() != null) {
			sql = "UPDATE MEMBER SET MPASSWORD = ? WHERE MID = ?"; // pw ����
		} else if (vo.getmAuth() != null) {
			sql = "UPDATE MEMBER SET MAUTH = ? WHERE MID = ?"; // ���� ����
		}

		try {
			psmt = conn.prepareStatement(sql);
			if (vo.getmPassword() != null) {
				psmt.setString(1, vo.getmPassword()); // pw ������ ��
			} else {
				psmt.setString(1, vo.getmAuth()); // ���� ������ ��
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
		// �� ȸ�� ���� ����
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

	public boolean isidCheck(String id) { // id �ߺ� üũ�� ���� �޼ҵ�, IsXXX = boolean Ÿ���� �޼ҵ�
		boolean bool = true;
		String sql = "select mid from member where mid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) { // rs�� ���� �����Ѵٸ�?
				bool = false;
			}
		} catch (SQLException e) {
			e.printStackTrace(); // �ܼ�â�� ���� ���������� �˷��ش�. �Ǵ� ���� �Է��� �޼����� ���.
		} finally {
			close();
		}
		return bool;
	}

	public MemberVo login(MemberVo vo) { // �α��ο��� ���Ǵ� �޼ҵ�
		
		String sql = "SELECT * FROM MEMBER WHERE MID = ? AND mpassword = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getmId());
			psmt.setString(2, vo.getmPassword());
			rs = psmt.executeQuery();
			if (rs.next()) { // ���� ������ �ش��ϴ� ���Ѱ� �̸��� ��´�
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
