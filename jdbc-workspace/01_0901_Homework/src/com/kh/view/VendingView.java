package com.kh.view;


import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.kh.controller.VendingController;
import com.kh.model.vo.Vending;

/**
 *
 * 2025-09-01 실습겸 숙제
 *
 *
 */
public class VendingView {

    private final Scanner sc = new Scanner(System.in);
    private final VendingController vc = new VendingController();

    public void mainMenu() {

        while (true) {

            System.out.println("======자판기 관리 프로그램======");
            System.out.println("1. 자판기 음료 추가");
            System.out.println("2. 자판기 음료 조회");
            System.out.println("3. 자판기 음료 이름으로 조회");
            System.out.println("4. 키워드로 같은 제조사 음료 조회");
            System.out.println("5. 자판기 정보 변경");
            System.out.println("6. 자판기 음료 삭제");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴를 선택해주세요 > ");
            try {
                int menuNo = sc.nextInt();
                sc.nextLine();
                switch (menuNo) {
                    case 1: {
                        save();
                        break;
                    }
                    case 2: {
                        findAll();
                        break;
                    }

                    case 3: {
                        findByName();
                        break;
                    }
                    case 4: {
                        findByKeyword();
                        break;
                    }
                    case 5: {
                    	
                    	break;
                    }
                    case 6:{
                    	
                    	break;
                    }

                    case 9: {
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    }
                    default: {
                        System.out.println("잘못된 번호입니다.");
                    }

                }
            }catch (InputMismatchException e) {
                System.out.println("숫자만 입력해주세요");
                sc.nextLine();
            }
            }


    }


    private void save() {




        System.out.println("----자판기에 음료 추가----");

        try {
            System.out.print("추가하실 음료의 이름을 적어주세요 > ");
            String drinkId = sc.nextLine();

            System.out.print("추가하실 음료의 종류를 적어주세요 (탄산,주스,커피,차,물) > ");
            String drinkType = sc.nextLine();
            if (!drinkType.equals("탄산")
                    && !drinkType.equals("커피")
                    && !drinkType.equals("차")
                    && !drinkType.equals("물")
                    && !drinkType.equals("주스")) {

                System.out.println("잘못된 종류를 입력하셨습니다");
                return;
            }

            System.out.print("추가하실 음료의 가격을 적어주세요 > ");
            int price = sc.nextInt();
            sc.nextLine(); // 개행 제거
            if(price <= 0){
                System.out.println("잘못된 가격 입니다.");
                return;
            }

            System.out.print("추가하실 음료의 재고량을 적어주세요 > ");
            int stock = sc.nextInt();
            sc.nextLine();
            if(stock <= 0){
                System.out.println("잘못된 재고량 입니다");
                return;
            }

            System.out.print("추가하실 음료의 제조일을 적어주세요 (YYYY-MM-DD) > ");
            Date manufactureDate = Date.valueOf(sc.nextLine());

            System.out.print("추가하실 음료의 유통기한을 적어주세요 (YYYY-MM-DD) > ");
            Date expiryDate = Date.valueOf(sc.nextLine());

            System.out.print("추가하실 음료의 제조사를 적어주세요 > ");
            String vendor = sc.nextLine();

            System.out.println("음료 추가 완료!");


            int result =  vc.save(drinkId,drinkType,price,stock,manufactureDate,expiryDate,vendor);

            if (result > 0) {
                System.out.println("등록에 성공했습니다.");
            }
            else{
                System.out.println("등록에 실패했습니다.");
            }


        } catch (InputMismatchException e) {
            System.out.println(" 숫자를 입력해야 하는 부분에 잘못된 값을 입력했습니다.");
            sc.nextLine(); // 입력 버퍼 정리
        } catch (IllegalArgumentException e) {
            System.out.println(" 날짜 형식이 올바르지 않습니다. (YYYY-MM-DD 형식으로 입력해주세요)");
        }





    }

    private void findAll() {

        System.out.println("\n자판기 전체 조회");

        List<Vending> vendings = vc.findAll();

        if (!vendings.isEmpty()) {
            vendings.stream().forEach(v -> {
                         System.out.println("음료ID : " + v.getDrinkId());
                        System.out.println("음료이름 : " + v.getDrinkName());
                        System.out.println("음료종류 : " + v.getDrinkType());
                        System.out.println("음료가격 : " + v.getPrice());
                        System.out.println("음료 재고 : " + v.getStock());
                        System.out.println("음료 제조일 : " + v.getManufactureDate());
                        System.out.println("음료 유통기한 : "+ v.getExpiryDate());
                        System.out.println("음료 제조사 : " + v.getVendor());
                        System.out.println("=========================================================");
            }

               );



        }
        else{
            System.out.println("조회결과가없습니다.");
        }

    }

    private void findByName(){

        System.out.print("조회할 음료명을 입력해주세요 > ");
        String drinkName = sc.nextLine();

       Vending vending =  vc.findByName(drinkName);

        System.out.println("음료ID : " + vending.getDrinkId());
        System.out.println("음료이름 : " + vending.getDrinkName());
        System.out.println("음료종류 : " + vending.getDrinkType());
        System.out.println("음료가격 : " + vending.getPrice());
        System.out.println("음료 재고 : " + vending.getStock());
        System.out.println("음료 제조일 : " + vending.getManufactureDate());
        System.out.println("음료 유통기한 : "+ vending.getExpiryDate());
        System.out.println("음료 제조사 : " + vending.getVendor());


    }

    private void findByKeyword(){

        System.out.println("키워드로 조회 서비스입니다.");

        System.out.print("조회할 제조사의 키워드를 입력해주세요 > ");
        String vendor = sc.nextLine();

        List<Vending> vendings = vc.findByKeyword(vendor);
        if (!vendings.isEmpty()) {
            for(Vending v : vendings){
                System.out.println("음료 ID : "+v.getDrinkId());
                System.out.println("음료 이름 :"+v.getDrinkName());
                System.out.println("음료 종류 : "+v.getDrinkType());
                System.out.println("음료 가격 : "+v.getPrice());
                System.out.println("음료 재고량 : "+v.getStock());
                System.out.println("음료 제조일 : "+v.getManufactureDate());
                System.out.println("음료 유통기한 : "+v.getExpiryDate());
                System.out.println("음료 제조사 : "+v.getVendor());
                System.out.println("=========================================================");


            }

        }
        else{
            System.out.println("조회결과가 없습니다.");
        }


    }
}
