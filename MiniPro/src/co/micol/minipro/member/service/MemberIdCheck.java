package co.micol.minipro.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.minipro.common.Service;
import co.micol.minipro.member.dao.MemberDao;

public class MemberIdCheck implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// ���̵� �ߺ� üũ
		
		MemberDao dao = new MemberDao();
		String id = request.getParameter("mId");
		boolean bool = dao.isidCheck(id); // ���̵� ������ �� true, �������� ���� �� false ��ȯ
		String message = null;
		if(bool) {
			message = id + "��(��) ����� �� �ִ� ���̵� �Դϴ�.";
		}else {
			message = id + "��(��) ����� �� ���� ���̵� �Դϴ�.";
		}
		
		request.setAttribute("msg", message);
		request.setAttribute("check", bool);

		return "views/member/idCheck.jsp";
	}

}
