package com.smile2coder.event;

import com.smile2coder.event.event.UserRegisterEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class EventApplicationTests {

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@Test
	void normal() {
		String name = "tom";
		System.out.println("注册用户：" + name);
		this.applicationEventPublisher.publishEvent(new UserRegisterEvent(name));
	}

	@Test
	void async() {
		String name = "tom";
		System.out.println("注册用户：" + name);
		this.applicationEventPublisher.publishEvent(new UserRegisterEvent(name));

		System.out.println("game over");
		try {
			TimeUnit.SECONDS.sleep(15);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
