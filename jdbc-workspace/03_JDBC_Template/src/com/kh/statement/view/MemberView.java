package com.kh.statement.view;

import java.util.List;
import java.util.Scanner;

import com.kh.board.view.BoardView;
import com.kh.statement.controller.MemberController;
import com.kh.statement.model.vo.Member;

/**
 * MemberView 클래스는 JDBC 실습을 위해 생성하였으며, 사용자에게 입력 및 출력을 수행하는 메소드를 제공합니다.
 * 
 * 
 * 
 * 
 * @author 홍길동
 * @version 0.1
 * @date 2025-09-01
 */
public class MemberView {

	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();

	/**
	 * 프로그램 구동 시 사용자에게 메인화면을 출력해주는 메소드입니다.
	 */
	public void mainMenu() {

		while (true) {

			System.out.println(" ---- 회원 관리 프로그램 ---- ");
			System.out.println("1. 회원 추가");
			System.out.println("2. 회원 전체 조회");
			System.out.println("3. 회원 아이디로 조회");
			System.out.println("4. 회원 이름 키워드로 조회");
			System.out.println("5. 회원 정보 변경");
			System.out.println("6. 회원 탈퇴");
			System.out.println("7. 게시판 서비스로 이동");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴를 선택해 주세요 > ");
			int menuNo = sc.nextInt();
			sc.nextLine();

			switch (menuNo) {
			case 1:
				save();
				break;
			case 2:
				findAll();
				break;
			case 3:
				findById();
				break;
			case 4:
				findByKeyword();
				break;
			case 5:
				update();
				break;
			case 6:
				delete();
				break;
			case 7:
				new BoardView().mainMenu();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못된 메뉴 선택입니다.");

			}

		}
	}

	/**
	 * MEMBER 테이블에 INSERT할 값을 사용자가 입력받는 화면을 출력해주는 메소드
	 * 
	 * 컬럼에 INSERT할 값들을 모두 입력받은 후 입력받은 값 컨트롤러로 전달
	 */
	private void save() {

		System.out.println("--- 회원 추가 ---");

		System.out.print("아이디를 입력해주세요 > ");
		String userId = sc.nextLine();
		System.out.print("비밀번호를 입력해주세요 > ");
		String userPwd = sc.nextLine();
		System.out.print("성함을 입력해주세요 > ");
		String userName = sc.nextLine();
		System.out.print("이메일을 입력해주세요 > ");
		String email = sc.nextLine();

		// 일단 View에서 할 일은 끝남

		int result = mc.save(userId, userPwd, userName, email);

		if (result > 0) {
			System.out.println("회원 가입에 성공했습니다.");
		} else {
			System.out.println("회원 가입에 실패했습니다.");
		}

	}

	/**
	 * 회원 전체 조회 요청 시 Member 테이블에 존재하는 모든 회원의 정보를 출력하는 메소드
	 */
	private void findAll() {

		System.out.println("\n회원 전체 조회");

		// 데이터 좀.. Controller에게 회원들의 데이터 값 요청
		List<Member> members = mc.findAll();

		// 뷰에서 2절
		System.out.println("\n조회된 총 회원수는 " + members.size() + "명 입니다.");
		if (!members.isEmpty()) {

			for (Member member : members) {
				System.out
						.println("===================================================================================");
				System.out.println(member.getUserNO() + "번 회원의 정보");
				System.out.print("아이디 : " + member.getUserId() + ", ");
				System.out.print("비밀번호 : " + member.getUserPwd() + ", ");
				System.out.print("이름 : " + member.getUserName() + ", ");
				System.out.print("이메일 : " + member.getEmali() + ", ");
				System.out.print("가입일 : " + member.getEnrollDate() + "\n");
				System.out.println();

			}

		} else {
			System.out.println("조회결과가 존재하지 않습니다.");
		}

	}

	/**
	 * 사용자로부터 회원의 아이디를 입력받아서 Member테이블로부터 아이디값을 비교해서 조회한 뒤 동일한 아이디값을 가진 행의 데이터를
	 * 출력해주는 메소드
	 */
	private void findById() {

		System.out.println("\n아이디로 검색 서비스입니다.");
		System.out.print("아이디를 입력해주세요.");
		String userId = sc.nextLine();
		
		Member member = mc.findById(userId);
		// 1. 조회결과가 존재하지 않을 경우 == null
		// 2. 조회결과가 존재할 경우      == Member 객체의 주소 값
		
		/*
		 * 자바에서 값의 종류
		 * 정수 = byte,short,int,long
		 * 실수 = float , double
		 * 문자 = char
		 * 논리값 = boolean
		 * 
		 * 
		 * 주소값 = 나머지
		 * 
		 */
		
		
		if(member != null) {
			System.out.println(userId + "님의 검색 결과입니다.");
			System.out.println("===================================================");
			System.out.print("아이디 : " + member.getUserId() + ", ");
			System.out.print("비밀번호 : " + member.getUserPwd() + ", ");
			System.out.print("이름 : " + member.getUserName() +", ");
			System.out.print("이메일 : "+ member.getEmali()+", ");
			System.out.print("가입일 : " + member.getEnrollDate());
			System.out.println();
		}
		else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
		
		
	}
	
	private void findByKeyword() {
		
		System.out.println("\n회원 이름 키워드로 검색");
		System.out.print("검색하고자하는 키워드를 적어주세요 >");
		String keyword = sc.nextLine();
		
		List<Member> members = mc.findByKeyword(keyword);
		
		// 뷰에서는 뭘 해줘야 할까요?

		if(members.isEmpty()) {
			System.out.println("조회결과가 없습니다.");
		}
		else {
			members.stream().forEach(m ->{

				System.out.println("===================================================");
				System.out.print("아이디 : " + m.getUserId() + ", ");
				System.out.print("비밀번호 : " + m.getUserPwd() + ", ");
				System.out.print("이름 : " + m.getUserName() +", ");
				System.out.print("이메일 : "+ m.getEmali()+", ");
				System.out.print("가입일 : " + m.getEnrollDate());
				System.out.println();
				
				
			}
			);
			
		}
		
	}
	
	private void update() {
		
		System.out.println("\n회원 정보 수정 서비스입니다.");
		
		// 아이디랑 비밀번호랑 새 비밀번호 받아서
		// 아이디랑 비밀번호가 있는거 있으면 새 비밀번호로 바꾸기
		System.out.print("아이디를 입력해주세요 > ");
		String userId = sc.nextLine();
		System.out.print("비밀번호를 입력해주세요 >");
		String userPwd = sc.nextLine();
		System.out.print("새 비밀번호를 입력해주세요 > ");
		String newPassword = sc.nextLine();
		
		int result = mc.update(userId,userPwd,newPassword);
		
		if(result > 0) {
			System.out.println("비밀번호 변경에 성공");
		}else {
			System.out.println("비밀번호 변경 실패");
		}
		
		
	}
	
	private void delete() {
		
		System.out.println("\n회원 삭제 서비스입니다.");
		
		System.out.print("아이디를 입력하세요 > ");
		String userId=sc.nextLine();
		System.out.print("비밀번호를 입력하세요 > ");
		String userPwd = sc.nextLine();
		
		int result = mc.delete(userId,userPwd);
		
		
		if(result > 0 ) {
			System.out.println("성공했습니다");
		}
		else {
			System.out.println("실패했습니다");
		}
	}

}
