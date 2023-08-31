package com.kh.mvc.model.vo;

import lombok.Getter;
import lombok.Setter;

// page와 amount 값을 같이 전달하는 용도

@Getter
@Setter
public class Criteria {
	
	private int page; // 페이지 번호
	private int amount;
	
	public Criteria() {
		this(1, 10);
	}
	
	public Criteria(int page, int amount) {
		this.page = page;
		this.amount = amount;
	}
}
