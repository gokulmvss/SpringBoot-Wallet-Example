package com.example.demo.wallet;

import java.util.Collection;

// import org.springframework.stereotype.Component;

public interface WalletService {
	Wallet createWallet(Wallet wallet)throws WalletException ;
	Wallet getWalletById(Integer walletId)throws WalletException;
	Wallet updateWalletbyEmail(Wallet wallet);
//	Wallet deleteWalletById(Integer walletId);
	
	Integer deleteWalletById(Integer walletId);
	
	Double addFunds(Integer walletId,Double amountadded);
	Double withdrawFunds(Integer walletId,Double amountadded);

	Collection<Wallet> getAllWallets();
	Collection<Wallet> getWalletByBalances(Double lowerBalance,Double upperBalance) throws WalletException;
	String transferFunds(Integer fromId,Integer toId, Double amount)throws WalletException;
	Wallet logintoWallet(String emailInput, String passwordInput)throws WalletException;
	
}
