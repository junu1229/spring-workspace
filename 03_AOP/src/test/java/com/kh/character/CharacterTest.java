package com.kh.character;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class CharacterTest {
	
	@Autowired(required = false)
	private Character character;
	
//	@Test
//	public void test() {
//		System.out.println(character.getLevel());
//		System.out.println(bow.getName());
//		try {
//			character.quest("1번");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	@Test
	void create() {
		assertThat(character).isNotNull();
		assertThat(character.getWeapon()).isNotNull();
	}
	
	@Test
	void questTest() throws Exception {
		assertThat(character.quest("2번 ")).contains("[2번]");
	}
	
	@Test
	void attackTest() throws Exception {
		assertThat(character.getWeapon().attack()).isNotNull();
	}
}
