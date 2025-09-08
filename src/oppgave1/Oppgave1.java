package oppgave1;

import javax.swing.JOptionPane;

public class Oppgave1 {
	
	static final Object lock = new Object();

	static String melding = "Hallo Verden!";

	public static void main(String[] args) {

		Thread skrivUt = new Thread(new Runnable() {
		    @Override
		    public void run() {
		        while (true) {
		            synchronized (lock) {
		                System.out.println(melding);
		            }
		            try {
		                Thread.sleep(3000); 
		            } catch (InterruptedException e) {
		                e.printStackTrace();
		            }
		        }
		    }
		});

		
		
		Thread skrivInn = new Thread(new Runnable() {
		    @Override
		    public void run() {
		        while (true) {
		            String nyTekst = JOptionPane.showInputDialog("Skriv noe:");
		            
		            if (nyTekst == null || nyTekst.equalsIgnoreCase("quit"))  {
		                System.exit(0); 
		            }

		            synchronized (lock) {
		                melding = nyTekst;
		            }
		        }
		    }
		});
		
		skrivUt.start();
		skrivInn.start();
		
		

	}}
		
