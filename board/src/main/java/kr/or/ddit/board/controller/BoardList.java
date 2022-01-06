package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.vo.BoardVO;

/**
 * Servlet implementation class BoardList
 */
@WebServlet("/List")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// character setting
		request.setCharacterEncoding("UTF-8");
		
		// 요청 데이터 가져오기
		// request.getParameter의 리턴 타입은 String
		// page 값을 Integer형으로 변환한다.
		//String page = request.getParameter("page");
		int sPage = Integer.parseInt(request.getParameter("page"));
		
		// 서비스 객체 얻어오기
		BoardServiceImpl service = BoardServiceImpl.getService();
		
		// 화면에 출력할 페이지 수
		int perPage = 2;
		
		// 한 페이지에 출력할 글 갯수
		int perList = 5;
		
		// 전체 글 갯수 데이터 얻기 - service객체 필요
		int count = service.countList();
		
		// 전체 페이지 수 계산
		// [공식]전체 페이지수 = 전체 글 갯수 / 페이지당 글 갯수
		// double로 소수점을 발생시켜 정확한 결과 값을 얻는다
		int totalPage = (int) Math.ceil((double)count / (double)perList);
		
		//System.out.println("double 사용>> " + (double)21/(double)perList);
		//System.out.println("double 미사용>> " + 21/perList);
		
		// 페이지 별 게시글의 시작(start)과 끝(end) 값
		// [공식] (sPage(초기 시작 페이지)-1) * perList + 1
		// [예시] sPage가 1일 때 : (1-1)*5+1 = 1
		//              2일 때 : (2-1)*5+1 = 6
		//              3일 때 : (3-1)*5+1 = 11
		//              4일 때 : (4-1)*5+1 = 16
		int start = (sPage - 1) * perList + 1;
		
		// [공식] 끝 값 구하기 start +perList - 1
		// [예시] sPage가 1일 때 : 1 + 5 - 1 = 5
		// 				2일 때 : 6 + 5 - 1 = 10
		//  			3일 때 : 11 + 5 - 1 = 15
		//  			4일 때 : 16 + 5 - 1 = 20
		int end = start + perList - 1;
		// end = perList(현재 페이지에 표현될 글 갯수) * sPage(현재 페이지)로 사용가능
		
		// end 값이 count 값보다 크게 계산되었을 경우, count값을 end값에 대입한다
		if(end > count) end = count;
		
		// 화면에 보여지는 페이지 번호(startPage, endPage) 구하기
		// [공식] ((sPage - 1) / perPage * perPage) + 1;
		// [예시] sPage가 1일때 : ((1-1) / 2*2) + 1 = 1 / sPage가 2일 때 : (((2-1)/2*2)+1 =1
		// 		 sPage가 3일때 : ((3-1) / 2*2) + 1 = 1 / sPage가 4일 때 : ((4-1)/2*2)+1 = 3
		
		int startPage = ((sPage -1 ) / perPage * perPage) + 1;
		
		// [공식] startPage + perPage - 1;
		// [예시] sPage 1,2일때 : 1 + 2 -1 = 2;
		//       sPage 3,4일때 : 3 + 2 -1 = 4;
		int endPage = startPage + perPage - 1;
		
		// 객체 접근하여 메소드 호출하고 결과 값(리스트 데이터) 받기 - 
		Map<String, Integer> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		
		List<BoardVO> list = service.bordList(map);
		
		
		
		// request에 저장하고 jsp로 포워딩
		request.setAttribute("list", list);
		request.setAttribute("sPage", startPage);
		request.setAttribute("ePage", endPage);
		request.setAttribute("ttPage", totalPage);
		
		
		request.getRequestDispatcher("board/list.jsp").forward(request, response);
	}

}
