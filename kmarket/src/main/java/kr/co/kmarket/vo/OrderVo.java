package kr.co.kmarket.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderVo {

	private int orderId;
	private String uid;
	private int count;
	private int price;	
	private int discount;
	private int delivery;
	private int point;
	private int total;
	private int payment;
	private int complete;
	private String rdate;
	
	//추가 필드  (장바구니 기능 구현)
	private int cate1;
	private int cate2;
	private String thumb1;	
	private int codes[];
}
