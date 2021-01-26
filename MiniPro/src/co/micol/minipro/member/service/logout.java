package co.micol.minipro.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.minipro.common.Service;

public class logout implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// logout 할 때는 디비 필요 없음, 섹션을 remove 하면 된다
		// 존재하는 섹션 객체를 호출 하기
		HttpSession session = request.getSession();
		String mid = (String) session.getAttribute("mId"); // 섹션이 가지고 있는 속성을 mid에 담는다
		request.setAttribute("mId", mid);
		session.invalidate(); // 섹션 전체 삭제
		return "views/member/logout.jsp"; // 돌려줄 페이지 지정(=main.do)
//		return "main.do";
	}

}
