package practice;

public class MainClass {
	
	public static void main(String[] args) {
		
		BankAccount myAcc = new BankAccount("010-5024-7528", 50_000);
		BankAccount yourAcc = new BankAccount("010-3570-7528", 100_000);
		
		myAcc.transfer(yourAcc, 50_000);
		
		myAcc.inquiry();
		yourAcc.inquiry();
		
		
	}
}
