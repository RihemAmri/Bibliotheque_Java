package bibliotheque;

public class MyException extends Exception{
	public MyException() {
		super("Ooops !Une erreur est survenue. Veuillez réessayer ultérieurement.");
	}
}
