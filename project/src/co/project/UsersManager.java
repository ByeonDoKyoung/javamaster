package co.project;

import java.util.Scanner;

public class UsersManager {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		UsersDAO dao = new UsersDAO();
		
		while(run) {
			System.out.println("-----------------------------------------");
			System.out.println("1.회원가입 2.로그인 3.글작성 4.수정 5.삭제 6.종료");
			System.out.println("-----------------------------------------");
			System.out.print("선택> ");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch(menu){
			case 1 :
				System.out.println("본인확인을해주세요");
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
				System.out.println("회원가입 완료");
				break;
			case 2 :
				System.out.print("id> ");
				String id = sc.nextLine();
				System.out.print("pw> ");
				String pw = sc.nextLine();
				System.out.println("로그인성공");
				break;
			case 3 :
				System.out.println("---------------------");
				System.out.println("번호 | 제목 | 내용 | 조회수");
				
				
				
				
				System.out.println("---------------------");
				break;
			case 4 :
				System.out.print("수정할 게시판선택> ");	
				sc.nextLine();
				System.out.print("제목> ");
				String title = sc.nextLine();
				System.out.print("내용> ");
				String detail = sc.nextLine();
				
				if(title==null) {
					System.out.println("게시판이 수정되었습니다");
				}else {
					System.out.println("수정 실패");
				}
				break;
			case 5 :
				System.out.print("삭제할 게시판선택> ");
				sc.nextLine();
				System.out.print("제목> ");
				String title1 = sc.nextLine();
				System.out.print("내용> ");
				String detail1= sc.nextLine();
				
				if(title1 == null) {
					System.out.println("게시판이 삭제되었습니다");
				}else {
					System.out.println("삭제 실패");
				}
				break;
			case 6 :		
				run = false;
			}
		}
		System.out.println("종료");
		sc.close();
	}//
}//