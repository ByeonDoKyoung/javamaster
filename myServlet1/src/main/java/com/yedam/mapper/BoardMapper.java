package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.BoardVO;
import com.yedam.vo.MemberVO;

public interface BoardMapper {
	List<BoardVO> boardList(); // 목록
	List<BoardVO> boardListPaging(int page);
	int insertBoard(BoardVO board);
	BoardVO selectBoard(int boardNo);
	int updateViewCnt(int boardNo);
	int updateBoard(BoardVO board); // 수정처리.
	
	int deleteBoard(int boardNo); // 삭제처리.
	int removeBoard(int board);
	
	// 사용자id, pw확인
	MemberVO selectMember(@Param("id")String id, @Param("pw")String pw);
	MemberVO selectMember2(String id);
}
