package com.kh.dice;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DiceTestApp2 {

	public static void main(String[] args) {
//		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/main/resources/config/dice.xml"));
		ApplicationContext factory = new ClassPathXmlApplicationContext("/config/dice.xml");
		Player player1 = (Player) factory.getBean("player1");
		Player player2 = (Player) factory.getBean("player2");
		Player player3 = (Player) factory.getBean("player3");
		player1.playDice(3);
		System.out.println("========================================");
		System.out.println("선택된 주사위 수의 총 합은 : " + player1.getTotalValue());
		System.out.println("========================================");
		player2.playDice(3);
		System.out.println("========================================");
		System.out.println("선택된 주사위 수의 총 합은 : " + player2.getTotalValue());
		System.out.println("========================================");
		player3.playDice(3);
		System.out.println("========================================");
		System.out.println("선택된 주사위 수의 총 합은 : " + player3.getTotalValue());
		System.out.println("========================================");
	}

}
