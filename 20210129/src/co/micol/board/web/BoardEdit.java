package co.micol.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Command;
import co.micol.board.dao.BoardDAO;
import co.micol.board.vo.BoardVO;

public class BoardEdit implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {

		// 게시글 폼 요청
		BoardVO vo = new BoardVO();
		BoardDAO dao = new BoardDAO();
		vo.setbId(Integer.parseInt(request.getParameter("bId")));
		vo = dao.editSelect(vo);
		request.setAttribute("vo", vo);

		return "board/boardEditForm";
	}

}
