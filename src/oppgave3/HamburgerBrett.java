package oppgave3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;


public class HamburgerBrett {
	
	private final BlockingQueue<Hamburger> brett;
	
	public HamburgerBrett(int kapasitet) {
		this.brett = new ArrayBlockingQueue<> (kapasitet);
	}
	
	public void leggPå(Hamburger h, String kokkNavn) throws InterruptedException {
        brett.put(h);  
        System.out.println(kokkNavn + " (kokk) legger på hamburger " + h + ". Brett: " + brett);
    };

	
	
    public Hamburger taAv(String navn) throws InterruptedException {
        Hamburger h = brett.take();  
        System.out.println(navn + " (servitør) tar av hamburger " + h + ". Brett: " + brett);
        return h;
    }

	
	
	

}
