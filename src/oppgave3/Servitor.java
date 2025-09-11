package oppgave3;

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
            try {
                brett.taAv(navn);

                int sekunder = (int) (Math.random() * 5) + 2;
                Thread.sleep(sekunder * 1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
	}
	
	

}


