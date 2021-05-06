package kr.co.ch03;

import org.springframework.stereotype.Component;

@Component
public class LogAdvice {
	public void beforeLog() {
		System.out.println("========================");
		System.out.println("�ΰ� ��� - beofreLog");
		
	}
	
	public void afterLog() {
		System.out.println("�ΰ� ��� - afterLog");
		System.out.println("========================");
		
	}
	
	public void updateBefore() {
		System.out.println("========================");
		System.out.println("�ΰ� ��� - updateBefore");
	}
	
	public void updateAfter() {
		System.out.println("�ΰ� ��� - updateAfter");
		System.out.println("========================");
	}
	
	public void deleteBefore() {
		System.out.println("========================");
		System.out.println("�ΰ� ��� - deleteBefore");
	}
	
	public void deleteAfter() {
		System.out.println("�ΰ� ��� - deleteAfter");
		System.out.println("========================");
	}
}
