package ATM;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class File {
	
	static FileWriter fw;
	static FileReader fr;

	static String clientFileName = "src/ATM/clientData.txt";
	// clientNo/id/pw/name
	// clientNo/id/pw/name
	// ...

	static String accountFileName = "src/ATM/accountData.txt";
	// clientNo/accountNumber/money
	// clientNo/accountNumber/money
	// ...
	
	static String getData(String cName) {
		String data = "";
		if (cName.equals("Client")) {
			ArrayList<Client> clientlist = ClientDAO.getInstance().getcList();
			if (clientlist.size() == 0) {
				return data;
			}
			for (Client c : clientlist) {
				data += c.id + "," + c.pw + "," + c.name + "," + c.clientNo +"\n";
			}
		}
		if (cName.equals("Account")) {
			ArrayList<Account> accountlist = AccountDAO.getInstance().getAccList();
			if (accountlist.size() == 0) {
				return data;
			}
			for (Account acc : accountlist) {
				data += acc.id + "," + acc.accountNumber + "," + acc.money + "\n";
			}
		}
		data = data.substring(0, data.length() - 1);
		return data;
	}

	static void saveData(String path, String cName) {
		String data = getData(cName);
		if (data.equals("")) {
			System.out.println("저장할 데이터가 없다.");
			return;
		}

		try {
			fw = new FileWriter(path);
			fw.write(data);
			System.out.println(path + " 저장완료");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	static void save() {
		saveData(clientFileName, "Client");
		saveData(accountFileName, "Account");
	}

	static void loadData(String path, String cName) {
		String data = "";
		try {
			fr = new FileReader(path);
			data = "";
			while (true) {
				int read = fr.read();
				if (read != -1) {
					data += (char) read;
				} else {
					break;
				}
			}
			loadData2(data, cName);
			System.out.println(path + " 로드완료");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	static void loadData2(String data, String cName) {
		String[] data2 = data.split("\n");
		if (cName.equals("Client")) {
			ClientDAO.getInstance().getcList().clear();
			ArrayList<Client> clientlist = ClientDAO.getInstance().getcList();
			for (int i = 0; i < data2.length; i++) {
				String[] info = data2[i].split(",");
				clientlist.add(new Client(info[0], info[1], info[2], Integer.parseInt(info[3])));
			}
		}
		if (cName.equals("Account")) {
			AccountDAO.getInstance().getAccList().clear();
			ArrayList<Account> accountlist = AccountDAO.getInstance().getAccList();
			for (int i = 0; i < data2.length; i++) {
				String[] info = data2[i].split(",");
				accountlist.add(new Account(info[0], info[1], Integer.parseInt(info[2])));
			}
		}
	}

	public static void load() {
		// TODO Auto-generated method stub
		loadData(clientFileName, "Client");
		loadData(accountFileName, "Account");

	}

}
