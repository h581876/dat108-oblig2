package oppgave2;

import java.util.LinkedList;
import java.util.Queue;

public class HamburgerBrett {
	
	private final int kapasitet;
	private final Queue<Hamburger> brett = new LinkedList<>();
	
	public HamburgerBrett(int kapasitet) {
		this.kapasitet = kapasitet;
	}
	
	public synchronized void leggPå(Hamburger hamburger, String kokkNavn)  {
		while (brett.size() >= kapasitet) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		brett.add(hamburger);
		System.out.println(kokkNavn + " La på: " + hamburger + " | Antall på brettet: " + brett.size());
		notifyAll();
	}
	
	public synchronized void taAv(Hamburger hamburger) throws InterruptedException {
		while (brett.isEmpty()) {
			wait();
		}
		brett.poll();
		System.out.println("Tok av: " + hamburger + " | Antall på brettet: " + brett.size());
	}

	
	
	

}
