package ATM;

public class Account {
	int clientNo;
	String id;
	String accountNumber;
	int money;
	public Account(String id, String accountNumber, int money) {
		super();
		this.clientNo = clientNo;
		this.id = id;
		this.accountNumber = accountNumber;
		this.money = money;
	}
	@Override
	public String toString() {
		return "Account [clientNo=" + clientNo + ", id=" + id + ", accountNumber=" + accountNumber + ", money=" + money
				+ "]";
	}
}
