package oppgave3;

public class Hamburger {
	private static int globalId = 0;
    private final int id;   
    
    public Hamburger() {
        this.id = ++globalId;
    }
    
    @Override
    public String toString() {
        return "◖" + id + "◗";
    }
}
