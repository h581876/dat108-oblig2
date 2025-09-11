package oppgave3;

public class Kokk implements Runnable {
	
	private final String navn;
	private final HamburgerBrett brett;
	
	
	
	public Kokk(String navn, HamburgerBrett brett) {
		this.navn = navn;
		this.brett = brett;
	}
	
	@Override
    public void run() {
        while (true) {
            try {
                Hamburger h = new Hamburger();
                brett.leggPå(h, navn);

                int sekunder = (int) (Math.random() * 5) + 2;
                Thread.sleep(sekunder * 1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
	}
	
	

}
