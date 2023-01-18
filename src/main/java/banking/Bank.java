package banking;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts;

	private static Long startingAcctNumber = 1L;

	public Bank() {
		// complete the function
		this.accounts = new LinkedHashMap<>();
	}

	private Account getAccount(Long accountNumber) {
		// complete the function
        return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		// complete the function
		CommercialAccount commercialAccount = new CommercialAccount(company, startingAcctNumber, pin, startingDeposit);
		startingAcctNumber = startingAcctNumber +1;
        Long accountNumber =  commercialAccount.getAccountNumber();
		accounts.put(accountNumber, commercialAccount);
		return accountNumber;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		// complete the function
		ConsumerAccount consumerAccount = new ConsumerAccount(person, startingAcctNumber, pin, startingDeposit);
		startingAcctNumber = startingAcctNumber +1;
		Long accountNumber = consumerAccount.getAccountNumber();
		accounts.put(accountNumber, consumerAccount);
		return accountNumber;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		// complete the function
		for(Map.Entry<Long, Account> account : accounts.entrySet()){
			if(account.getValue().validatePin(pin))
				return true;
		}
        return false;
	}

	public double getBalance(Long accountNumber) {
		// complete the function
		for(Map.Entry<Long, Account> account : accounts.entrySet()){
			if(account.getValue().getAccountNumber() == accountNumber)
				return account.getValue().getBalance();
		}
        return -1;
	}

	public void credit(Long accountNumber, double amount) {
		// complete the function
		for(Map.Entry<Long, Account> account : accounts.entrySet()){
			if(account.getValue().getAccountNumber() == accountNumber)
				account.getValue().creditAccount(amount);
		}
	}

	public boolean debit(Long accountNumber, double amount) {
		// complete the function
		for(Map.Entry<Long, Account> account : accounts.entrySet()){
			if(account.getValue().getAccountNumber() == accountNumber)
				return account.getValue().debitAccount(amount);
		}
        return false;
	}

	private Long generateAccountNumber(){
		Random r = new Random();
		Long randomValue = 99 * r.nextLong();
		return randomValue;
	}
}
