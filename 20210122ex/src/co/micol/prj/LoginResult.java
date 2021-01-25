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
		// form에서 넘어온 값들을 받아옴(메인 변수)
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		//화면에 뿌려주기 위해 사전에 미리 비교를 해보자
		String message = null;
		
		
		if(id.equals("hong") && pw.equals("1234")) {
			message  = "님 환영합니다.";
		} else {
			message = "님 아이디 또는 패스워드가 틀립니다.";
		}
		
		request.setAttribute("msg", message); // 사용할 변수, 전달할 값 (k, v)
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/member/loginResult.jsp");
		// 디스패쳐를 forward -> 돌아갈 떄 내것도 싣고 가라..
		dispatcher.forward(request, response);
//		response.sendRedirect("jsp/member/loginResult.jsp"); // 요청이 바뀌게 되어 null이 나옴(결과값 상관없이 강제로 페이지를 돌릴 때 사용)
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
