package kr.co.ch02.sub1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * 날짜 : 2021/04/12
 * 이름 : 이진주
 * 내용 : 스프링 Ioc 실습하기
 * 
 */
public class IocTest1 {

	public static void main(String[] args) {
		
		//Ioc 적용 x (전통적인 자바 객체 생성) 
		Tv ltv = new LgTv();
		ltv.chDown();
		ltv.chUp();
		ltv.power();
		System.out.println();
		
		Tv stv = new SamsungTv();
		stv.power();
		stv.chUp();
		stv.chDown();	
		
		System.out.println();		
		
		//Ioc (Inversion of control) 적용 o (객체 주입) (Dependence Injaction)
		
		//스프링 컨테이너 객체생성  (관리하는 또다른 객체, 객체에 대한 생성 및 생명 주기를 관리)
		ApplicationContext ctx = new GenericXmlApplicationContext("spring-context.xml");
		System.out.println();
		
		Tv lgtv =(Tv)ctx.getBean("lgtv");
		Tv smtv =(Tv)ctx.getBean("smtv");
		
		lgtv.power();
		lgtv.chUp();
		lgtv.chDown();
		
		System.out.println();	
		smtv.power();
		smtv.chUp();
		smtv.chDown();
	}
}
