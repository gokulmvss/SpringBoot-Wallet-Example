package com.example.demo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WalletApplicationTests {

	@BeforeAll
	void setupForAllTestCases() {
		System.out.println("setupForAllTestCases");
	}
	@BeforeAll
	void setupForBeforeTestCases() {
		System.out.println("setupForbeforeTestCases");
	}
	
	@Test
	void contextLoads() {
	}

}
