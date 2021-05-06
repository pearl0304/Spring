package kr.co.ch03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService{
	
	@Autowired
	private LogAdvice log;
	
	//조인포인트
	public void insert() { 
		log.beforeLog();
		System.out.println("핵심관심 - insert");
		log.afterLog();
	}
	
	public void select() {
		System.out.println("핵심관심 - select");
	}
	
	public void update() {
		System.out.println("핵심관심 - update");
	}
	
	public void delete() {
		System.out.println("핵심관심 - delete");
	}
}
