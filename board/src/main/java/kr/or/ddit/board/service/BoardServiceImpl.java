package kr.or.ddit.board.service;

import java.sql.SQLException;

import kr.or.ddit.board.dao.BoardDaoImpl;

public class BoardServiceImpl implements IBoardService {
	
	private BoardDaoImpl dao;
	private static BoardServiceImpl service;
			
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getDao(); 
	}
	
	public static BoardServiceImpl getDao() {
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

}
