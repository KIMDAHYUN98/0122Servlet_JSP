package co.micol.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Command;
import co.micol.board.dao.BoardDAO;
import co.micol.board.vo.BoardVO;

public class BoardView implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 글 상세 보기
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		vo.setbId(Integer.parseInt(request.getParameter("bId")));
		vo = dao.select(vo);
		
		request.setAttribute("vo", vo);
		
		return "views/board/boardView.jsp";
	}

}
