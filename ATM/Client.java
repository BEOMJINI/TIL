package ATM;

public class Client {
	int clientNo;
	String id;
	String pw;
	String name;

	public Client(String id, String pw, String name, int clientNo) {
		super();
		this.clientNo = clientNo;
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	@Override
	public String toString() {
		return id + "," + pw + "," + name;
	}
}
