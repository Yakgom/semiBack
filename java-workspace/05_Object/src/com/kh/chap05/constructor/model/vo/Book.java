package com.kh.chap05.constructor.model.vo;

import java.util.Scanner;

public class Book {
    private String title;
    private String author;
    private int totalPages;
    private int page=0;
    private String genre;
    private String language;

    
    public Book() {
    	
    }
    
    public Book(String title, String author , int totalPages , int page , String genre , String language) {
    	this.title = title;
    	this.author = author;
    	this.totalPages = totalPages;
    	this.page = page;
    	this.genre = genre;
    	this.language = language;
    }
    
    
    public void setTitle(String title) {
    	this.title = title;
    }
    
    public void setAuthor(String author) {
    	this.author = author;
    }
    
    public void setTotalPages(int totalPages) {
    	this.totalPages = totalPages;
    }
    
    public void setPage(int page) {
    	this.page = page;
    }
    
    public void setGenre(String genre) {
    	this.genre = genre;
    }
    
    public void setLanguage(String language) {
    	this.language = language;
    }
    
    public String getTitle() {
    	return title;
    }
    
    public String getAuthor() {
    	return author;
    }
    
    public int getTotalPages() {
    	return totalPages;
    }
    
    public int getPage() {
    	return page;
    }
    
    public String getGenre() {
    	return genre;
    }
    
    public String getLanguage() {
    	return language;
    }
    
    
    
    

    public void changeLanguage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("현재 언어 : " + language);
        System.out.print("바꾸실 책의 언어를 정해주세요 > " );
        language = sc.nextLine();
        System.out.println("책의 언어가 : "+ language +"로 변경되었습니다.");
    }
    public void readBook(){
        page += 15;
        if(page >= totalPages){
            System.out.println("책을 전부 읽었습니다.");
            page=totalPages;
        }
    }

    public String info() {
    	return "title : " + title + "author : " + author + "totalPages : " + totalPages 
    			+"page : " + page + "genre : " + genre + "language : " + language ;
    }


}