package parcheggio;


class Macchina implements Runnable {
	
	private Parcheggio parcheggio;
	private String nome;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	} 
	
	public Macchina(String nome,Parcheggio parcheggio) {
		this.nome = nome;
		this.parcheggio = parcheggio;
	}
	
	public void run() {
		while (true) {
			try { 
				Thread.sleep((int)(Math.random() * 20000));
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			} 
			
				parcheggio.entra();
				System.out.println(getNome()+" è entrata. Liberi: " + parcheggio.posti);
			try { 
				Thread.sleep((int)(Math.random() * 10000));
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			} 

				parcheggio.esce();
				System.out.println(getNome()+" è uscita. Liberi:" + parcheggio.posti);
		} 
	}
}
