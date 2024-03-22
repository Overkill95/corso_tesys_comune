package staffetta;

public class Main {

	public static void main(String[] args) {
		
		
		for(int i = 1; i <= 5; i++) {
			Corridore c = new Corridore(i);
			Thread t = new Thread (c);
			t.start();
			try {
	            t.join();
	        } 
			catch (InterruptedException e) {
	            e.printStackTrace();
	        }
					
			if(c.getNumeroCorridore() == 5) {
				System.out.println("La staffetta è terminata");
				break;
			}
			else {
				System.out.println("Momento di passare il testimone al corridore " + (c.getNumeroCorridore() + 1));
			}
		}
		
		
	}

}
