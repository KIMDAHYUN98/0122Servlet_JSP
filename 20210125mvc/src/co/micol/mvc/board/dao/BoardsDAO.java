package co.micol.mvc.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.mvc.board.service.BoardVO;
import co.micol.mvc.common.DAO;

public class BoardsDAO extends DAO{
	// 보드테이블 접속하는 DAO
	
	private PreparedStatement psmt;
	private ResultSet rs; // 레코드 셋을 받을 인터페이스 생성
	
	private final String BOARDSELECTLIST = "SELECT * FROM BOARDS ORDER BY BOARD_NO DESC";
	private final String BOARDSELECT = "SELECT * FROM BOARDS WHERE BOARD_NO = ?";
	private final String BOARDINSERT = "INSERT INTO BOARDS VALUES(?, ?, ?, ?, ?)";
	private final String BOARDDELETE = "DELETE FROM BOARDS WHERE BOARD_NO = ?";
	
	public ArrayList<BoardVO> selectList() {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO vo;
		try {
			psmt = conn.prepareStatement(BOARDSELECTLIST);
			rs = psmt.executeQuery(); // record set(java => resultSet)을 리턴한다.
			while(rs.next()) { // while = 몇 행을 받을 지 알기 위해 사용, next() => 해당 되는 커서부터 차례대로 실행?
				vo = new BoardVO();
				vo.setBoardNo(rs.getInt("board_no")); // 실제 디비의 칼럼명과 같아야 함
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setCreationDate(rs.getDate("creation_date"));
				
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(); // 각 객체들을 닫아줌(열린 순서의 반대로)
		}
		
		return list; // boardVO 타입으로 ArrayList 반환
	}
	
	// CRUD
	
	public BoardVO select(BoardVO vo) { 
		//하나의 레코드 조회
		try {
			psmt = conn.prepareStatement(BOARDSELECT);
			psmt.setInt(1, vo.getBoardNo()); // getBoardNo를 집어 넣겠다
			rs = psmt.executeQuery(); 
			// 한개의 행을 출력하기 위해 while문이 아닌 if문을 사용한다
			if(rs.next()) {
				vo = new BoardVO();
				vo.setBoardNo(rs.getInt("board_no")); // 실제 디비의 칼럼명과 같아야 함
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
	
	public int insert(BoardVO vo) { // 여기에 입력작업을 작성
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
		// 여기에 수정작업을 작성
		return n;
	}
	
	public int delete(BoardVO vo) { // 여기에 삭제작업을 작성, 키로 해당되는 값을 지울 수 있어 편리
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
