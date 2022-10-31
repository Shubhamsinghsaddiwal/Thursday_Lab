/* Q1: WAP to craete  ATM  where customer enter our details ,pin and withdrawal cash or deposit cash.. 
      In this program you have to use encapculation for hinding user
      details and inheritance,polymorphism and interface. 
 */




package Thursday27;                               //interface

public interface Atm_Process {
	public void pro();
}



package Thursday27;                              // encapsulation

public class Private_fields {   
              
	private int pass;
	private int ac_bal = 1000;
                                                //we used getter setter methods for we want variable in different  class
	public int getPass() {
		return pass;
	}

	public void setPass(int u_pass) {
		this.pass = u_pass;
	}

	public void setAc_bal(int bal) {
		this.ac_bal = bal;
	}

	public int getAc_bal() {
		return ac_bal;
	}

	public int getAc_balcredit() {
		return ac_bal;
	}

	public void setAc_balcredit(int crebit) {       //deposit cash
		this.ac_bal += crebit;
		// db method for debit process
	}

	public int getAc_baldebit() {
		return ac_bal;
	}

	public void setAc_baldebit(int dedit) {       //withdrawal cash
		this.ac_bal -= dedit;
	}
}




package Thursday27;

import java.util.Scanner;

public class Bank extends Private_fields implements process {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Bank b = new Bank();
		b.accept();
	}

	void accept() {
		int user_pin;
		char card;


		System.out.println("Please Insert  your card");
		System.out.println("If you have inserted your card press: 'Y' or 'Yes'");
		card = sc.next().charAt(0);


		if (card == 'Y' || card == 'y') {
			System.out.println("Enter your Pin: ");
			user_pin = sc.nextInt();
			Private_fields obj = new Private_fields();
			obj.setPass(user_pin);
			pro();
		}
	}

	@Override
	public void pro()
	{

		int user_bal = 0;
		Private_fields obj = new Private_fields();
		int choice;
		char ans;


		do {
			System.out.println("Choose the Option\n1.Withddraw \n2.Deposit ");              //Choice for the user
			choice = sc.nextInt();


			switch (choice) {

			case 1:
				System.out.println("Enter the Amount you want to Deposit:  ");           //For deposit
				user_bal = sc.nextInt();
				obj.setAc_balcredit(user_bal);
				System.out.println("Deposit amout is Rs." + user_bal);
				System.out.println("The Account balance is Rs. " + obj.getAc_balcredit());
                        break;


			case 2:
				System.out.println("Enter the Amount you want to Withdraw: ");            //For withdraw
				user_bal = sc.nextInt();
				obj.setAc_baldebit(user_bal);
				
				
				if (obj.getAc_baldebit() >= 0) {
					System.out.println("The Account balance is Rs. " + obj.getAc_baldebit());
				} else {
					System.out.println("The Account does nit have Sufficiant Funds to Withdraw");
				}

				break;


			default:
				System.out.println("Invalid choice");

			}


			System.out.println("Do you want to do any another transtions y/n");
			ans = sc.next().charAt(0);

		} 


            while (ans == 'Y' || ans == 'y');

		System.out.println("The acccount balance is =" + obj.getAc_bal());
		System.out.println("Thank you for Banking with us!!!");

	}

}
