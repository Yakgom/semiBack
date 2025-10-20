package com.kh.practice.list.music.compare;

import java.util.Comparator;

import com.kh.practice.list.music.model.vo.Music;

public class DescSinger<T> implements Comparator<T> {

	public int compare(Object o1,Object o2) {
		  Music m1 = (Music) o1;
	        Music m2 = (Music) o2;
	        
	        // 내림차순 정렬
	        return m2.getSinger().compareTo(m1.getSinger());
	}


}
