package co.micol.board.web;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Command;
import co.micol.board.dao.BoardDAO;
import co.micol.board.vo.BoardVO;

public class BoardInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		vo.setbName(request.getParameter("bName"));
		vo.setbDate(Date.valueOf(request.getParameter("bDate")));
		vo.setbTitle(request.getParameter("bTitle"));
		vo.setbContent(request.getParameter("bContent"));
		
		 int n = dao.insert(vo);
		
		String viewPage = "boardList.do";
		
		if(n == 0) {
			viewPage = "board/boardInsertFail";
		}
		
		return viewPage;
	}

}
