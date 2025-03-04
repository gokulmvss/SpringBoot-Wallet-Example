package com.example.demo.wallet;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class WalletController {
	@Autowired
	private WalletService walletService;
	
	@PostMapping("/createwallet")
	public Wallet AddWallet(@Valid @RequestBody Wallet walet)throws WalletException {
		return this.walletService.createWallet(walet);
	}
	
	@PostMapping("/wallet/update")
	public Wallet UpdateWalletnamebyemail(@RequestBody Wallet walet)throws WalletException {
		return this.walletService.updateWalletbyEmail(walet);
	}
	
	@PostMapping("/wallet/delete")
	public Integer deleteWalletByid(@RequestBody Integer walletId){
		return this.walletService.deleteWalletById(walletId);
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
	
	@GetMapping("/wallet/betweenRange/{lowerrange}/{upperrange}")
	public Collection<Wallet> withdrawFunds(@PathVariable("lowerrange") Double lowerrange,@PathVariable("upperrange") Double upperrange)throws WalletException {
		return this.walletService.getWalletByBalances(lowerrange,upperrange);
	}
	
	@GetMapping("/wallet/walletsInfo")
	public Collection<Wallet> getAllWallets(){
		return this.walletService.getAllWallets();
	}
	
	@PatchMapping("/wallet/transfer")
	public String transferFunds(@RequestBody FundTransferDTO ftdto) throws WalletException{
		return this.walletService.transferFunds(ftdto.getFromWalletId(),ftdto.getToWalletId(),ftdto.getAmount());
	}
	
	@GetMapping("/wallet/login")
	public Wallet logintoWallet(@RequestBody userLoginDTO uldto) throws WalletException{
		return this.walletService.logintoWallet(uldto.getEmailInput(),uldto.getPasswordInput());
	}
	
}
