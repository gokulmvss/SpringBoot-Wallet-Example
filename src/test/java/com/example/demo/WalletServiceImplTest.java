package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.wallet.Wallet;
import com.example.demo.wallet.WalletException;
import com.example.demo.wallet.WalletRepository;
import com.example.demo.wallet.WalletService;

@SpringBootTest
class WalletServiceImplTest {
	@Autowired
	private WalletService walletservice;
	@Autowired
	private WalletRepository walletrepository;
	
	private Wallet wallet;
	@BeforeEach
	void setupbeforeEachTest() {
		this.wallet = new Wallet(null, "kpmg",5000.0,"examle@gmail.com","asdfgh21@!C", "asdfgh21@!C", null, null, null);
	}
	@AfterEach
	void teardownafterEachTest() {
		this.walletrepository.delete(wallet);
	}
	
	// This is integration testing
	@Test
	void createWalletTest() throws WalletException {
		Wallet savedWallet = this.walletservice.createWallet(wallet);
		assertEquals(wallet.getName(),savedWallet.getName());
		assertEquals(wallet.getBalance(),savedWallet.getBalance());
		assertNotEquals(0,savedWallet.getId());
		assertThat(wallet.getId()).isNotEqualTo(0);
	}
	
	@Test
	void walletAlreadyExistsExceptionTest()throws WalletException{
		this.walletservice.createWallet(wallet);
		assertThrows(WalletException.class,()-> this.walletservice.createWallet(wallet));
	}
	
	@Test
	void walletAlreadyExistsMessageExceptionTest()throws WalletException{
		this.walletservice.createWallet(wallet);
		try {
			this.walletservice.createWallet(wallet);
		}
		catch(WalletException e) {
			assertEquals("Wallet with Wallet email " + wallet.getEmail() + " already exists.",e.getMessage());
		}
		
	}
	
	
}
