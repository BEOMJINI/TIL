package s1_Member;

public class Member {
	// id , pw , num, name , loginId
	private int num;
	private String id;
	private String pw;
	private String name;

	public Member(int num, String id, String pw, String name) {
		super();
		this.num = num;
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	@Override
	public String toString() {
		String print = String.format("[%-4d] [%7s] [%7s] [%7s]\n", num, id, pw, name);
		return print;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
