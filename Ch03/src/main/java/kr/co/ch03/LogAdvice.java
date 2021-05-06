package kr.co.ch03;

import org.springframework.stereotype.Component;

@Component
public class LogAdvice {
	public void beforeLog() {
		System.out.println("========================");
		System.out.println("부가 기능 - beofreLog");
		
	}
	
	public void afterLog() {
		System.out.println("부가 기능 - afterLog");
		System.out.println("========================");
		
	}
	
	public void updateBefore() {
		System.out.println("========================");
		System.out.println("부가 기능 - updateBefore");
	}
	
	public void updateAfter() {
		System.out.println("부가 기능 - updateAfter");
		System.out.println("========================");
	}
	
	public void deleteBefore() {
		System.out.println("========================");
		System.out.println("부가 기능 - deleteBefore");
	}
	
	public void deleteAfter() {
		System.out.println("부가 기능 - deleteAfter");
		System.out.println("========================");
	}
}
