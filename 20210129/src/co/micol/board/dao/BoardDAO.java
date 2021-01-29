package co.micol.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import co.micol.board.common.DAO;
import co.micol.board.vo.BoardVO;
import co.micol.board.vo.replyVO;

public class BoardDAO extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;

	public ArrayList<BoardVO> selectList() {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO vo;
		String sql = "SELECT * FROM BOARD";

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new BoardVO();
				vo.setbId(rs.getInt("bId"));
				vo.setbName(rs.getString("bName"));
				vo.setbTitle(rs.getString("bTitle"));
				vo.setbContent(rs.getString("bContent"));
				vo.setbDate(rs.getDate("bDate"));
				vo.setbHit(rs.getInt("bHit"));

				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	public BoardVO select(BoardVO vo) {

		String sql = "SELECT * FROM BOARD WHERE BID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbId());
			rs = psmt.executeQuery();
			if (rs.next()) {

				vo = new BoardVO();
				vo.setbId(rs.getInt("bId"));
				vo.setbName(rs.getString("bName"));
				vo.setbTitle(rs.getString("bTitle"));
				vo.setbContent(rs.getString("bContent"));
				vo.setbDate(rs.getDate("bDate"));
				vo.setbHit(rs.getInt("bHit"));
				hitCount(rs.getInt("bId"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return vo;
	}
	
	public BoardVO editSelect(BoardVO vo) { // 수정하러 갈 때는 조회수 증가하는 것을 막기위해 editSelect 메소드를 만든다.

		String sql = "SELECT * FROM BOARD WHERE BID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbId());
			rs = psmt.executeQuery();
			if (rs.next()) {

				vo = new BoardVO();
				vo.setbId(rs.getInt("bId"));
				vo.setbName(rs.getString("bName"));
				vo.setbTitle(rs.getString("bTitle"));
				vo.setbContent(rs.getString("bContent"));
				vo.setbDate(rs.getDate("bDate"));
				vo.setbHit(rs.getInt("bHit"));
			

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return vo;
	}

	public int insert(BoardVO vo) {
		int n = 0;

		String sql = "INSERT INTO BOARD(BID, BNAME, BTITLE, BCONTENT, BDATE) VALUES (BIDSQ.NEXTVAL, ?, ?, ?, ?)";
		try {
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getbName());
			psmt.setString(2, vo.getbTitle());
			psmt.setString(3, vo.getbContent());
			psmt.setDate(4, vo.getbDate());
			
			n = psmt.executeUpdate();
			System.out.println(n);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return n;

	}

	public int delete(BoardVO vo) {
		int n = 0;
		String sql = "delete from board where bid = ?";
		try {
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return n;

	}

	public int update(BoardVO vo) {
		int n = 0;
		String sql = "update board set bcontent = ? where bid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getbContent());
			psmt.setInt(2, vo.getbId());

			n = psmt.executeUpdate();
			System.out.println(n);
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}
		return n;

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

	private void hitCount(int hit) {
		String sql = "UPDATE BOARD SET BHIT = BHIT + 1 WHERE BID =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, hit);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<replyVO> replySelect(replyVO vo) { // 댓글 가져오기
		ArrayList<replyVO> replyList = new ArrayList<replyVO>();
		replyVO rvo;
		String sql = "SELECT * FROM REPLY WHERE BID = ?";
		try {
			psmt= conn.prepareStatement(sql);
			psmt.setInt(1, vo.getBid());
			rs = psmt.executeQuery();
			while(rs.next()) {
				rvo = new replyVO();
				rvo.setBid(rs.getInt("bid"));
				rvo.setRnum(rs.getInt("rnum"));
				rvo.setSubject(rs.getString("subject"));
				rvo.setRdate(rs.getDate("rdate"));
				
				replyList.add(rvo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return replyList;
	}
}
