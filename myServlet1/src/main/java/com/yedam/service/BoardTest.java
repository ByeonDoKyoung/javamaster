package com.yedam.service;

public class BoardTest {
	public static void main(String[] args) {
		BoardService svc = new BoardServiceImpl();
		svc.boardList(1).forEach(board -> System.out.println(board));
	}
}
