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
		request.setCharacterEncoding("utf-8"); // 한글 깨짐 방지
		BoardsDAO dao = new BoardsDAO();
		BoardVO vo = new BoardVO();
		int row = Integer.parseInt(request.getParameter("row")); // get 방식으로 BoardDAO에 전달받은 값을 row에 담는다, 문자를 숫자로 변환
		vo.setBoardNo(row);
		
		vo = dao.select(vo); // DB 호출(리턴타입에 맞게끔 선정)
		request.setAttribute("vo", vo); // jsp에 쓰기 위해 request에 담음ㄴ
		String viewPage = "views/board/boardSelect.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
