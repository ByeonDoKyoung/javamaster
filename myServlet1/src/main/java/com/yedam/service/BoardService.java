package com.yedam.service;

import java.util.List;

import com.yedam.vo.BoardVO;
import com.yedam.vo.MemberVO;

public interface BoardService {
	List<BoardVO> boardList(int page);
	boolean addBoard(BoardVO board);
	BoardVO getBoard(int boardNo);
	int addViewCnt(int boardNo);
	// 수정.
	boolean modifyBoard(BoardVO board);
	// 삭제
	boolean deleteBoard(int board);
	
	// 로그인.
	MemberVO login(String id, String pw);
	MemberVO checkMember(String id);
}
