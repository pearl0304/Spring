package kr.co.ch02.sub2;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

@Component
public class Speaker {
	public void soundUp() {
		System.out.println("Speaker soundUp");	
	}
	public void soundDown() {
		System.out.println("Speaker soundDown");		
	}
	
}
