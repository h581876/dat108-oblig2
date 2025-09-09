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
		System.out.println(kokkNavn + "(kokk) La på: " + "hamburger id nr: " + hamburger +  " | Antall på brettet: " + brett.size());
		notifyAll();
	}
	
	public synchronized Hamburger taAv(String navn)  {
		while (brett.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Hamburger h = brett.poll();
		System.out.println(navn + " (servitør) tok av: " + "hamburger id nr: " + h + " | Antall på brettet: " + brett.size());
		return h;
	}

	
	
	

}
