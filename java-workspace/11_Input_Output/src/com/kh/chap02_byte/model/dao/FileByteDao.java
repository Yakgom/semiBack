package com.kh.chap02_byte.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// DAO (Date Access Object)
// 데이터가 보관되어있는 공간에 직접 적근해서
// 입력/출력하는 메소드들을 만들어줌
public class FileByteDao {

	// 파일에 데이터를 출력(Byte Stream사용)
	public void outputToFile() {
		FileOutputStream fos = null;
		// 출력 : 프로그램 내의 데이터를 밖으로 내보내겠다.
		// 프로그램 --> 외부 (파일)
		
		// FileOutputStream : "파일"로 데이터를 출력할 때, 파일과 연결하는 1Byte단위의 스트림
		
		// 1. FileOutputStream 객체 생성
		// 파일과 연결하는 스트림을 생성하는 과정
		try {
			fos = new FileOutputStream("a_byte.txt"/*,true*/);
			// 생성자 호출 시 인자값으로 파일명을 전달하는데 파일명이 존재하지 않을 경우
			// 해당 파일을 생성하면서 통로를 연결
			// 두 번째 인자로 true값을 전달한다면 => 해당 파일 내용에 이어서 작성
			// 안쓰면 => 덮어쓰기
			
			// 2. 연결통로를 가지고 데이터를 출력 : write() 호출
			fos.write(97);
			fos.write(98);
			fos.write(99);
			
			
			byte[] arr = {101,102,103};
			fos.write(arr);
			
			fos.write('A');
			fos.write('B');
			fos.write('C');
			
			fos.write('집');
			fos.write('가');
			fos.write('자');
			
			// 1Byte의 범위 : -128 ~ 127 
			// 한글은 2Byte기 때문에 깨짐
			// 바이트 스트림은 한글 / 일어 / 한자 불가능
			// 문자 스트림을 사용해야 해결이 가능 
			
			// 3. 스트림 사용이 끝났다면 반드시 꼭 무조건 절대로 너무너무 해야하는 작업이 있음
			// 코드상에서 사용이 전부 종료되었다면 자원반납을 해주어야함 <-- 약속
			// 너무 중요한 약속임!!!!!!!!!!!!!!!
			return;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
			
		} finally {
			// 어디에서 return 하던지 무조건 finally 블럭안에 구문을 수행 
			try {
				if(fos != null) {
				fos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	// 프로그램 <== 외부매체(파일)
	// 입력 : 파일로부터 데이터를 가지고 오겠다.
	// FileInputStream
	// 파일로부터 데이터를 가져와서 입력 받을건데,1Byte단위로 입력받겠다.
	public void inputFromFile() {
		
		FileInputStream fis = null; 
		
		try {
			// 1. 객체 생성 => 스트림 연결하기 
			fis = new FileInputStream("a_byte.txt");
			
			// 2. 스트림으로 입력받기
			// read()호출
			// 1Byte단위로 읽어옴
			/*System.out.println((char)fis.read());
			System.out.println(fis.read());
			System.out.println(fis.read());
			System.out.println(fis.read());
			System.out.println(fis.read());
			System.out.println(fis.read());
			System.out.println(fis.read());
			System.out.println(fis.read());
			System.out.println(fis.read());
			System.out.println(fis.read());
			System.out.println(fis.read());
			System.out.println(fis.read());
			System.out.println(fis.read());*/
			//파일의 마지막 데이터를 입력받고 나서 read()를 호출 시 -1을 반환
			
			
			/*while(true) {
				
				int value = fis.read(); 
				
				if(value != -1) {
					System.out.println(value);
				}
				else {
					break;
				}
				
			}*/
			
			int value = 0;
			
			while((value = fis.read()) != -1) {
				
				System.out.println(value);
				
			}
			
			// 3. 마지막으로 꼭 해야할 일
			
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				if(fis != null) {
				fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		
	}
}
