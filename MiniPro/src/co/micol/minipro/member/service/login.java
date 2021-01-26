package co.micol.minipro.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.minipro.common.Service;
import co.micol.minipro.member.dao.MemberDao;

public class login implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// �α��� ������ ó�� �Ѵ�.
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		
		vo.setmId(request.getParameter("mId"));
		vo.setmPassword(request.getParameter("mPassword"));
		
		vo = dao.select(vo);
		
		String viewPage = null;
		
		if(vo.getmAuth() != null) { // DAO�� Auth ���� ���� �� == �����Ѵ�
			HttpSession session = request.getSession(); // ���ǰ�ü ȣ��
			session.setAttribute("mId", vo.getmId());	// ���ǿ� ���� ����� ���̵�
			session.setAttribute("mAuth", vo.getmAuth());	// ���ǿ� ���� ����� ������ ��´�.
			request.setAttribute("vo", vo);
			viewPage = "views/member/loginSuccess.jsp"; 
		} else {
			viewPage = "views/member/loginFail.jsp";
		}
		
		
		return viewPage;
	}

}
