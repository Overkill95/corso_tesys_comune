package staffetta;

public class Corridore implements Runnable{

	private int numeroCorridore;
	
	public Corridore (int numeroCorridore) {
		this.numeroCorridore = numeroCorridore;
	}
	
	@Override
	public void run() {
		int numeroPassi = 0;
		
		while(numeroPassi < 5) {
			numeroPassi++;
			System.out.println("Il corridore " + numeroCorridore + " ha fatto il passo numero " + numeroPassi);
			
			/*
			if(numeroPassi == 5) {				
				if(numeroCorridore == 5) {
					System.out.println("La staffetta è terminata");
					break;
				}
				
				System.out.println("Momento di passare il testimone al corridore " + (numeroCorridore + 1));
			}
			*/
		}
		
	}

	public int getNumeroCorridore() {
		return numeroCorridore;
	}

	public void setNumeroCorridore(int numeroCorridore) {
		this.numeroCorridore = numeroCorridore;
	}
}
