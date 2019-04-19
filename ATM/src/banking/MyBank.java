package banking;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyBank {
	 static double balance = 500;
	 static Scanner scanner = new Scanner(System.in);//used for number input
	 static Scanner input2 = new Scanner(System.in);//used for String input
	 static double total;
	 static double balance2 = 800;
	
	public static void main(String[] args) {

		double fee = 2.50;
		String answer = "null";
		DecimalFormat df = new DecimalFormat("#.00");
		
		//balance = Double.parseDouble(df.format(balance));
		
		String[] name = new String[7];
			
			name[0] = "Jake";
			name[1] = "John";
			name[2] = "Chris";
			name[3] = "Brad";
			name[4] = "Beth";
			name[5] = "Samantha";
			name[6] = "Tesa";
		
		//Uses the Array of names for a random order
	    int random = (int)(Math.random()*7);
		
		
		System.out.println("Enter Your 6 Digit Acct# Then Press Enter....");
		int acct = scanner.nextInt();
			
		//Creates a loop if the Account Number isn't between 100000 - 999999 
			while(acct <100000 || acct > 999999) {
				System.out.println("That Acct# Is Not In The System. Try Again.." );
				System.out.println("Please Enter Your 6 Digit Acct#..");
				 acct = scanner.nextInt();
			}
			
			System.out.println("");
			
		//If the account number is between 100000 - 999999 then will print Hello to a random name
			if(acct >= 100000 && acct <= 999999)
				System.out.println("Hello " + name[random] + ".");
			
			System.out.println("");
			
			do {
				
				System.out.println("What Would You Like To Do Today?");
				System.out.println("Enter 1,2,3,or 4 Then Press Enter.");
				
				System.out.println("");
				
				System.out.println("1:Deposit\n" + "2:Withdraw\n" + "3:Check Balance\n" + "4:Transfer");
				int option = scanner.nextInt();
				
				Bank  b = new Bank();
				boolean start = true;
				
				switch(option) {
				
				case 1: 
						System.out.println("How Much Do You Want To Deposit?");
					
						while(start == true) {
							
							try {
								start = false;
								double amount = scanner.nextDouble();
								b.setDepositAmount(amount);
								
							}catch(InputMismatchException e) {
									System.out.println("Please Enter A Dollar Amount..");
									System.out.println("How Much Do You Want To Deposit?");
									scanner.next();
									start = true;
							}

						}
						System.out.println("");
						System.out.println("You Just Deposited $" + b.getDepositAmount());
						balance = balance + b.getDepositAmount();
						System.out.println("Your Balance Is $" + String.format("%.2f", balance));
						break;
	
				case 2: 
					while(start == true) {
						System.out.println("How Much Do You Want To Withdraw?");
						try {
							start = false;
							double w = scanner.nextDouble();
							b.setWithdrawAmount(w);
						}catch(InputMismatchException e) {
							System.out.println("Please Enter A Dollar Amount..");
							scanner.next();
							start = true;
						}
					}
							System.out.println("");
							while(start == false) {
								
								System.out.println("Do You Accept The $2.50 Withdrawal Fee? Yes/Y OR No/N");

								try {
									start = true;
									String choice = input2.nextLine();

							
									if(choice.equalsIgnoreCase("yes")||choice.equalsIgnoreCase("y")){
										System.out.println("You Just Withdrew $" + b.getWithdrawAmount());
										balance = balance - b.getWithdrawAmount() - fee;
										System.out.println("Your Balance Is $" + String.format("%.2f", balance));
										
									}
									else if(choice.equalsIgnoreCase("no")||choice.equalsIgnoreCase("n")) {
										System.out.println("OK..");
										
									}
									else {
										while(!(choice.equalsIgnoreCase("no")||choice.equalsIgnoreCase("yes")|| choice.equalsIgnoreCase("y")|| choice.equalsIgnoreCase("n"))) {
											System.out.println("Try again...Yes/No");
											choice = input2.nextLine();
										}
										
									}
											}catch(InputMismatchException e) {
												System.out.println("Please Enter a Dollar Amount Without A Decimal. EX:900");
												scanner.next();
												start = false;
											}
							}break;
				case 3:
						System.out.println("Your Balance is $" +String.format("%.2f", balance));
						break;
						
				case 4:
				
					
					System.out.println("Enter A 6 digit Account Number...");
					acct = scanner.nextInt();
					
					while(acct <100000 || acct > 999999) {
						System.out.println("That Acct# Is Not In The System. Try Again.." );
						System.out.println("Please Enter Your 6 Digit Acct#..");
						 acct = scanner.nextInt();
					}
					
					System.out.println("");
					
					if(acct >= 100000 && acct <= 999999) { 
						int random2 = (int)(Math.random()*7);
					
						if(name[random2].equals("Chris")) {
							System.out.println("Ok " + name[random2] + " what would you like to do?");
							System.out.println("1:Transfer To This Account.\n"+
											   "2:Transfer From This Account.");
							 option = scanner.nextInt();
						}
						else if(!name[random2].equals("Chris")) {
							System.out.println("Ok what would you like to do?");
							System.out.println("1:Transfer To This Account.\n"+
									           "2:Transfer From This Account.");
							option = scanner.nextInt();
						}
								if(option == 1) {
									
									 
									System.out.println("How much are you Transfering?");
									double amount = scanner.nextDouble();
							
									
									TransferClass tr = t ->{ 
									total= amount + balance2;
									System.out.println(String.format("%.2f",total));
									return total;
									};
									
									System.out.print("The Balance is $");
									tr.transfer(total);	
									balance = balance - amount; 
								}
								
								else if(option == 2) {
									System.out.println("How much do you want to Transfer from this account?");
									double amount = scanner.nextDouble();
									 
									TransferClass tr = t ->{ 
									total= balance2 - amount;
									System.out.println(total);
									return total;
									};
									
									balance = balance + amount;
									
										if(total < 0) {
											System.out.println("The Balance is below 0, a $30 fee Overdraft fee will be added.");
											total=total- 30;
										}
										
									System.out.print("The Balance is $");
									tr.transfer(total);
								}
							
						}
						
					}
					

				System.out.println("");
				
				System.out.println("Do you want to continue? Enter: Yes/Y OR No/N");
				answer = input2.nextLine();
				
				while(!(answer.equalsIgnoreCase("no")||answer.equalsIgnoreCase("yes")|| answer.equalsIgnoreCase("y")|| answer.equalsIgnoreCase("n"))) {
					System.out.println("Try again...Yes/No");
					answer = input2.nextLine();
					
				}


			}while(answer.equalsIgnoreCase( "yes") || answer.equalsIgnoreCase("y"));
			
				if(answer.equalsIgnoreCase("no")||answer.equalsIgnoreCase("n")) {
					System.out.println("Have A Nice Day!");
			}

		
		

	}

}
