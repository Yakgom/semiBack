package com.kh.hw.controller;

import com.kh.hw.movel.vo.Member;

public class MemberController {
    private Member[] m = new Member[size];
    public final static int size = 10;

    public MemberController() {
		m[0] = new Member("admin","관리자","ad1234","admin@kh.com",'M',100);
	}
    
    public int existMemberNum() {
        int count = 0;
        for(int i =0; i<m.length; i++) {
            if(m[i] != null ) {
                count ++;
            }
        }

        return count;




    }

    public boolean checkId(String id) {
        for (int i = 0; i < m.length; i++) {
            if (m[i] != null && m[i].getId().equals(id)) {
                return false; // 중복 발견
            }
        }
        return true; // 중복 없음
    }

    public void insertMember(String id, String name, String password,
                             String email, char gender, int age) {
        for (int i = 0; i < m.length; i++) {
            if (m[i] == null) { // 비어있는 자리 찾기
                m[i] = new Member(id, name, password, email, gender, age);
                break;
            }
        }
    }

    public String searchId(String id) {
        
        for (int i = 0; i < m.length; i++) {
            if( m[i] != null &&m[i].getId().equals(id)){
                return "찾으신 회원 조회 결과입니다.\n" +m[i].toString();
            }
        }
        return "검색 결과가 없습니다.";
    }

    
    public Member[] searchName(String name) {
    	
    	for(int i=0; i<m.length; i++) {
    		if(m[i] != null && m[i].getName().equals(name)) {
    			System.out.println(m[i].toString());
    		}
    		
    	}
    	return m;
    }
    
    public Member[] searchEmail(String email) {
    	
    	for(int i=0; i<m.length; i++) {
    		if(m[i] != null && m[i].getEmail().equals(email)) {
    			System.out.println(m[i].toString());
    		}
    		
    	}
    	return m;
    }
    
    
    /*
    public String searchName(String name) {
        String result = null;

        for (int i = 0; i < m.length; i++) {
            if (m[i] != null && m[i].getName().equals(name)) {
                if (result == null) {
                    result = "찾으신 회원 조회 결과입니다.\n";
                }
                result += m[i].toString() + "\n";
            }
        }

        return (result != null) ? result : "검색 결과가 없습니다.";
    }*/
    
    /*public String searchEmail(String email) {
        String result = null;

        for (int i = 0; i < m.length; i++) {
            if (m[i] != null && m[i].getEmail().equals(email)) {
                if (result == null) {
                    result = "찾으신 회원 조회 결과입니다.\n";
                }
                result += m[i].toString() + "\n";
            }
        }

        return (result != null) ? result : "검색 결과가 없습니다.";
    }
    
    */

    public boolean updatePassword(String id, String password) {
        for (int i = 0; i < m.length; i++) {
            if (m[i] != null && m[i].getId().equals(id)) {
                m[i].setPassword(password);
                return true;
            }
        }
        return false;
    }

    public boolean updateName(String id, String name) {
        for (int i = 0; i < m.length; i++) {
            if (m[i] != null && m[i].getId().equals(id)) {
                m[i].setName(name);
                return true;
            }
        }
        return false;
    }

    public boolean updateEmail(String id, String email) {
        for (int i = 0; i < m.length; i++) {
            if (m[i] != null && m[i].getId().equals(id)) {
                m[i].setEmail(email);
                return true;
            }
        }
        return false;
    }

    public boolean delete(String id){

        for(int i = 0; i < m.length; i++){

            if(m[i] != null && m[i].getId().equals(id)){
                m[i] = null;
                return true;
            }
        }
        return false;
    }

    public void delete(){
    for(int i = 0; i < m.length; i++){
        m[i] = null;
    }

    }

    public Member[] printAll(){

        return m;
    }



}