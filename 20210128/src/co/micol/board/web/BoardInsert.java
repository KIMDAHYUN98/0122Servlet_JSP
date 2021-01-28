package co.micol.board.web;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Command;
import co.micol.board.dao.BoardDAO;
import co.micol.board.vo.BoardVO;

public class BoardInsert implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// ±Û ¸ñ·Ï
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		vo.setbName(request.getParameter("bName"));
		vo.setbDate(Date.valueOf(request.getParameter("bDate")));
		vo.setbTitle(request.getParameter("bTitle"));
		vo.setbContent(request.getParameter("bContent"));
		
		int n = 0;
		n = dao.insert(vo);
		
		String viewPage = "boardList.do";
		
		if(n == 0) {
			viewPage = "views/board/boardInsertFail.jsp";
		}
		
		return viewPage;
	}

}
