package com.example.demo.wallet;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService {

	@Autowired
	private WalletRepository walletRepositoty;

	@Override
	public Wallet createWallet(Wallet wallet) {
		return this.walletRepositoty.save(wallet);
	}

	@Override
	public Wallet getWalletById(Integer walletId) throws WalletException{
		
		Optional<Wallet> foundWalletOpt = this.walletRepositoty.findById(walletId);
		if (foundWalletOpt.isEmpty()) {
			// when exception is thrown, the function is exited
			throw new WalletException("Wallet with Wallet Id "+walletId + " is Not Found");
		}
		return foundWalletOpt.get();
	}
	
	@Override
	public Double addFunds(Integer walletId, Double amountadded) {
		Optional<Wallet> foundWalletOpt = this.walletRepositoty.findById(walletId);
//		if (foundWalletOpt.isEmpty()) {
////			return new Exception("");
//		}
		Wallet WalletToBeOpdated = foundWalletOpt.get();
		WalletToBeOpdated.setBalance(WalletToBeOpdated.getBalance()+amountadded);
		this.walletRepositoty.save(WalletToBeOpdated);
		return WalletToBeOpdated.getBalance();
	}

	@Override
	public Double withdrawFunds(Integer walletId, Double amountwithdraw) {
		Optional<Wallet> foundWalletOpt = this.walletRepositoty.findById(walletId);
		Wallet WalletToBeOpdated = foundWalletOpt.get();
		if (WalletToBeOpdated.getBalance() < amountwithdraw) {
//			return new Exception("");
		}
		WalletToBeOpdated.setBalance(WalletToBeOpdated.getBalance()-amountwithdraw);
		this.walletRepositoty.save(WalletToBeOpdated);
		return WalletToBeOpdated.getBalance();
	}

	@Override
	public Wallet updateWallet(Wallet wallet) {
		return this.walletRepositoty.save(wallet);
	}

	@Override
	public Wallet deleteWalletById(Integer walletId) {
		Optional<Wallet> foundWalletOpt = this.walletRepositoty.findById(walletId);
		if (foundWalletOpt.isEmpty()) {
//			return new Exception("");
		}
		Wallet deletedWallet = foundWalletOpt.get();
		this.walletRepositoty.deleteById(walletId);
		return deletedWallet;
	}

	@Override
	public Collection<Wallet> getAllWallets() {
		return this.walletRepositoty.findAll();
	}

	@Override
	public Boolean transferFunds(Integer fromId, Integer toId, Double amount) {
		return null;
	}

	
}
