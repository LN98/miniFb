package MiniFb;

public class Amico {
	
	String Nome, Cognome;
	int Età;
	String tag;
	Foto[] associati=new Foto[0];
	
	public Amico(String nome,String cognome, int età) {
		Età=età;
		Nome=nome;
		Cognome=cognome;
		tag=nome+cognome;
	}
	


}
