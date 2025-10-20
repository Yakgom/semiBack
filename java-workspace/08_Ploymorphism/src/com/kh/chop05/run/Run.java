package com.kh.chop05.run;

import com.kh.chop05.model.vo.Hiphop;
import com.kh.chop05.model.vo.Jazz;
import com.kh.chop05.model.vo.MusicI;


public class Run {

	public static void main(String[] args) {
		
		MusicI hiphop = new Hiphop();
		MusicI jazz = new Jazz();
		hiphop.play();
		hiphop.stop();
		jazz.play();
		jazz.stop();
	}
	

	
	
	
}
