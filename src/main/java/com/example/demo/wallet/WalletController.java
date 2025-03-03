package com.example.demo.wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {
	@Autowired
	private WalletService walletService;
	
	@PostMapping("/createwallet")
	public Wallet AddWallet(@RequestBody Wallet walet) {
		return this.walletService.createWallet(walet);
	}
	
	@GetMapping("/wallet/{id}")
	public Wallet getWalletById(@PathVariable("id") Integer id) throws WalletException {
		return this.walletService.getWalletById(id);
	}
	
	@GetMapping("/wallet/addMoney/{id}/{amount}")
	public Double addFunds(@PathVariable("id") Integer id,@PathVariable("amount") Double amount) {
		return this.walletService.addFunds(id,amount);
	}
	
	@GetMapping("/wallet/withdraw/{id}/{amount}")
	public Double withdrawFunds(@PathVariable("id") Integer id,@PathVariable("amount") Double amount) {
		return this.walletService.withdrawFunds(id,amount);
	}
}
