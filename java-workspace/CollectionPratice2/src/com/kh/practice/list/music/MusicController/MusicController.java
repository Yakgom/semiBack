package com.kh.practice.list.music.MusicController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kh.practice.list.music.compare.DescSinger;
import com.kh.practice.list.music.model.vo.Music;

public class MusicController  {

	private List<Music> music = new ArrayList();

	public int addList(Music music) {

		for (int i = 0; i < this.music.size(); i++) {
			if (this.music.get(i).getTitle().equals(music.getTitle())
					&& this.music.get(i).getSinger().equals(music.getSinger())) {

				return 0;

			}

		}
		this.music.addLast(music);
		return 1;

	}

	public int addAtZero(Music music) {

		for (int i = 0; i < this.music.size(); i++) {
			if (this.music.get(i).getTitle().equals(music.getTitle())
					&& this.music.get(i).getSinger().equals(music.getSinger())) {

				return 0;

			}

		}
		this.music.addFirst(music);
		return 1;

	}

	public List<Music> printAll() {

		List<Music> list = music;

		return list;
	}

	public Music searchMusic(String title) {

		Music searchMusic = new Music();

		for (Music m : music) {
			if (m.getTitle().equals(title)) {
				searchMusic = m;
				return searchMusic;
			}

		}
		return null;
	}

	public Music removeMusic(String title) {

		Music music1 = new Music();

		for (int i = 0; i < music.size(); i++) {
			if (music.get(i).getTitle().equals(title)) {
				music1 = music.get(i);
				music.remove(i);
				return music1;

			}
		}

		return null;
	}

	public Music setMusic(String title, Music music) {

		Music music1 = music;

		for (int i = 0; i < this.music.size(); i++) {
			
			if (this.music.get(i).getTitle().equals(music.getTitle())
					&& this.music.get(i).getSinger().equals(music.getSinger())) {
				System.out.println("동일한 곡명과 가수명이 있어서 수정이 불가능합니다.");
				return null;
			}
			
			if (this.music.get(i).getTitle().equals(title) ) 
			{
				
				this.music.get(i).setTitle(music.getTitle());
				this.music.get(i).setSinger(music.getSinger());
				music1 = this.music.get(i);
				return music1;

			}
		}
		return null;

	}

	public int ascTitle() {
		
		Collections.sort(music);
		return 1;
	}

	public int descSinger() {
		
		DescSinger<Music> descSinger = new DescSinger<>();

	    for (int i = 0; i < music.size() - 1; i++) {
	        for (int j = i + 1; j < music.size(); j++) {
	            // Comparator로 비교
	            if (descSinger.compare(music.get(i), music.get(j)) > 0) {
	                // 위치 교환
	                Music temp = music.get(i);
	                music.set(i, music.get(j));
	                music.set(j, temp);
	            }
	        }
	    }

	    return 1; // 정렬 완료
	}

}
