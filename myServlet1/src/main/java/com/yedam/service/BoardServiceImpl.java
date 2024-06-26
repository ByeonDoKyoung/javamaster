package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;
import com.yedam.vo.MemberVO;

public class BoardServiceImpl implements BoardService {
	SqlSession session = DataSource.getInstance().openSession(true);
	BoardMapper mapper = session.getMapper(BoardMapper.class);

	@Override
	public List<BoardVO> boardList(int page) {
		// TODO Auto-generated method stub
		return mapper.boardListPaging(page);
	}

	@Override
	public boolean addBoard(BoardVO board) {
		// TODO Auto-generated method stub
		return mapper.insertBoard(board) == 1;
	}

	@Override
	public BoardVO getBoard(int boardNo) {
		// TODO Auto-generated method stub
		return mapper.selectBoard(boardNo);
	}

	@Override
	public int addViewCnt(int boardNo) {
		// TODO Auto-generated method stub
		return mapper.updateViewCnt(boardNo);
	}

	@Override
	public boolean modifyBoard(BoardVO board) {
		// TODO Auto-generated method stub
		return mapper.updateBoard(board) == 1;
	}

	@Override
	public boolean deleteBoard(int board) {
		// TODO Auto-generated method stub
		return mapper.removeBoard(board) == 1;
	}

	@Override
	public MemberVO login(String id, String pw) {
		return mapper.selectMember(id, pw);
	}

	@Override
	public MemberVO checkMember(String id) {
		return mapper.selectMember2(id);
	}
	
}
