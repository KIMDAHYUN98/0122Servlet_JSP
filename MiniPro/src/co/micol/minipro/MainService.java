package co.micol.minipro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.minipro.common.Service;

public class MainService implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// �ܼ��� ���� ȭ���� �����ش�.
		return "views/main/main.jsp";
	}

}
