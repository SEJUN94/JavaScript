package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.Map;

import kr.or.ddit.member.vo.MemberVO;

public interface IMemberDao {

	//회원정보 저장
	public void insertMember(MemberVO vo) throws SQLException;


}
