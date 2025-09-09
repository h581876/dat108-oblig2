package oppgave2;

public class Main {
	
	private static void skrivUtHeader(String[] kokker, String[] servitorer, int kapasitet) {
        System.out.println("I denne simuleringen har vi");
        System.out.print(kokker.length + " kokker [");
        for (String k : kokker) System.out.print(k + " ");
        System.out.println("]");
        System.out.print(servitorer.length + " servitører [");
        for (String s : servitorer) System.out.print(s + " ");
        System.out.println("]");
        System.out.println("Kapasiteten til brettet er " + kapasitet + " hamburgere.");
        System.out.println("Vi starter ...\n");
    }

	public static void main(String[] args) {
		
		final String [] kokker = {"Anne", "Erik", "Knut"};
		final String [] servitorer = {"Mia", "Per"};
		final int kapasitet = 4;
		
		skrivUtHeader(kokker, servitorer, kapasitet);
		
		HamburgerBrett brett = new HamburgerBrett(kapasitet);
		
		for (String navn : kokker) {
			Thread t = new Thread(new Kokk(navn, brett));
			t.start();
		}
		
		for (String navn : servitorer) {
            Thread t = new Thread(new Servitor(navn, brett));
            t.start();
        }
	}

}
