package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;

public interface IBoardDao {

	// 전체 글 갯수 조회
	public int countList() throws SQLException; 
	
	// 페이지 별 리스트 조회
	public List<BoardVO> bordList(Map<String, Integer> map) throws Exception;
	
	// 게시글 저장
	public int insertBoard(BoardVO vo) throws Exception;

}
