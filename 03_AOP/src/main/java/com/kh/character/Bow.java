package com.kh.character;


public class Bow extends Weapon{

	@Override
	public String attack() throws Exception {
		return "활을 쏜다.";
	}
	public Bow() {}
	public Bow(String name) {
		super(name);
	}
}
