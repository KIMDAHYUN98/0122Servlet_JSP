package co.micol.minipro.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.minipro.common.Service;

public class MemberJoinForm implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 회원가입을 클릭했을 떄 회원가입 폼을 보여주기 위해 해당 경로를 지정한다. = 회원가입 호출
		return "views/member/memberJoinForm.jsp";
	}

}
