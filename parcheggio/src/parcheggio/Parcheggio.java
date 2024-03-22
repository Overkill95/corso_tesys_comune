package parcheggio;

class Parcheggio { 
	
	public int posti;
	
	public Parcheggio(int posti) {
		this.posti = posti;
	}
	
	public synchronized void entra() {
		if (posti==0) {
			try {
				wait();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		posti--;
	}
	
	public synchronized void esce() {
		posti++;
		notifyAll();
	} 
}