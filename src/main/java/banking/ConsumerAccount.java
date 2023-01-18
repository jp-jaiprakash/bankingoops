package banking;

public class ConsumerAccount extends Account implements AccountInterface{
	private Person person;

	private Long accountNumber;

	private int pin;

	private double currentBalance;

	public ConsumerAccount(Person person, Long accountNumber, int pin, double currentBalance) {
		super(person,accountNumber,pin,currentBalance);
		// complete the function
		this.person = person;
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.currentBalance = currentBalance;

	}

	@Override
	public AccountHolder getAccountHolder() {
		return this.person;
	}

	@Override
	public boolean validatePin(int attemptedPin) {
		return this.pin == attemptedPin;
	}

	@Override
	public double getBalance() {
		return this.currentBalance;
	}

	@Override
	public Long getAccountNumber() {
		return this.accountNumber;
	}

	@Override
	public void creditAccount(double amount) {
		this.currentBalance +=amount;
	}

	@Override
	public boolean debitAccount(double amount) {
		if(this.currentBalance < amount)
			return false;
		 this.currentBalance -= amount;
		 return true;
	}
}
