package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;

public interface IBoardService {
	
	// 전체 글 갯수 조회
	public int  countList();
	
	// 페이지 별 리스트 조회
	public List<BoardVO> bordList(Map<String, Integer> map);
}
