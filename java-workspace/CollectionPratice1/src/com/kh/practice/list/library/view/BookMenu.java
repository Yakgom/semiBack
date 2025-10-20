package com.kh.practice.list.library.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.kh.practice.list.library.controller.BookController;
import com.kh.practice.list.library.model.vo.Book;

public class BookMenu {

	private Scanner sc = new Scanner(System.in);

	private BookController bc = new BookController();

	public void mainMenu() {

		System.out.println("== Welcome KH Library ==");

		while (true) {

			System.out.println("******* 메인메뉴 ********");
			System.out.println("1. 새 도서 추가");
			System.out.println("2. 도서 전체 조회");
			System.out.println("3. 도서 검색 조회");
			System.out.println("4. 도서 삭제");
			System.out.println("5. 도서 명 오름차순 정렬");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 선택 : ");

			try {
				int menuNo = sc.nextInt();
				sc.nextLine();

				switch (menuNo) {
				case 1:
					insertBook();
					break;
				case 2:
					selectList();
					break;
				case 3:
					searchBook();
					break;
				case 4:
					deleteBook();
					break;
				case 5:
					ascBook();
					break;
				case 9:
					System.out.println("프로그램을 종료합니다");
					return;
				default:
					System.out.println("잘못 입력하였습니다. 다시 입력해주세요");
				}
			} catch (InputMismatchException e) {
				System.out.println("숫자만 입력해주세요");
				sc.nextLine();
			}

		}

	}

	public void insertBook() {
		String category = "";
		int price;
		System.out.print("도서명을 입력해주세요 > ");
		String title = sc.nextLine();
		System.out.print("저자명을 입력해주세요 > ");
		String author = sc.nextLine();

		while (true) {
			try {
				System.out.print("장르를 입력해주세요(1.인문 /2.자연과학 / 3.의료 / 4. 기타 > ");
				int categoryNum = sc.nextInt();
				sc.nextLine();

				

				switch (categoryNum) {
				case 1:
					category = "인문";
					break;
				case 2:
					category = "자연과학";
					break;
				case 3:
					category = "의료";
					break;
				case 4:
					category = "기타";
					break;

				default:
					System.out.println("표시된 숫자중 하나를 입력해주세요");
					continue;

				}
				break;
			} catch (InputMismatchException e) {
				System.out.println("숫자만 입력해주세요!");
				sc.nextLine();
			}

		}

		while (true) {
			try {
				System.out.print("가격을 입력해주세요 > ");
				price = sc.nextInt();
				sc.nextLine();
				break;
			} catch (InputMismatchException e) {
				System.out.println("숫자만 입력해주세요!");
				sc.nextLine();
			}
		}
		
		Book book = new Book(title,author,category,price);
		
		bc.insertBook(book);
		
		

	}

	public void selectList() {

		ArrayList<Book> bookList = bc.selectList();
		
		System.out.println("===== 도서 전체 조회 =====");
		if (bookList.isEmpty()) {
			System.out.println("존재하는 도서가 없습니다.");
		}
		else {
			for(Book b : bookList) {
				System.out.println("\t"+b);
			}
		}
		System.out.println();
		
		
	}

	public void searchBook() {

		System.out.print("검색할 도서명을 적어주세요 > ");
		String keyword = sc.nextLine();
		
		ArrayList<Book> searchList = bc.searchBook(keyword);
		
		if(searchList.isEmpty()) {
			System.out.println("결과 검색이 없습니다.");
		}
		else {
			for(Book b : searchList) {
				System.out.println(b);
			}
		}
		
	}

	public void deleteBook() {

		selectList();
		
		System.out.print("삭제할 도서명을 적어주세요 > ");
		String title = sc.nextLine();
		System.out.print("삭제할 저자명을 적어주세요 > ");
		String author = sc.nextLine();
		
		Book remove = bc.deleteBook(title, author);
		
		if(remove != null) {
			System.out.println("성공적으로 삭제되었습니다.");
		}
		else {
			System.out.println("삭제할 도서를 찾지 못했습니다.");
		}
		
		
	}

	public void ascBook() {
		int result = bc.ascBook();
		
		if(result == 1) {
			System.out.println("정렬에 성공하셨습니다.");
		}
		else {
			System.out.println("정렬에 실패하였습니다.");
		}
		
		
	}

}
