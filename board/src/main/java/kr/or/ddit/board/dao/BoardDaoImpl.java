package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.ibatis.config.BuildedSqlMapClient;

public class BoardDaoImpl implements IBoardDao {
	
	private SqlMapClient smc;
	private static BoardDaoImpl dao;
			
	// 1. private constructor
	private BoardDaoImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}
	// 2. static method
	public static BoardDaoImpl getDao() {
		if(dao == null) dao = new BoardDaoImpl();
		return dao;
	}
	
	@Override
	public int countList() throws SQLException {
		return (int) smc.queryForObject("board.countList");
	}
	@Override
	public List<BoardVO> bordList(Map<String, Integer> map) throws Exception {
		return smc.queryForList("board.boardList", map);		
	}
}
