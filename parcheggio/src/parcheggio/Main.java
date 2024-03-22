package parcheggio;

public class Main {

	public static void main(String[] args) {
		
		Parcheggio parcheggio = new Parcheggio(5);
		
		for (int i=1; i<= 10; i++) {
			Macchina m = new Macchina("Auto " + i, parcheggio);
			Thread t = new Thread(m);
			t.start();
		}
	}

}
