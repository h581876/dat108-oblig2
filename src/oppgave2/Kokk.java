package oppgave2;

public class Kokk implements Runnable {
	
	private final String navn;
	private final HamburgerBrett brett;
	private int teller;
	
	
	public Kokk(String navn, HamburgerBrett brett, int teller) {
		
		this.navn = navn;
		this.brett = brett;
		this.teller = teller;
	}
	
	@Override
	public void run() {
		while (true) {
			Hamburger h = new Hamburger (++teller); //lager ny som teller opp
			
			brett.leggPå(h, navn);
			
			int sekunder = (int) (Math.random() * 5) + 2; // tilfeldig tall mellom 2 og 6 sek
			
			try {
				Thread.sleep(sekunder * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	

}
