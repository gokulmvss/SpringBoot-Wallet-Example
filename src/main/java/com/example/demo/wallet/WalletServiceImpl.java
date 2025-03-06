package com.example.demo.wallet;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class WalletServiceImpl implements WalletService {

	@Autowired
	private WalletRepository walletRepositoty;
	@Autowired 
	private AddressRepository addressrepository;
	@Autowired
	private TransactionRepository transactionrepository;

	@Override
	public Wallet createWallet(Wallet wallet)throws WalletException {
//		Optional<Wallet> foundWalletOpt = this.walletRepositoty.findByEmail(wallet.getEmail()); // custom repository method
		Optional<Wallet> foundWalletOpt = this.walletRepositoty.findByEmailaddress(wallet.getEmail()); // custom repository method
		if (foundWalletOpt.isPresent()) {
			// when exception is thrown, the function is exited
			throw new WalletException("Wallet with Wallet email " + wallet.getEmail() + " already exists.");
		}
		return this.walletRepositoty.save(wallet);
	}
	
	@Override
	public Collection<Wallet> getWalletByBalances(Double lowerBalance, Double upperBalance) throws WalletException {
		Collection<Wallet> foundWalletCollection = this.walletRepositoty.findWalletsBetween(lowerBalance,upperBalance);
//		Collection<Wallet> foundWalletCollection = this.walletRepositoty.findByBalanceBetween(lowerBalance,upperBalance); // custom repository method
		if (foundWalletCollection.isEmpty()) {
			// when exception is thrown, the function is exited
			throw new WalletException("No wallets exist with Current balance between " + lowerBalance+" and"+upperBalance);
		}
		return foundWalletCollection;
	}

	@Override
	public Wallet getWalletById(Integer walletId) throws WalletException {

		Optional<Wallet> foundWalletOpt = this.walletRepositoty.findById(walletId);
		if (foundWalletOpt.isEmpty()) {
			// when exception is thrown, the function is exited
			throw new WalletException("Wallet with Wallet Id " + walletId + " is Not Found");
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
		WalletToBeOpdated.setBalance(WalletToBeOpdated.getBalance() + amountadded);
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
		WalletToBeOpdated.setBalance(WalletToBeOpdated.getBalance() - amountwithdraw);
		this.walletRepositoty.save(WalletToBeOpdated);
		return WalletToBeOpdated.getBalance();
	}

	@Override
	@Transactional
    public Wallet updateWalletbyEmail(Wallet wallet) {
        this.walletRepositoty.updateWalletByEmail(wallet.getName(), wallet.getEmail());
        return this.walletRepositoty.findByEmail(wallet.getEmail()).orElse(null);
    }

	@Override
	@Transactional
//	public Wallet deleteWalletById(Integer walletId) {
//		Optional<Wallet> foundWalletOpt = this.walletRepositoty.findById(walletId);
//		if (foundWalletOpt.isEmpty()) {
////			return new Exception("");
//		}
//		Wallet deletedWallet = foundWalletOpt.get();
//		this.walletRepositoty.deleteById(walletId);
//		return deletedWallet;
//	}
	public Integer deleteWalletById(Integer walletId) {
		int deleteStatus = this.walletRepositoty.deleteWalletByID(walletId);
		return deleteStatus;
	}

	@Override
	public Collection<Wallet> getAllWallets() {
		return this.walletRepositoty.findAll();
	}

	@Override
	public String transferFunds(Integer fromId, Integer toId, Double amount) throws WalletException {
//		return null;
		Optional<Wallet> FromWalletinfo = this.walletRepositoty.findById(fromId);
		Optional<Wallet> ToWalletinfo = this.walletRepositoty.findById(toId);
		if (FromWalletinfo.isEmpty()) {
			throw new WalletException("Sender Wallet with Wallet Id "+fromId + " is Not Found");
		}
		if (fromId == toId) {
			throw new WalletException("Sender and Reciever cannot be same.");
		}
		if (ToWalletinfo.isEmpty()) {
			throw new WalletException("Reciever with Wallet Id "+toId + " is Not Found");
		}
		Wallet fromWallet = FromWalletinfo.get();
		Wallet toWallet = ToWalletinfo.get();
		
		if(fromWallet.getBalance() < amount) {
			throw new WalletException("Sender Wallet with Wallet Id "+fromId + " Has Insufficient Funds");
		}
		
		fromWallet.setBalance(fromWallet.getBalance()-amount);
		toWallet.setBalance(toWallet.getBalance()+amount);
		
		this.walletRepositoty.save(fromWallet);
		this.walletRepositoty.save(toWallet);
		
//		return true;
		return "Transfer Success, New Balance of Sender"+fromId+" is" + fromWallet.getBalance() + 
				"New Balance of Reciever "+toId+" is" + toWallet.getBalance();
	}
	@Override
	public Wallet logintoWallet(String emailInput, String passwordInput)throws WalletException {
		Optional<Wallet> loginWalletinfo = this.walletRepositoty.findByEmailAndPassword(emailInput,passwordInput);
		if (loginWalletinfo.isEmpty()) {
			throw new WalletException("Wallet not found with email "+emailInput);
		}
		return loginWalletinfo.get();
	}

	@Override
	public Page<Wallet> getWalletsPaginated(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Wallet addaddresstowallet(Address newaddress, String email)throws WalletException {
		Optional<Wallet> walletRetrieved = this.walletRepositoty.findByEmail(email);
		if(walletRetrieved.isEmpty()) {
			throw new WalletException("Wallet not found with email"+email);
		}
		Address savedAddress = this.addressrepository.save(newaddress);
		Wallet newWalletinfo = walletRetrieved.get();
		newWalletinfo.setAddress(savedAddress);
		return this.walletRepositoty.save(newWalletinfo);
	}

	@Override
	public Double withdrawFundswithtransactioninfo(String email, Double amount)throws WalletException {
		Optional<Wallet> walletRetrieved = this.walletRepositoty.findByEmail(email);
		if (walletRetrieved.isEmpty()) {
			throw new WalletException("Wallet not found with email"+email);
		}
		Wallet WalletToBeOpdated = walletRetrieved.get();
		if (WalletToBeOpdated.getBalance() < amount) {
			throw new WalletException("Funds not sufficient to withdraw");
		}
		WalletToBeOpdated.setBalance(WalletToBeOpdated.getBalance() - amount);
		Transaction newTransaction = new Transaction("Debit","Funds Withdraw",LocalDateTime.now());
		newTransaction= this.transactionrepository.save(newTransaction);
		WalletToBeOpdated.getTransactions().add(newTransaction);
		this.walletRepositoty.save(WalletToBeOpdated);
		return WalletToBeOpdated.getBalance();
	}

}
