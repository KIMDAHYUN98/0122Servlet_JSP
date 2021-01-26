package co.micol.minipro.board.dao;

import java.util.ArrayList;

import co.micol.minipro.board.service.BoardVo;
import co.micol.minipro.common.DAO;
import co.micol.minipro.common.DbInterface;

public class BoardDao extends DAO implements DbInterface<BoardVo> {

	@Override // = ¿Á¡§¿«
	public ArrayList<BoardVo> selectList() {
		return null;
	}

	@Override
	public BoardVo select(BoardVo vo) {
		return null;
	}

	@Override
	public int insert(BoardVo vo) {
		return 0;
	}

	@Override
	public int update(BoardVo vo) {
		return 0;
	}

	@Override
	public int delete(BoardVo vo) {
		return 0;
	}

}
