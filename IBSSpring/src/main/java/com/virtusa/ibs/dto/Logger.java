package com.virtusa.ibs.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


//@Embeddable
//class LoggerPk {
//	@Column(name="acctID")
//	public int acctID;
//	
//	@ManyToOne
//	@JoinColumn(name="Account_ID")
//	private Accounts acct;
//}

@Entity
public class Logger {
//	@EmbeddedId
//	private LoggerPk id;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int transactionID;
	private int acctID;
	private String transacType;
	private String transacStatus;
	private int initBal;
	private int finalBal;
	
	
	
	
	public Logger() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Logger(int transactionID, int acctID, String transacType, String transacStatus, int initBal, int finalBal) {
		super();
		this.transactionID = transactionID;
		this.acctID = acctID;
		this.transacType = transacType;
		this.transacStatus = transacStatus;
		this.initBal = initBal;
		this.finalBal = finalBal;
	}
	public int getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	public int getAcctID() {
		return acctID;
	}
	public void setAcctID(int acctID) {
		this.acctID = acctID;
	}
	public String getTransacType() {
		return transacType;
	}
	public void setTransacType(String transacType) {
		this.transacType = transacType;
	}
	public String getTransacStatus() {
		return transacStatus;
	}
	public void setTransacStatus(String transacStatus) {
		this.transacStatus = transacStatus;
	}
	public int getInitBal() {
		return initBal;
	}
	public void setInitBal(int initBal) {
		this.initBal = initBal;
	}
	public int getFinalBal() {
		return finalBal;
	}
	public void setFinalBal(int finalBal) {
		this.finalBal = finalBal;
	}
	@Override
	public String toString() {
		return "Logger [transactionID=" + transactionID + ", acctID=" + acctID + ", transacType=" + transacType
				+ ", transacStatus=" + transacStatus + ", initBal=" + initBal + ", finalBal=" + finalBal + "]";
	}
	
	
	
	
}
