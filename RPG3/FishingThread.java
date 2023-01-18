package RPG3;

public class FishingThread implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String[] arr = { "1..", "2..", "3.." };
		for (String s : arr) {
			System.out.println(s);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
