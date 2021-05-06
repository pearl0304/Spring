package kr.co.ch02.sub2;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SamsungTv implements Tv{
	@Autowired // 의존하는 객체를 자동으로 주입해주는 어노테이션 (가장 많이 사용)
	private Speaker speaker;

	@Override
	public void power() {
		System.out.println("SamsungTv power");	
	}

	@Override
	public void chUp() {
		System.out.println("SamsungTv chUp");	
	}

	@Override
	public void chDown() {
		System.out.println("SamsungTv chDown");	
	}

	@Override
	public void soundUp() {
		speaker.soundUp();
		
	}

	@Override
	public void soundDown() {
		speaker.soundDown();
		
	}

}
