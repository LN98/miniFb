package MiniFb;
import java.util.*;

public class avvio {
	
	public Amico[] NuovaLista(Amico[]VecchiaLista, String nome, String cognome, int età ) {
		Amico[] amici1=VecchiaLista.clone();
		VecchiaLista=new Amico[amici1.length+1];
		for(int j=0;j<amici1.length;j++) {
			VecchiaLista[j]=amici1[j];
		}
		Amico nuovo=new Amico(nome,cognome,età);
		VecchiaLista[VecchiaLista.length-1]=nuovo;
		return VecchiaLista;
		
	}
	 
	
	
	public static void main (String[] args) {
		
		int n;
		String nome,cognome,titolo,taga;
		int età;
		Scanner s=new Scanner(System.in);
		Amico[] lista;
		avvio a=new avvio();
		
		lista=new Amico[0];
		
		do {
			do {
				System.out.println("\n1.Aggiungi amico"
						+ "\n2.Aggiungi foto"
						+ "\n3.Controlla quantilà di foto per amico"
						+ "\n4.Mostra foto di un amico"
						+ "\n0.esci");
		
				n=s.nextInt();
				}while(n<1||n>4);
			
			
			
			switch(n) {
			
			case 1:
				System.out.println("inserisci il nome: ");
				nome=s.next();
				System.out.println("inserisci il cognome: ");
				cognome=s.next();
				System.out.println("inserisci età: ");
				età=s.nextInt();
				Amico[] lista1=lista.clone();
				lista= a.NuovaLista(lista1,nome,cognome,età);
				System.out.println("tag: "+lista[0].tag);
			break;
			
			case 2:
				System.out.println("inserisci il titolo: ");
				titolo=s.next();
				System.out.println("inserisci l'amico che vuoi taggare: ");
				taga=s.next();
				Foto nuovo=new Foto(titolo,taga);
				
				for(int i=0;i<lista.length;i++) {
					if(lista[i].tag.equalsIgnoreCase( nuovo.taga )) {
						Foto[] foto1=lista[i].associati.clone();
						lista[i].associati=new Foto[foto1.length+1];
						for(int j=0;j<foto1.length;j++) {
							lista[i].associati[j]=foto1[j];
						}
						Foto nuovo1=new Foto(titolo,taga);
						lista[i].associati[foto1.length]=nuovo;
					}
				}
				
			break;
			
			case 3:
				System.out.println("nome?");
				String nom=s.next();
				
				System.out.println("cognome?");
				String cog=s.next();
				
				for(int i=0; i<lista.length;i++) {
					if(nom.equalsIgnoreCase(lista[i].Nome)&&cog.equalsIgnoreCase(lista[i].Cognome)) {
						System.out.println(lista[i].associati.length);
					}
				}
			break;
			
			case 4:
				int max=0;
				for (int i=0;i<lista.length;i++) {
					if(lista[i].associati.length>max) {
						max=lista[i].associati.length;
					}
				}
				
				for (int i=0;i<lista.length;i++) {
					if(lista[i].associati.length==max) {
						System.out.print(lista[i].Nome+" "+lista[i].Cognome);
					}
				}
				System.out.println(" ha/hanno più foto");
				}
			
			}while(n!=0);
		s.close();
		
		
	}

}
