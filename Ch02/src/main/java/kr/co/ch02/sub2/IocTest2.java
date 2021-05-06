package kr.co.ch02.sub2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/* ��¥ : 2021/04/12
 * �̸� : ������
 * ���� : DI ������̼��� �̿��� Ioc ����
 */

public class IocTest2 {
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("spring-context.xml");
		Tv ltv =(Tv)ctx.getBean("ltv");
	    Tv stv =(Tv)ctx.getBean("samsungTv");
	     	    
	    System.out.println();
	        
	    ltv.power();
	    ltv.chUp();
	    ltv.soundUp();
	    
	    System.out.println();
	    
	    stv.power();
	    stv.chUp();
	    stv.soundUp();
	}
}
