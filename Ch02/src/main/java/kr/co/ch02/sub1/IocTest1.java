package kr.co.ch02.sub1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * ��¥ : 2021/04/12
 * �̸� : ������
 * ���� : ������ Ioc �ǽ��ϱ�
 * 
 */
public class IocTest1 {

	public static void main(String[] args) {
		
		//Ioc ���� x (�������� �ڹ� ��ü ����) 
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
		
		//Ioc (Inversion of control) ���� o (��ü ����) (Dependence Injaction)
		
		//������ �����̳� ��ü����  (�����ϴ� �Ǵٸ� ��ü, ��ü�� ���� ���� �� ���� �ֱ⸦ ����)
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
