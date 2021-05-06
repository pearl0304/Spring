package kr.co.ch03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * 
 * ��¥ : 2021/04/13 
 * �̸� : ������
 * ���� : ������ AOP �ǽ��ϱ�
 *
 * ������ AOP (Aspect Oriented Programming)
 * 	-�ٽɰ��ɰ� ��ü�� ����Ǵ� ���� ������ �и��ؼ� ���α׷��� �ϴ� ��� 
 * 
 * ��������Ʈ (JionPoint)
 * 	-�����ϴ� ��� �ٽɰ��� �ż��� (����Ʈ ��)
 * 
 * ����Ʈ�� (PointCut)
 * 	-��������Ʈ ��� ����Ǵ� �ٽ� ���� �޼��� 
 * 
 * �����̽� (Advice)
 * 	-Ⱦ�ܰ��ɿ� �ش��ϴ� ������ �ΰ���� �ż��� 
 * 
 * ������Ʈ(Aspect)
 *	-����Ʈ�ư� �����̽��� ���յ� ������� 
 *
 * ����(Weaving)
 * 	-����Ʈ���� ����ɶ� �����̽��� ����Ʈ�ƿ� ���յǴ� ����
 */
public class AOPMain {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new GenericXmlApplicationContext("spring-context.xml");
		
		BoardService service=(BoardService)ctx.getBean("boardService");
		service.insert();
		service.select();
		service.delete();
	}
}
