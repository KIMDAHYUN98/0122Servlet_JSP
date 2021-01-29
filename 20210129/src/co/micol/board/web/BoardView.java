package co.micol.board.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Command;
import co.micol.board.dao.BoardDAO;
import co.micol.board.vo.BoardVO;
import co.micol.board.vo.replyVO;

public class BoardView implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 상세보기()
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO(); // boardvo 타입으로 반환
		replyVO rvo = new replyVO();
		ArrayList<replyVO> list = new ArrayList<replyVO>(); // 댓글 담기
		
		vo.setbId(Integer.parseInt(request.getParameter("bId"))); // boardList에 값을 가져와 vo에 담아준다.
		rvo.setBid(Integer.parseInt(request.getParameter("bId"))); // 댓글 가져오기
		
		vo = dao.select(vo); // 메인 글 읽기
		
		dao = new BoardDAO(); // 새로 다시 연결..
		list = dao.replySelect(rvo); // 댓글 읽기
		
		request.setAttribute("vo", vo); // request 객체로 값을 return 문으로 던져준다. (메인 글)
		request.setAttribute("list", list); // list라는 변수명으로 댓글을 담자. (댓글)
		
		return "board/boardView";
	}

}
