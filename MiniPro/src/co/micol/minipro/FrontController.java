package co.micol.minipro;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.minipro.common.Service;
import co.micol.minipro.member.service.login;
import co.micol.minipro.member.service.loginForm;
import co.micol.minipro.member.service.logout;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String, Service> map = new HashMap<String, Service>();
    // � ��û�� ������ � ���� ������ ���ΰ�?
    // String = ��û��, Service = ������ Command
   
    public FrontController() {
        super(); 
    }


	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainService()); // ����ȭ�� ȣ��
		map.put("/loginForm.do", new loginForm()); // �α��� �� ȣ��
		map.put("/login.do", new login());
		map.put("/logout.do", new logout());
//		map.put("/boardlist.do", new BoardList()); (��û��, ������ command)
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String contextPath = request.getContextPath(); // �ֻ��� ���
		String uri = request.getRequestURI();
		String path = uri.substring(contextPath.length()); // ���� ��û�� ��� Ȯ��
		
		Service service = map.get(path); // new MainService(), ������ command�� ã�� �κ�
		String viewPage = service.run(request, response); // �����ؼ� ����� �����ִ� ������
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
