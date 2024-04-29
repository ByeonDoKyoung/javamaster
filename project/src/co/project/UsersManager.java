package co.project;

import java.util.List;
import java.util.Scanner;

public class UsersManager {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		
		UsersDAO udao = new UsersDAO();
		BoardDAO bdao = new BoardDAO();
		
		Users user = new Users();
		Board board = new Board();
		
		while(run) {
			System.out.println("-----------------------------------------------------------");
			System.out.println("1.회원가입 2.로그인 3.게시판조회 4.게시판등록 5.게시판수정 6.게시판삭제 7.종료");
			System.out.println("-----------------------------------------------------------");
			System.out.print("선택> ");
			
			int menu = Integer.parseInt(sc.nextLine());		
			switch(menu){
			// 회원가입
			case 1 :					
				System.out.println("회원가입을 해주세요");
				System.out.print("등록일> ");
				String usersDate = sc.nextLine();
				System.out.print("이름> ");
				String usersName = sc.nextLine();
				System.out.print("생년월일> ");
				String usersBirthday = sc.nextLine();
				System.out.print("휴대폰> ");
				String usersPhone = sc.nextLine();
				System.out.print("생성할아이디> ");	
				String usersId = sc.nextLine();
				System.out.print("생성할비밀번호> ");	
				String usersPw = sc.nextLine();
				
				user.setUsersDate(usersDate);
				user.setUsersName(usersName);
				user.setUsersBirthday(usersBirthday);
				user.setUsersPhone(usersPhone);
				user.setUsersId(usersId);
				user.setUsersPw(usersPw);
				
	
				if(udao.insertusers(user)){
					System.out.println("회원가입 완료");
				}else {
					System.out.println("회원가입 실패");
				}
			
				break;
				//로그인
			case 2 :
				System.out.print("id> ");
				String id = sc.nextLine();
				System.out.print("pw> ");
				String pw = sc.nextLine();	
				
				Users user1 = new Users();
				user1.setUsersId(id);
				user1.setUsersPw(pw);
				
			
				if(udao.login(user1)) {
				System.out.println("로그인 성공");
				}else {
				System.out.println("로그인 실패");
				}
			
				break;
				// 게시판 조회
			case 3 :
				List<Board> boards = bdao.selectBoard();
				System.out.println("----------------------------------------------------------------------------------------");
				System.out.println("번호	  제목		내용  		         	조회수");
				System.out.println("----------------------------------------------------------------------------------------");
				for (int i = 0; i < boards.size(); i++) {
					Board b = boards.get(i);
					System.out.printf(b.getBoardpostnum());
					System.out.printf(b.getBoardtitle());
					System.out.printf(b.getBoarddetail());
					System.out.println(b.getBoardviews());
				}
				System.out.println("----------------------------------------------------------------------------------------");
				System.out.println();
				
				break;
				//게시판등록
			case 4 :
				System.out.println("게시판을 등록해주세요.");
				System.out.print("제목> ");
				String title = sc.nextLine();
				System.out.print("내용> ");
				String detail = sc.nextLine();
				System.out.print("조회수> ");
				String views = sc.nextLine();
				
				board.setBoardtitle(title);
				board.setBoarddetail(detail);
				board.setBoardviews(views);
				
				boolean boardchk = bdao.insertBoard(board);
				if (boardchk) {
					System.out.println("게시판 등록 성공");
				}else {
					System.out.println("게시판 등록 실패");
				}
				
				break;
				// 게시판수정
			case 5 :
				System.out.print("수정할 게시판 번호> ");
				String postnumU = sc.nextLine();
				System.out.print("제목> ");
				String titleU = sc.nextLine();
				System.out.print("내용> ");
				String detailU = sc.nextLine();
				
				board.setBoardpostnum(postnumU);
				board.setBoardtitle(titleU);
				board.setBoarddetail(detailU);
				
				boolean updatechk = bdao.UpdateBoard(board);
				if(updatechk) {
					System.out.println("게시판 수정 성공");
				}else {
					System.out.println("게시판 수정 실패");
				}

				break;
				// 게시판삭제
			case 6 :		
				System.out.print("삭제할 게시판 번호> ");
				String postnumD = sc.nextLine();
				
				board.setBoardpostnum(postnumD);
				
				boolean deletechk = bdao.deleteboard(board);
				if(deletechk) {
					System.out.println("게시판 삭제 성공");
				}else {
					System.out.println("게시판 삭제 실패");
				}

				break;
				// 종료
			case 7 :
				run = false;
			}
		}
		System.out.println("종료");
		sc.close();
	}//
}//