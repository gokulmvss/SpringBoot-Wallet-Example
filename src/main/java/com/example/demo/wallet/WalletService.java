package com.example.demo.wallet;

import java.util.Collection;

import org.springframework.stereotype.Component;

public interface WalletService {
	Wallet createWallet(Wallet wallet);
	Wallet getWalletById(Integer walletId)throws WalletException;
	Wallet updateWallet(Wallet wallet);
	Wallet deleteWalletById(Integer walletId);
	
	Double addFunds(Integer walletId,Double amountadded);
	Double withdrawFunds(Integer walletId,Double amountadded);
	
	
	Collection<Wallet> getAllWallets();
	Boolean transferFunds(Integer fromId,Integer toId, Double amount);
}
