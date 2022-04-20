import java.util.InputMismatchException;
import java.util.Scanner;

public class JAVAHARJOITUS22 {
	
	public static void main (String[] args) {

	String[] kortit = {"Ässä","2","3","4","5","6","7","8","9","10","Sotilas","Kuningatar","Kuningas"	};
	int raha = 100;
	Scanner syote = new Scanner(System.in);
	Scanner syote2 = new Scanner(System.in);
	System.out.println("Tervetuloa pelaamaan Blackjackia!");
	while (raha >0) {
	
		System.out.println("Sinulla on rahaa " +raha +"€");
		System.out.println("Aseta panoksesi (kokonaisluku, €):"); 
	try{
		int panos = syote.nextInt();
	syote.nextLine();
		int pelaajaKasi = 0;
		if (panos>raha||panos<=0) continue;
		System.out.println("Panoksesi on " +panos +"€");
		boolean jakajaVoitti = false, pelaajaVoitti = false;
		
		while (true) {
			System.out.println("Valitse 'Nosta' tai 'jää'");
			String valinta = syote2.nextLine();
		if(valinta.equalsIgnoreCase("Nosta")) {
			int arvo = (int)(Math.random()*13)+1;
			System.out.println("Sinä nostit kortin " +kortit[arvo-1]+", korttien yhteissumma on:");
			System.out.println(pelaajaKasi+=arvo);
			if (pelaajaKasi >21) {
				jakajaVoitti = true;
				break;
			}
			if (pelaajaKasi == 21) {
			pelaajaVoitti = true;
			break;
			}
		}
		else if (valinta.equalsIgnoreCase("Jää")) { //ignore capital letters
			int jakajaKasi = 0;
			while(true) {
				System.out.println("Pelaajan käsi:");
				System.out.println(pelaajaKasi);
				int arvo = (int)(Math.random()*13)+1;
				System.out.println("Jakaja nosti kortin " +kortit[arvo-1]+", korttien yhteissumma on:");
				System.out.println(jakajaKasi+=arvo);
			
				if (jakajaKasi>21) {
					pelaajaVoitti = true;
					
					break;
				}
				if (jakajaKasi==21) {
					jakajaVoitti = true;
					break;
				}
				if (jakajaKasi>pelaajaKasi) {
					jakajaVoitti = true;
					break;
				}
				try {
					Thread.sleep(1500); 
				}
					catch(InterruptedException ex){
						Thread.currentThread().interrupt();
					}
				
				}
		break;
		}
		else continue;
		
		
	} 
	if (jakajaVoitti) {	
		System.out.println("");
		System.out.println("Hävisit pelin.");
		raha-=panos;
	}
	if (pelaajaVoitti) {
		System.out.println("");
		System.out.println("Voitit pelin.");
		raha+=panos;
	
	}
	
		
	}


	catch(InputMismatchException e) {
		System.out.println("Syötä pelkästään kokonaislukuja.");
	System.out.println("");
      syote.nextLine();
	}
}

	System.out.println("");
	System.out.println("Hävisit kaikki rahasi.");
	syote.close();
	syote2.close();
}
}
