package com.kh.chap05.constructor.run;

import java.util.Scanner;

import com.kh.chap05.constructor.model.vo.Fishing;

public class FishingRun {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Fishing fishing = new Fishing();

		System.out.println("낚시 프로그램");

		System.out.print("낚시한 장소 > ");
		fishing.setLocation(sc.nextLine());
		System.out.print("낚은 물고기 종류 > ");
		fishing.setFishType(sc.nextLine());
		System.out.print("총 낚은 물고기 개수 > ");
		fishing.setTotalFishCount(sc.nextInt());
		sc.nextLine();
		System.out.print("총 낚시 시간(분) > ");
		fishing.setFishingTime(sc.nextInt());
		sc.nextLine();
		System.out.print("미끼를 씁니까? (Y/N) > ");
		char ch = sc.next().charAt(0);
		if (ch == 'y' || ch == 'Y') {
			fishing.setHasBait(true);
		} else {
			fishing.setHasBait(false);
		}

		boolean exit = false;
		while (!exit) {
			System.out.println();
			System.out.println("🎣🎣🎣🎣🎣🎣🎣🎣🎣🎣🎣🎣🎣🎣🎣🎣🎣");
			System.out.println("현재 장소 : " + fishing.getLocation());
			System.out.println("낚은 물고기 종류 : " + fishing.getFishType());
			System.out.println("낚은 물고기 개수 : " + fishing.getTotalFishCount());
			System.out.println("총 낚시 시간 : " + fishing.getFishingTime() + "분");
			if (fishing.getHasBait()) {
				System.out.println("미끼 여부 : " + "O");
			} else {
				System.out.println("미끼 여부 : " + "X");
			}
			System.out.println("🎣🎣🎣🎣🎣🎣🎣🎣🎣🎣🎣🎣🎣🎣🎣🎣🎣");

			System.out.println("1.낚시하기 / 2.종료");
			System.out.print("어떤것을 합니까 ? > ");

			int menuNo = sc.nextInt();
			switch (menuNo) {
			case 1:
				fishing.catchFishing();
				break;
			case 2:
				exit = true;
				System.out.println("집에 돌아갑니다.");
				break;
			}

		}

	}

}