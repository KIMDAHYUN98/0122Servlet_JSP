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
import co.micol.board.web.BoardEditForm;
import co.micol.board.web.BoardEdit;
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
		map.put("/main.do", new MainCommand()); // ����
		map.put("/boardList.do", new BoardList()); // ���
		map.put("/boardView.do", new BoardView()); // �󼼺���
		map.put("/boardInsert.do", new BoardInsert()); // ����
		map.put("/boardDelete.do", new BoardDelete()); // ����
		map.put("/boardEditForm.do", new BoardEditForm()); // ����
		map.put("/boardEdit.do", new BoardEdit()); // select
		map.put("/boardForm.do", new BoardForm());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// service ��ü ���� �� reserve ����
		
		request.setCharacterEncoding("utf-8");
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		String path = uri.substring(contextPath.length());
		
		Command command = map.get(path);
		String viewPage = command.exec(request, response);
		
		if(!viewPage.endsWith(".do")) viewPage = "/WEB-INF/jsp/" + viewPage + ".jsp"; // = viewReserve
		
		//viewPage.endsWith(".jsp")) viewPage = "/WEB-INF/jsp/" + viewPage
		// .jsp�� ������ web-inf/jsp/ + viewPage�� ���ض�.
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response); 
		// ��������� ���� ��ü
	}

}
