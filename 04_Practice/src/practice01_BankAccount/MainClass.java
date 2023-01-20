package practice01_BankAccount;

public class MainClass {
	
	public static void main(String[] args) {
		
		BankAccount myAcc = new BankAccount("01011112222", 50000);
		BankAccount yourAcc = new BankAccount("01033334444", 100000);
		
		myAcc.transfer(yourAcc, -50000);
		
		myAcc.inquiry();
		yourAcc.inquiry();
	}
}
