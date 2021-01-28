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
		map.put("/boardList.do", new BoardList()); // �Խñ� ���
		map.put("/boardForm.do", new BoardForm()); // ���ۼ� ��
		map.put("/boardInsert.do", new BoardInsert()); // �� ���
		map.put("/boardView.do", new BoardView()); // �� �󼼺���
		map.put("/boardDelete.do", new BoardDelete()); // �� ����
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String contextPath = request.getContextPath(); // request ��ü�� ���� �޼ҵ带 ã�ƿ´�.
		String uri = request.getRequestURI();
		String path = uri.substring(contextPath.length()); // uri - contextPath ������ = ��ü ó����(= ��û) ���
		
		Command command = map.get(path); // key������ ��û�� value�� ��ȯ, ��û�� ���� ó���ϴ� command�� ã���ش�.
		String viewPage = command.execute(request, response); // ó�� �� �� ����� ������ page ���� ��ȯ�Ѵ�.
		
	
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
