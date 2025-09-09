package oppgave2;

public class Hamburger {
	private static int globalId = 0;
    private final int id;   
    
    public Hamburger(int id) {
        this.id = ++globalId;
    }
    
    @Override
    public String toString() {
        return "◖" + id + "◗";
    }
}
