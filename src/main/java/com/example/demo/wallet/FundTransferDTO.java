package com.example.demo.wallet;

public class FundTransferDTO {
	
	private Integer fromWalletId;
	private Integer toWalletId;
	private Double amount;
	public FundTransferDTO() {
		super();
	}
	public FundTransferDTO(Integer fromWalletId, Integer toWalletId, Double amount) {
		super();
		this.fromWalletId = fromWalletId;
		this.toWalletId = toWalletId;
		this.amount = amount;
	}
	public Integer getFromWalletId() {
		return fromWalletId;
	}
	public void setFromWalletId(Integer fromWalletId) {
		this.fromWalletId = fromWalletId;
	}
	public Integer getToWalletId() {
		return toWalletId;
	}
	public void setToWalletId(Integer toWalletId) {
		this.toWalletId = toWalletId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	

}
