package oppgave2;

public class Servitor implements Runnable {
	
	private final String navn;
	private final HamburgerBrett brett;
	
	
	public Servitor(String navn, HamburgerBrett brett) {
		
		this.navn = navn;
		this.brett = brett;
	}
	
	@Override
	public void run() {
		while (true) {
			
			
			Hamburger h = brett.taAv(navn);
			
			int sekunder = (int) (Math.random() * 5) + 2; // tilfeldig tall mellom 2 og 6 sek
			
			try {
				Thread.sleep(sekunder * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	

}


