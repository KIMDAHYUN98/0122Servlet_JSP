package co.micol.minipro.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.minipro.common.Service;

public class logout implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// logout �� ���� ��� �ʿ� ����, ������ remove �ϸ� �ȴ�
		// �����ϴ� ���� ��ü�� ȣ�� �ϱ�
		HttpSession session = request.getSession();
		String mid = (String) session.getAttribute("mId"); // ������ ������ �ִ� �Ӽ��� mid�� ��´�
		request.setAttribute("mId", mid);
		session.invalidate(); // ���� ��ü ����
		return "views/member/logout.jsp"; // ������ ������ ����(=main.do)
//		return "main.do";
	}

}
