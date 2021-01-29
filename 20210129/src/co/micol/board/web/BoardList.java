package co.micol.board.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Command;
import co.micol.board.dao.BoardDAO;
import co.micol.board.vo.BoardVO;

public class BoardList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 게시판 리스트 가져오는 것
		BoardDAO dao = new BoardDAO(); // 데이터 연결
		ArrayList<BoardVO> list = new ArrayList<BoardVO>(); // 리스트 타입
		 
		list = dao.selectList();

		request.setAttribute("list", list);
		
		return "board/boardList";
	}

}
