package kr.co.ch03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService{
	
	@Autowired
	private LogAdvice log;
	
	//��������Ʈ
	public void insert() { 
		log.beforeLog();
		System.out.println("�ٽɰ��� - insert");
		log.afterLog();
	}
	
	public void select() {
		System.out.println("�ٽɰ��� - select");
	}
	
	public void update() {
		System.out.println("�ٽɰ��� - update");
	}
	
	public void delete() {
		System.out.println("�ٽɰ��� - delete");
	}
}
