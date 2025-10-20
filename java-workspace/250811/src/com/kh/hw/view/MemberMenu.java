package com.kh.hw.view;



import java.util.Scanner;

import com.kh.hw.controller.MemberController;
import com.kh.hw.movel.vo.Member;


public class MemberMenu {
    private Scanner sc = new Scanner(System.in);
    private MemberController mc = new MemberController();

    // 초기화 블럭 2순위
    {
    	// 여기에 초기화 하고싶은걸 넣으면 됨
    	
    }
    
    // static 블럭 1순위
    static{
    	// 클래스가 올라갈때 딱 한번만 수행됨
    	
    }
    // 생성자 3순위 
    public MemberMenu() {}


    public void mainMenu() {
        while (true) {
            System.out.println("최대 등록 가능한 회원 수는 " + mc.size + "명입니다.");
            System.out.println("현재 등록된 회원 수는 " + mc.existMemberNum() + "명입니다.");

            if (mc.existMemberNum() != 10) {
                System.out.println("1. 새 회원 등록");
                System.out.println("2. 회원 검색");
                System.out.println("3. 회원 정보 수정");
                System.out.println("4. 회원 삭제");
                System.out.println("5. 모두 출력");
                System.out.println("9. 끝내기");

                System.out.print("메뉴 번호 : ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1: insertMember(); break;
                    case 2: searchMember(); break;
                    case 3: updateMember(); break;
                    case 4: deleteMember(); break;
                    case 5: printAll(); break;
                    case 9: System.out.println("프로그램을 종료합니다"); return;
                    default:
                        System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
                }

            } else {
                System.out.println("회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈됩니다.");
                System.out.println("2. 회원 검색");
                System.out.println("3. 회원 정보 수정");
                System.out.println("4. 회원 삭제");
                System.out.println("5. 모두 출력");
                System.out.println("9. 끝내기");
                System.out.print("메뉴 번호 : ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 2: searchMember(); break;
                    case 3: updateMember(); break;
                    case 4: deleteMember(); break;
                    case 5: printAll(); break;
                    case 9: System.out.println("프로그램을 종료합니다"); return;
                    default:
                        System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
                }


            }


        }


    }

    public void insertMember() {
        System.out.println("새 회원을 등록합니다.");
        String id;
        while(true) {

            System.out.print("아이디 : ");
            id = sc.nextLine();
            if(!mc.checkId(id)){
                System.out.println("중복된 아이디입니다. 다시 입력해주세요");
            }
            else{
                break;
            }
        }
        System.out.print("이름 : " );
        String memberName = sc.nextLine();
        System.out.print("비밀번호 : "  );
        String password = sc.nextLine();
        System.out.print("이메일 : ");
        String memberEmail = sc.nextLine();

        char gender;
        while(true) {
            System.out.print("성별(M/F) : ");
            gender = sc.nextLine().charAt(0);
            if(gender == 'M' || gender == 'm') {
                gender = 'M';
                break;
            }
            else if(gender == 'F' || gender == 'f') {
                gender = 'F';
                break;
            }
            else{
                System.out.println("성별을 다시 입력하세요.");
            }
        }
        System.out.print("나이 : ");
        int age = sc.nextInt();
        sc.nextLine();





       mc.insertMember(id,memberName,password,memberEmail,gender,age);

    }

    public void searchMember(){
        System.out.println("1. 아이디로 검색하기\n");

        System.out.println("2. 이름으로 검색하기\n");
        System.out.println("3. 이메일로 검색하기\n");
        System.out.println("9. 메인으로 돌아가기\n");

        System.out.print("메뉴 번호 : ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1: searchId(); break;
            case 2: searchName(); break;
            case 3: searchEmail(); break;
            case 9: System.out.println("메인으로 돌아갑니다."); break;
            default: System.out.println("잘못 입력하셨습니다.");break;
        }


    }

    public void searchId(){
        System.out.print("검색할 아이디 : ");
        String id = sc.nextLine();

        System.out.println(mc.searchId(id));
    }

    public void searchName(){
        System.out.print("검색할 이름 : ");
        String name = sc.nextLine();

        mc.searchName(name);
        
    }

    public void searchEmail(){
        System.out.print("검색할 이메일 : ");
        String email = sc.nextLine();

        mc.searchEmail(email);
    }

    public void updateMember() {
        System.out.println("1. 비밀번호 수정하기\n");
        System.out.println("2. 이름 수정하기\n");
        System.out.println("3. 이메일 수정하기\n");
        System.out.println("9. 메인으로 돌아가기\n");

        System.out.print("메뉴 번호 : ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1: updatePassword(); break;
            case 2: updateName(); break;
            case 3: updateEmail(); break;
            case 9: System.out.println("메인으로 돌아갑니다."); break;
            default: System.out.println("잘못 입력하셨습니다.");break;
        }


    }

    public void updatePassword() {

    System.out.print("수정할 회원의 아이디 : ");
    String id = sc.nextLine();
    System.out.print("수정할 비밀번호 : ");
    String password = sc.nextLine();

    if(mc.updatePassword(id,password)){
       System.out.println("수정이 성공적으로 되었습니다.");
    }
    else{
        System.out.println("존재하지 않는 아이디입니다.");
    }

    }

    public void updateName(){

        System.out.print("수정할 회원의 아이디 : ");
        String id = sc.nextLine();
        System.out.print("수정할 이름 : ");
        String name = sc.nextLine();

        if(mc.updateName(id,name)){
            System.out.println("수정이 성공적으로 되었습니다.");
        }
        else{
            System.out.println("존재하지 않는 아이디입니다.");
        }

    }

    public void updateEmail(){

        System.out.print("수정할 회원의 아이디 : ");
        String id = sc.nextLine();
        System.out.print("수정할 이메일 : ");
        String email = sc.nextLine();

        if(mc.updateEmail(id,email)){
            System.out.println("수정이 성공적으로 되었습니다.");
        }
        else{
            System.out.println("존재하지 않는 아이디입니다.");
        }

    }

    public void deleteMember() {
        System.out.println("1. 특정 회원 삭제하기\n");
        System.out.println("2. 모든 회원 삭제하기\n");
        System.out.println("9. 메인으로 돌아가기\n");

        System.out.print("메뉴 번호 : ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1: deleteOne(); break;
            case 2: deleteAll(); break;
            case 9: System.out.println("메인으로 돌아갑니다."); break;
            default: System.out.println("잘못 입력하셨습니다.");break;
        }
    }

    public void deleteOne(){
        System.out.print("삭제할 회원의 아이디 : ");
        String id = sc.nextLine();
        System.out.print("정말 삭제하시겠습니까?(y/n) ");
        char choice = sc.nextLine().charAt(0);

        if(choice == 'y' || choice == 'Y'){
            if(mc.delete(id)) {
                System.out.println("회원이 삭제되었습니다.");
                //mc.size++;
            } else {
                System.out.println("존재하지 않는 아이디입니다.");
            }
        } else if(choice == 'n' || choice == 'N'){
            System.out.println("취소를 선택하셨습니다.");
        }
    }







    public void deleteAll(){
        System.out.print("정말 삭제하시겠습니까?(y/n) ");
        char choice = sc.nextLine().charAt(0);
        if(choice == 'y' || choice == 'Y'){
            mc.delete();
            System.out.println("성공적으로 삭제하였습니다.");
           
            }
         else if(choice == 'n' || choice == 'N'){
            System.out.println("취소를 선택하셨습니다.");
        }

    }

    public void printAll(){
        Member[] members = mc.printAll();
        boolean hasMember = false;

        for(int i = 0; i < members.length; i++){
            if(members[i] != null){
                hasMember = true;
                System.out.println(members[i].toString());
            }
        }
        if(!hasMember){
            System.out.println("저장된 회원이 없습니다.");
        }
    }

}