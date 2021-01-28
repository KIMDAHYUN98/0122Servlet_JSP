package co.micol.board.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Command;
import co.micol.board.dao.BoardDAO;
import co.micol.board.vo.BoardVO;

public class BoardList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 게시글 확인?
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		
		list = dao.selectList();
		request.setAttribute("list", list);
		
		return "views/board/boardList.jsp";
	}

}
