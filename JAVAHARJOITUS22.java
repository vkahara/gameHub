import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * @author Kristian K.
 */

public class JAVAHARJOITUS22 {
	/**
	 * Tämän ohjelma on yksinkertainen
	 * komentorivi-blackjack, päämetodi.
	 */
	
	public static void main (String[] args) {

	/** 
	 * Korttipakan kortit array-elementtinä ja aloitusrahamäärä (int-arvo).
	*/

	String[] kortit = {"Ässä","2","3","4","5","6","7","8","9","10","Sotilas","Kuningatar","Kuningas"	};
	int raha = 100;
	
	Scanner syote = new Scanner(System.in); //Käyttäjän syöte #1 (panoksen määrä).
	Scanner syote2 = new Scanner(System.in); //Käyttäjän syöte #2 (pelin valinta).
	System.out.println("Tervetuloa pelaamaan Blackjackia!");
	while (raha >0) {
	
		/**
		 * Ensimmäisessä metodissa peli alkaa ja ohjelma kertoo säännöt.
		 */
		System.out.println("Sinulla on rahaa " +raha +"€");
		System.out.println("Aseta panoksesi (kokonaisluku, €):"); 
		
		/**
		 * Tässä pyritään saamaan pelaajalta oikea
		 * syöte, eli jotta pelaajalla varaa
		 * pelata.
		 */
	try{
		int panos = syote.nextInt();
	syote.nextLine();
		int pelaajaKasi = 0;

		if (panos>raha||panos<=0) continue;
		System.out.println("Panoksesi on " +panos +"€");
		boolean jakajaVoitti = false, pelaajaVoitti = false;
		
			/**
		 * Pelaajalla kaksi syötevaihtoehtoa edetä
		 * pelissä, sekä ohjelma tulostaa käden
		 * senhetkisen arvon (satunnainen array:n kortti
		 * lisätään käteen).
		  */

		while (true) {
			System.out.println("Valitse 'Nosta' tai 'jää'");
			String valinta = syote2.nextLine();

		if(valinta.equalsIgnoreCase("Nosta")) {
			int arvo = (int)(Math.random()*13)+1;
			System.out.println("Sinä nostit kortin " +kortit[arvo-1]+", korttien yhteissumma on:");
			System.out.println(pelaajaKasi+=arvo);
			
			/**
		 	* Boolean-arvon määritelmä siitä
		 	* kumpi voitti (riippuen pistemäärästä).
		 	*/

			if (pelaajaKasi >21) {
				jakajaVoitti = true;
				break;
			}
			if (pelaajaKasi == 21) {
			pelaajaVoitti = true;
			break;
			}
		}
		

		else if (valinta.equalsIgnoreCase("Jää")) { //Pelaaja voi kirjoittaa pienillä tai sioilla kirjaimilla.
			int jakajaKasi = 0;

			/** 
			* Jakajan (tietokone) käden arvo
			* määräytyy samalla logiikalla kuin
			* pelaajan.
			*/

			while(true) {
				System.out.println("Pelaajan käsi:");
				System.out.println(pelaajaKasi);
				int arvo = (int)(Math.random()*13)+1;
				System.out.println("Jakaja nosti kortin " +kortit[arvo-1]+", korttien yhteissumma on:");
				System.out.println(jakajaKasi+=arvo);

					/**
					 * Tässä verrataan jakajan ja 
					 * pelaajan käsiä ja boolean-arvo
					 * julistaa voittajan.
					 */

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

				/**
				 * Tämä aikavastus luo jakajan 
				 * toimille viiveaikaa, jotteivät tulosteet
				 * ilmaantuisi välittömästi.
				 */

				}
				try {
					Thread.sleep(1500); 
				}
					catch(InterruptedException ex){
						Thread.currentThread().interrupt();
					}
			

				}

		/**
		 * Pelin toiminto päättyy tai jatkuu
		 * lopputuloksesta riippuen
		 */
		
		break;
		}
		else continue;
	
	/** 
	 * Lopputulema tulostetaan
	* näytölle, riippuen voittajasta.
	*/

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

	 /**
	   * Ilmoitus, mikäli pelaaja
	   * syöttää muita kuin lukuja
	   * panosta valitessa.
	   */

	catch(InputMismatchException e) {
		System.out.println("Syötä pelkästään kokonaislukuja.");
	System.out.println("");
      syote.nextLine();
	 
	}
}

/**
 * Peli ilmoitetaan päättyneeksi
 * mikäli pelaajalta loppuu
 * varat, ohjelman suoritus loppuu. 
 */

	System.out.println("");
	System.out.println("Hävisit kaikki rahasi.");
	syote.close();
	syote2.close();
}
}
