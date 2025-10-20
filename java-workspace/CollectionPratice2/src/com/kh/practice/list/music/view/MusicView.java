package com.kh.practice.list.music.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.kh.practice.list.music.MusicController.MusicController;
import com.kh.practice.list.music.model.vo.Music;

public class MusicView {

	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();

	public void mainMenu() {

		while (true) {
			System.out.println("******* 메인메뉴 *******");

			System.out.println("1.마지막 위치에 곡 추가");
			System.out.println("2.첫 위치에 곡 추가");
			System.out.println("3.전체 곡 목록 출력");
			System.out.println("4.특정 곡 검색");
			System.out.println("5.특정 곡 삭제");
			System.out.println("6.특정 곡 정보 수정");
			System.out.println("7.곡명 오름차순 정렬");
			System.out.println("8.가수명 내림차순 정렬");
			System.out.println("9.종료");
			try {
				System.out.print("메뉴 번호 선택 : ");
				int menuNo = sc.nextInt();
				sc.nextLine();
				
				switch (menuNo) {
				case 1: {
					addList();
					break;
				}
				case 2: {
					addAtZero();
					break;
				}
				case 3: {
					printAll();
					break;
				}
				case 4: {
					searchMusic();
					break;
				}
				case 5: {
					removeMusic();
					break;
				}
				case 6: {
					setMusic();
					break;
				}
				case 7: {
					ascTitle();
					break;
				}
				case 8: {
					descSinger();
					break;
				}
				case 9: {
					System.out.println("종료");
					return;
				}

				default: {
					System.out.println("정확한 숫자를 입력해주세요.");
				}
				}
			} catch (InputMismatchException e) {
				System.out.println("번호만 입력해주세요!!!!!!!!");
				sc.nextLine();
			}

		}

	}

	public void addList() {

		System.out.println("******* 마지막 위치에 곡 추가 *******");
		
		System.out.print("곡 명 : ");
		String title = sc.nextLine();
		System.out.print("가수 명 : ");
		String singer = sc.nextLine();
		
		Music music = new Music(title,singer);
		
		int result = mc.addList(music);
		
		if(result == 1) {
			System.out.println("추가 성공");
		}
		else {
			System.out.println("추가 실패(중복된 음악과 가수임)");
		}
		
		
	}

	public void addAtZero() {

		System.out.println("******* 첫 위치에 곡 추가 *******");
		
		System.out.print("곡 명 : ");
		String title = sc.nextLine();
		System.out.print("가수 명 : ");
		String singer = sc.nextLine();
		
		Music music = new Music(title,singer);
		
	int result = mc.addAtZero(music);
		
		if(result == 1) {
			System.out.println("추가 성공");
		}
		else {
			System.out.println("추가 실패(중복된 음악과 가수임)");
		}
		
	}

	public void printAll() {

		List<Music> list = mc.printAll();
		
		if(list.isEmpty()) {
			System.out.println("저장된 곡이 없습니다.");
		}
		else {
		
			System.out.println(list);
			
		}
		
	}

	public void searchMusic() {
		
		System.out.println("검색할 곡을 입력해주세요 > ");
		String searchTitle = sc.nextLine();
		
		Music searchMusic = mc.searchMusic(searchTitle);
		
		
		if(searchMusic != null) {
			System.out.println(searchMusic);
		}
		else {
			System.out.println("검색한 곡이 없습니다.");
		}
		
		
	}

	public void removeMusic() {

		System.out.println("******* 특정 곡 삭제 *******");
		
		System.out.print("삭제할 곡 명 > ");
		String removeTitle = sc.nextLine();
		
		Music music = mc.removeMusic(removeTitle);
		
		if(music != null) {
			System.out.println(music.getTitle()+", "+music.getSinger()+"을 삭제했습니다");
			
		}
		else {
			System.out.println("삭제할 곡이 없습니다.");
		}
		
	}

	public void setMusic() {

		System.out.println("******* 특정 곡 정보 수정 *******");
		
		System.out.print("검색 할 곡 명 > ");
		String searchTitle = sc.nextLine();
		System.out.print("수정할 곡 명 > ");
		String changeTitle = sc.nextLine();
		System.out.print("수정할 가수 명 > ");
		String changeSinger = sc.nextLine();
		
		Music music = mc.searchMusic(searchTitle);
		
	
		Music result = mc.setMusic(searchTitle, music);
		
		if(result != null) {
			
			System.out.println(searchTitle+", "+result.getSinger()+"의 값이 변경 되었습니다."); //“000(곡 명, 가수 명)의 값이 변경 되었습니다.”
			music.setTitle(changeTitle);
			music.setSinger(changeSinger);
			
		}
		else {
			System.out.println("수정할 값이 없습니다.");
		}
		
		
	}

	public void ascTitle() {

		System.out.println("******* 곡 명 오름차순 정렬 *******");
		
		
		
		if(mc.ascTitle()==1) {
			System.out.println("정렬 성공");
		}else {
			System.out.println("정렬 실패");
		}
		
	}

	public void descSinger() {

		System.out.println("******* 가수 명 내림차순 정렬 *******");
		
		if(mc.descSinger()==1) {
			System.out.println("정렬 성공");
		}else {
			System.out.println("정렬 실패");
		}
		
		
		
		
	}

}
