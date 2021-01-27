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

	private final String SELECTROW = "SELECT * FROM MEMBER WHERE MID=? AND MPASSWORD=?";

	@Override
	public ArrayList<MemberVo> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVo select(MemberVo vo) {
		// �Ѹ��� ���ڵ带 ã�ƿ��� �޼ҵ�
		try {
			psmt = conn.prepareStatement(SELECTROW);
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
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return n;
	}

	@Override
	public int update(MemberVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(MemberVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public boolean isidCheck(String id) { // id �ߺ� üũ�� ���� �޼ҵ�
		boolean bool = true;
		String sql = "select mid from member where mid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) { // rs�� ���� �����Ѵٸ�?
				bool = false;
			}
		}catch(SQLException e) {
			e.printStackTrace(); // �ܼ�â�� ���� ���������� �˷��ش�. �Ǵ� ���� �Է��� �޼����� ���.
		}finally {
			close();
		}
		return bool;
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
