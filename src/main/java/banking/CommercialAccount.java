package banking;

import java.util.ArrayList;
import java.util.List;

/**
 * Account implementation for commercial (business) customers.<br><br>
 *
 * Private Variables:<br>
 * {@link #authorizedUsers}: List&lt;Person&gt;<br>
 */
public class CommercialAccount extends Account implements AccountInterface{

	private Company company;
	private Long accountNumber;
	private int pin;
	private double startingDeposit;
	private List<Person> authorizedUsers;

	public CommercialAccount(Company company, Long accountNumber, int pin, double startingDeposit) {
		super(company,accountNumber, pin,startingDeposit);
		// complete the function
		this.company = company;
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.startingDeposit = startingDeposit;


	}

	/**
	 * @param person The authorized user to add to the account.
	 */
	protected void addAuthorizedUser(Person person) {
		// complete the function
		authorizedUsers.add(person);

	}

	/**
	 * @param person
	 * @return true if person matches an authorized user in {@link #authorizedUsers}; otherwise, false.
	 */
	public boolean isAuthorizedUser(Person person) {
		// complete the function
        return authorizedUsers.contains(person);
	}

	@Override
	public AccountHolder getAccountHolder() {
		return this.company;
	}

	@Override
	public boolean validatePin(int attemptedPin) {
		return this.pin == attemptedPin;
	}

	@Override
	public double getBalance() {
		return this.startingDeposit;
	}

	@Override
	public Long getAccountNumber() {
		return this.accountNumber;
	}

	@Override
	public void creditAccount(double amount) {
		this.startingDeposit +=amount;
	}

	@Override
	public boolean debitAccount(double amount) {
		if(this.startingDeposit < amount)
			return false;
		this.startingDeposit -= amount;
		return true;

	}
}
