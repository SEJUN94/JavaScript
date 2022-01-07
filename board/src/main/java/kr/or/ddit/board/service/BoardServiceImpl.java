package kr.or.ddit.board.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.vo.BoardVO;

public class BoardServiceImpl implements IBoardService {
	
	private BoardDaoImpl dao;
	private static BoardServiceImpl service;
			
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getDao(); 
	}
	
	public static BoardServiceImpl getService() {
		if(service == null) service = new BoardServiceImpl();
		return service;
	}
	
	@Override
	public int countList() {
		int count = 0;
		try {
			count = dao.countList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public List<BoardVO> bordList(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		List<BoardVO> list = null;
		try {
			list = dao.bordList(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int insertBoard(BoardVO vo) {
		int seq = 0; 
		try {
			dao.insertBoard(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return seq;
	}

}
