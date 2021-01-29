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
		// �Խ��� ����Ʈ �������� ��
		BoardDAO dao = new BoardDAO(); // ������ ����
		ArrayList<BoardVO> list = new ArrayList<BoardVO>(); // ����Ʈ Ÿ��
		 
		list = dao.selectList();

		request.setAttribute("list", list);
		
		return "board/boardList";
	}

}
