package banking;

import java.text.DecimalFormat;
public class Bank {
	
	private double withdraw;
	private double deposit;
	
	DecimalFormat df = new DecimalFormat("#.00");
	
	
	public void setWithdrawAmount(double withdraw) {

		this.withdraw = withdraw;
	}
	
	public double getWithdrawAmount() {

		return withdraw;
	}
	
	public void setDepositAmount(double deposit) {
		this.deposit = deposit;
	}

	public double getDepositAmount() {
		
		return deposit;
	}
	

	

}
