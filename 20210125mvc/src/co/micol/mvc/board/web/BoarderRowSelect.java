package co.micol.mvc.board.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.mvc.board.dao.BoardsDAO;
import co.micol.mvc.board.service.BoardVO;

@WebServlet("/BoarderRowSelect.do")
public class BoarderRowSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoarderRowSelect() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // �ѱ� ���� ����
		BoardsDAO dao = new BoardsDAO();
		BoardVO vo = new BoardVO();
		int row = Integer.parseInt(request.getParameter("row")); // get ������� BoardDAO�� ���޹��� ���� row�� ��´�, ���ڸ� ���ڷ� ��ȯ
		vo.setBoardNo(row);
		
		vo = dao.select(vo); // DB ȣ��(����Ÿ�Կ� �°Բ� ����)
		request.setAttribute("vo", vo); // jsp�� ���� ���� request�� ������
		String viewPage = "views/board/boardSelect.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
