package com.kh.statement.view;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import com.kh.statement.controller.VendingController;
import com.kh.statement.model.vo.Vending;

public class VendingView {

    private final Scanner sc = new Scanner(System.in);
    private final VendingController vc = new VendingController();

    public void mainMenu() {
        while(true) {
            System.out.println("======자판기 관리 프로그램======");
            System.out.println("1. 자판기 음료 추가");
            System.out.println("2. 자판기 음료 조회");
            System.out.println("3. 자판기 음료 이름으로 조회");
            System.out.println("4. 키워드로 같은 제조사 음료 조회");
            System.out.println("5. 자판기 재고 수정");
            System.out.println("6. 자판기 음료 삭제");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴를 선택해주세요 > ");

            try {
                int menuNo = sc.nextInt();
                sc.nextLine();
                switch(menuNo) {
                    case 1: save(); break;
                    case 2: findAll(); break;
                    case 3: findByName(); break;
                    case 4: findByKeyword(); break;
                    case 5: update(); break;
                    case 6: delete(); break;
                    case 9:
                        System.out.println("프로그램 종료");
                        return;
                    default: System.out.println("잘못된 번호입니다.");
                }
            } catch(InputMismatchException e) {
                System.out.println("숫자만 입력해주세요");
                sc.nextLine();
            }
        }
    }

    private void save() {
        System.out.println("----자판기에 음료 추가----");

        try {
            System.out.print("추가하실 음료의 이름을 적어주세요 > ");
            String drinkName = sc.nextLine();

            System.out.print("추가하실 음료의 종류를 적어주세요 (탄산,주스,커피,차,물) > ");
            String drinkType = sc.nextLine().trim();
            if (!drinkType.equals("탄산") && !drinkType.equals("주스") && !drinkType.equals("커피")
                    && !drinkType.equals("차") && !drinkType.equals("물")) {
                System.out.println("잘못된 종류를 입력하셨습니다.");
                return;
            }

            System.out.print("추가하실 음료의 가격을 적어주세요 > ");
            int price = sc.nextInt();
            sc.nextLine();
            if(price <= 0){
                System.out.println("가격은 1 이상이어야 합니다.");
                return;
            }

            System.out.print("추가하실 음료의 재고량을 적어주세요 > ");
            int stock = sc.nextInt();
            sc.nextLine();
            if(stock < 0){
                System.out.println("재고량은 0 이상이어야 합니다.");
                return;
            }

            System.out.print("추가하실 음료의 제조일을 적어주세요 (YYYY-MM-DD) > ");
            Date manufactureDate = Date.valueOf(sc.nextLine());

            System.out.print("추가하실 음료의 유통기한을 적어주세요 (YYYY-MM-DD) > ");
            Date expiryDate = Date.valueOf(sc.nextLine());

            System.out.print("추가하실 음료의 제조사를 적어주세요 > ");
            String vendor = sc.nextLine();

            int result = vc.save(drinkName, drinkType, price, stock, manufactureDate, expiryDate, vendor);

            if(result > 0) {
                System.out.println("등록에 성공했습니다.");
            } else {
                System.out.println("등록에 실패했습니다.");
            }

        } catch (InputMismatchException e) {
            System.out.println("숫자를 입력해야 하는 부분에 잘못된 값을 입력했습니다.");
            sc.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("날짜 형식이 올바르지 않습니다. (YYYY-MM-DD 형식으로 입력해주세요)");
        }
    }


    private void findAll() {
        List<Vending> list = vc.findAll();
        if(list.isEmpty()) System.out.println("조회 결과 없음");
        else list.forEach(v -> {
            System.out.println("ID: " + v.getDrinkId() + " 이름: " + v.getDrinkName() + " 재고: " + v.getStock());
        });
    }

    private void findByName() {
        System.out.print("조회할 음료 이름 > "); String name = sc.nextLine();
        Vending v = vc.findByName(name);
        if(v != null) System.out.println("ID: " + v.getDrinkId() + " 이름: " + v.getDrinkName() + " 재고: " + v.getStock());
        else System.out.println("조회 결과 없음");
    }

    private void findByKeyword() {
        System.out.print("제조사 키워드 > "); String vendor = sc.nextLine();
        List<Vending> list = vc.findByKeyword(vendor);
        if(list.isEmpty()) System.out.println("조회 결과 없음");
        else list.forEach(v -> System.out.println(v.getDrinkName() + " / " + v.getVendor() + " / 재고: " + v.getStock()));
    }

    private void update() {
        System.out.print("수정할 음료 이름 > "); String name = sc.nextLine();
        System.out.print("변경할 재고 > "); int stock = sc.nextInt(); sc.nextLine();
        int result = vc.update(name, stock);
        System.out.println(result > 0 ? "재고 수정 성공" : "재고 수정 실패");
    }

    private void delete() {
        System.out.print("삭제할 음료 이름 > "); String name = sc.nextLine();
        System.out.print("제조사 > "); String vendor = sc.nextLine();
        int result = vc.delete(name, vendor);
        System.out.println(result > 0 ? "삭제 성공" : "삭제 실패");
    }
}