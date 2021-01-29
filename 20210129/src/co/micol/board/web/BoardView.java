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
		// �󼼺���()
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO(); // boardvo Ÿ������ ��ȯ
		replyVO rvo = new replyVO();
		ArrayList<replyVO> list = new ArrayList<replyVO>(); // ��� ���
		
		vo.setbId(Integer.parseInt(request.getParameter("bId"))); // boardList�� ���� ������ vo�� ����ش�.
		rvo.setBid(Integer.parseInt(request.getParameter("bId"))); // ��� ��������
		
		vo = dao.select(vo); // ���� �� �б�
		
		dao = new BoardDAO(); // ���� �ٽ� ����..
		list = dao.replySelect(rvo); // ��� �б�
		
		request.setAttribute("vo", vo); // request ��ü�� ���� return ������ �����ش�. (���� ��)
		request.setAttribute("list", list); // list��� ���������� ����� ����. (���)
		
		return "board/boardView";
	}

}
