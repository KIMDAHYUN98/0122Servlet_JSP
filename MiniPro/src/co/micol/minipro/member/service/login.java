package co.micol.minipro.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.minipro.common.Service;
import co.micol.minipro.member.dao.MemberDao;

public class login implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 로그인 과정을 처리 한다.
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		
		vo.setmId(request.getParameter("mId"));
		vo.setmPassword(request.getParameter("mPassword"));
		
		vo = dao.select(vo);
		
		String viewPage = null;
		
		if(vo.getmAuth() != null) { // DAO의 Auth 값이 있을 때 == 존재한다
			HttpSession session = request.getSession(); // 섹션객체 호출
			session.setAttribute("mId", vo.getmId());	// 색션에 내가 사용할 아이디
			session.setAttribute("mAuth", vo.getmAuth());	// 색션에 내가 사용할 권한을 담는다.
			request.setAttribute("vo", vo);
			viewPage = "views/member/loginSuccess.jsp"; 
		} else {
			viewPage = "views/member/loginFail.jsp";
		}
		
		
		return viewPage;
	}

}
