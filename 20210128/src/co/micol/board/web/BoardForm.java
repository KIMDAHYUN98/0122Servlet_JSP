package co.micol.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Command;

public class BoardForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		return "views/board/boardForm.jsp";
	}

}
