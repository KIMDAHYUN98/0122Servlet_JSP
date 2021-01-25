package co.micol.prj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginResult")
public class LoginResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginResult() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// form���� �Ѿ�� ������ �޾ƿ�(���� ����)
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		//ȭ�鿡 �ѷ��ֱ� ���� ������ �̸� �񱳸� �غ���
		String message = null;
		
		
		if(id.equals("hong") && pw.equals("1234")) {
			message  = "�� ȯ���մϴ�.";
		} else {
			message = "�� ���̵� �Ǵ� �н����尡 Ʋ���ϴ�.";
		}
		
		request.setAttribute("msg", message); // ����� ����, ������ �� (k, v)
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/member/loginResult.jsp");
		// �����ĸ� forward -> ���ư� �� ���͵� �ư� ����..
		dispatcher.forward(request, response);
//		response.sendRedirect("jsp/member/loginResult.jsp"); // ��û�� �ٲ�� �Ǿ� null�� ����(����� ������� ������ �������� ���� �� ���)
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
