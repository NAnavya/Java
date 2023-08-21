package com.virtusa.ibs.dto;

	import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
	import javax.persistence.Id;


	@Entity
	public class Accounts {
		@Id
		private int acctID;
		private int balance;
		private String acctStatus;
		private String password;
		
		public Accounts() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Accounts(int acctID, int balance, String acctStatus, String password) {
			super();
			this.acctID = acctID;
			this.balance = balance;
			this.acctStatus = acctStatus;
			this.password = password;
		}
		public int getAcctID() {
			return acctID;
		}
		public void setAcctID(int acctID) {
			this.acctID = acctID;
		}
		public int getBalance() {
			return balance;
		}
		public void setBalance(int balance) {
			this.balance = balance;
		}
		public String getAcctStatus() {
			return acctStatus;
		}
		public void setAcctStatus(String acctStatus) {
			this.acctStatus = acctStatus;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		@Override
		public String toString() {
			return "Accounts [acctID=" + acctID + ", balance=" + balance + ", acctStatus=" + acctStatus + ", password="
					+ password + "]";
		}
		
		
		
	}


