package co.micol.board.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.web.BoardDelete;
import co.micol.board.web.BoardForm;
import co.micol.board.web.BoardInsert;
import co.micol.board.web.BoardList;
import co.micol.board.web.BoardView;
import co.micol.board.web.MainCommand;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();
 
    public FrontController() {
        super();
    }
    
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand());
		map.put("/boardList.do", new BoardList()); // 게시글 목록
		map.put("/boardForm.do", new BoardForm()); // 글작성 폼
		map.put("/boardInsert.do", new BoardInsert()); // 글 등록
		map.put("/boardView.do", new BoardView()); // 글 상세보기
		map.put("/boardDelete.do", new BoardDelete()); // 글 삭제
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String contextPath = request.getContextPath(); // request 객체를 통한 메소드를 찾아온다.
		String uri = request.getRequestURI();
		String path = uri.substring(contextPath.length()); // uri - contextPath 나머지 = 실체 처리할(= 요청) 경로
		
		Command command = map.get(path); // key값으로 요청해 value를 반환, 요청한 것을 처리하는 command를 찾아준다.
		String viewPage = command.execute(request, response); // 처리 한 후 결과를 돌려줄 page 값을 반환한다.
		
	
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
