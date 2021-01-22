package co.micol.prj;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MemberRegister")
public class MemberRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberRegister() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String hobbys [] = request.getParameterValues("hobbys");
		String gender = request.getParameter("gender");
		String tel = request.getParameter("tel");
		
		String message = null;
		if(name.equals("hong")) {
			message = "님 환영합니다.";
		} else {
			message = "님 어서오세요.";
		}
		
		request.setAttribute("msg", message);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/member/memberRegister.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
