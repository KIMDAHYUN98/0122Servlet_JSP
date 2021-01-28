package co.micol.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Command;
import co.micol.board.dao.BoardDAO;
import co.micol.board.vo.BoardVO;

public class BoardDelete implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// ±€ ªË¡¶
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		vo.setbId(Integer.parseInt(request.getParameter("bId")));
		
		int n = dao.delete(vo);
		
		String viewPage = "boardList.do";
		
		if(n == 0) 
			viewPage = "views/board/boardDeleteFail.jsp";
	
		return viewPage;
	}

}
