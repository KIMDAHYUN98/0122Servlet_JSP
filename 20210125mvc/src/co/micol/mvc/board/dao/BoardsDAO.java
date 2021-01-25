package co.micol.mvc.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.mvc.board.service.BoardVO;
import co.micol.mvc.common.DAO;

public class BoardsDAO extends DAO{
	// �������̺� �����ϴ� DAO
	
	private PreparedStatement psmt;
	private ResultSet rs; // ���ڵ� ���� ���� �������̽� ����
	
	private final String BOARDSELECTLIST = "SELECT * FROM BOARDS ORDER BY BOARD_NO DESC";
	private final String BOARDSELECT = "SELECT * FROM BOARDS WHERE BOARD_NO = ?";
	private final String BOARDINSERT = "INSERT INTO BOARDS VALUES(?, ?, ?, ?, ?)";
	private final String BOARDDELETE = "DELETE FROM BOARDS WHERE BOARD_NO = ?";
	
	public ArrayList<BoardVO> selectList() {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO vo;
		try {
			psmt = conn.prepareStatement(BOARDSELECTLIST);
			rs = psmt.executeQuery(); // record set(java => resultSet)�� �����Ѵ�.
			while(rs.next()) { // while = �� ���� ���� �� �˱� ���� ���, next() => �ش� �Ǵ� Ŀ������ ���ʴ�� ����?
				vo = new BoardVO();
				vo.setBoardNo(rs.getInt("board_no")); // ���� ����� Į����� ���ƾ� ��
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setCreationDate(rs.getDate("creation_date"));
				
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(); // �� ��ü���� �ݾ���(���� ������ �ݴ��)
		}
		
		return list; // boardVO Ÿ������ ArrayList ��ȯ
	}
	
	// CRUD
	
	public BoardVO select(BoardVO vo) { 
		//�ϳ��� ���ڵ� ��ȸ
		try {
			psmt = conn.prepareStatement(BOARDSELECT);
			psmt.setInt(1, vo.getBoardNo()); // getBoardNo�� ���� �ְڴ�
			rs = psmt.executeQuery(); 
			// �Ѱ��� ���� ����ϱ� ���� while���� �ƴ� if���� ����Ѵ�
			if(rs.next()) {
				vo = new BoardVO();
				vo.setBoardNo(rs.getInt("board_no")); // ���� ����� Į����� ���ƾ� ��
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setCreationDate(rs.getDate("creation_date"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}
	
	public int insert(BoardVO vo) { // ���⿡ �Է��۾��� �ۼ�
		int n = 0;
		try {
			psmt = conn.prepareStatement(BOARDINSERT);
			psmt.setInt(1, vo.getBoardNo());
			psmt.setString(2, vo.getTitle());
			psmt.setString(3, vo.getContent());
			psmt.setString(4, vo.getWriter());
			psmt.setDate(5, vo.getCreationDate());
			n= psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return n;
	}
	
	public int update(BoardVO vo) {
		int n = 0;
		// ���⿡ �����۾��� �ۼ�
		return n;
	}
	
	public int delete(BoardVO vo) { // ���⿡ �����۾��� �ۼ�, Ű�� �ش�Ǵ� ���� ���� �� �־� ��
		int n = 0;
		try {
			psmt = conn.prepareStatement(BOARDDELETE);
			psmt.setInt(1, vo.getBoardNo());
			n = psmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return n;
	}
	
	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
