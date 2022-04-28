import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

class Valikko {
	private static final Scanner Lukija = new Scanner(System.in);
	private static final Scanner Lukija2 = new Scanner(System.in);

	public static final String kivi = "kivi";
	public static final String paperi = "paperi";
	public static final String sakset = "sakset";

	public static void main(String[] args) {

		System.out.println("Mitä peliä haluat pelata? 1 = Ristinolla, 2 = Blackjack, 3 = KPS");

		int Valinta = Lukija2.nextInt();
		if (Valinta == 1) {

			// Luo 3x3 arrayn eli "pelilaudan"
			char[][] Taulu = new char[3][3];

			// Täyttää pelilaudan tyhjillä paikoilla (viivoilla tässä tapauksessa)
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					Taulu[i][j] = '-';
				}

			}

			// Pyytää pelaajien nimet
			System.out.println("Syötä nimesi: Pelaaja 1");
			String p1 = Lukija.nextLine();
			System.out.println("Syötä nimesi: Pelaaja 2");
			String p2 = Lukija.nextLine();

			// Luodaan boolean muuttuja joka on true jos on pelaajan 1 vuoro ja false jos on
			// pelaajan 2 vuoro
			boolean Pelaaja1 = true;

			boolean peliLoppu = false;

			while (!peliLoppu) {
				piirräTaulu(Taulu);

				// Seurataan mitä symboolia käytetään pelin aikana
				char Symbooli = ' ';
				if (Pelaaja1) {
					Symbooli = 'x';
				} else {
					Symbooli = 'o';
				}

				if (Pelaaja1) {
					System.out.println("Pelaajan " + p1 + " vuoro");
				} else {
					System.out.println("Pelaajan " + p2 + " vuoro");
				}

				// Luodaan muuttujat rivi ja sarake mitkä edustavat paikkoja pelilaudalla
				int rivi = 0;
				int sarake = 0;

				while (true) {
					System.out.println("Mille riville haluat asettaa merkin: 0, 1 vai 2");
					rivi = Lukija.nextInt();
					System.out.println("Mille sarakkeelle haluat asettaa merkin: 0, 1 vai 2");
					sarake = Lukija.nextInt();

					if (rivi < 0 || sarake < 0 || rivi > 2 || sarake > 2) {
						System.out.println("Rivi ja/tai sarake ovat kentän ulkopuolella.");
					} else if (Taulu[rivi][sarake] != '-') {
						System.out.println("Siirto on jo tehty siihen paikkaan.");
					} else {
						break;
					}
				}

				Taulu[rivi][sarake] = Symbooli;

				if (onVoittanut(Taulu) == 'x') {
					System.out.println(p1 + " voitti!");
					peliLoppu = true;
				} else if (onVoittanut(Taulu) == 'o') {
					System.out.println(p2 + " voitti!");
					peliLoppu = true;
				} else {

					// Jos kumpikaan pelaaja ei ole voittanut tarkistetaan onko tasapeli
					if (Tasapeli(Taulu)) {
						System.out.println("Tasapeli!");
						peliLoppu = true;
					} else {
						// Vaihdetaan vuoroja
						Pelaaja1 = !Pelaaja1;
					}

				}
			}
		} else if (Valinta == 2) {
			/**
			 * Korttipakan kortit array-elementtinä ja aloitusrahamäärä (int-arvo).
			 */

			String[] kortit = { "Ässä", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Sotilas", "Kuningatar",
					"Kuningas" };
			int raha = 100;

			Scanner syote = new Scanner(System.in); // Käyttäjän syöte #1 (panoksen määrä).
			Scanner syote2 = new Scanner(System.in); // Käyttäjän syöte #2 (pelin valinta).
			System.out.println("Tervetuloa pelaamaan Blackjackia!");
			while (raha > 0) {

				/**
				 * Ensimmäisessä metodissa peli alkaa ja ohjelma kertoo säännöt.
				 */
				System.out.println("Sinulla on rahaa " + raha + "€");
				System.out.println("Aseta panoksesi (kokonaisluku, €):");

				/**
				 * Tässä pyritään saamaan pelaajalta oikea
				 * syöte, eli jotta pelaajalla varaa
				 * pelata.
				 */
				try {
					int panos = syote.nextInt();
					syote.nextLine();
					int pelaajaKasi = 0;

					if (panos > raha || panos <= 0)
						continue;
					System.out.println("Panoksesi on " + panos + "€");
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

						if (valinta.equalsIgnoreCase("Nosta")) {
							int arvo = (int) (Math.random() * 13) + 1;
							System.out.println("Sinä nostit kortin " + kortit[arvo - 1] + ", korttien yhteissumma on:");
							System.out.println(pelaajaKasi += arvo);

							/**
							 * Boolean-arvon määritelmä siitä
							 * kumpi voitti (riippuen pistemäärästä).
							 */

							if (pelaajaKasi > 21) {
								jakajaVoitti = true;
								break;
							}
							if (pelaajaKasi == 21) {
								pelaajaVoitti = true;
								break;
							}
						}

						else if (valinta.equalsIgnoreCase("Jää")) { // Pelaaja voi kirjoittaa pienillä tai sioilla
																	// kirjaimilla.
							int jakajaKasi = 0;

							/**
							 * Jakajan (tietokone) käden arvo
							 * määräytyy samalla logiikalla kuin
							 * pelaajan.
							 */

							while (true) {
								System.out.println("Pelaajan käsi:");
								System.out.println(pelaajaKasi);
								int arvo = (int) (Math.random() * 13) + 1;
								System.out.println(
										"Jakaja nosti kortin " + kortit[arvo - 1] + ", korttien yhteissumma on:");
								System.out.println(jakajaKasi += arvo);

								/**
								 * Tässä verrataan jakajan ja
								 * pelaajan käsiä ja boolean-arvo
								 * julistaa voittajan.
								 */

								if (jakajaKasi > 21) {
									pelaajaVoitti = true;

									break;
								}
								if (jakajaKasi == 21) {
									jakajaVoitti = true;
									break;
								}
								if (jakajaKasi > pelaajaKasi) {
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
								} catch (InterruptedException ex) {
									Thread.currentThread().interrupt();
								}

							}

							/**
							 * Pelin toiminto päättyy tai jatkuu
							 * lopputuloksesta riippuen
							 */

							break;
						} else
							continue;

						/**
						 * Lopputulema tulostetaan
						 * näytölle, riippuen voittajasta.
						 */

					}
					if (jakajaVoitti) {
						System.out.println("");
						System.out.println("Hävisit pelin.");
						raha -= panos;
					}
					if (pelaajaVoitti) {
						System.out.println("");
						System.out.println("Voitit pelin.");
						raha += panos;

					}
				}

				/**
				 * Ilmoitus, mikäli pelaaja
				 * syöttää muita kuin lukuja
				 * panosta valitessa.
				 */

				catch (InputMismatchException e) {
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

		} else if (Valinta == 3) {

			System.out.println("Tervetuloa kivi, paperi, sakset -peliin!");
			System.out.println("Syötä kivi, paperi tai sakset: ");

			String pelaajanVuoro = pelaajanVuoro();
			String rngVuoro = rngVuoro();

			if (pelaajanVuoro.equals(rngVuoro)) {
				System.out.println("Tasapeli !");

			} else if (pelaajanVuoro.equals(kiviPaperiSakset.kivi)) {

				if (rngVuoro.equals(kiviPaperiSakset.paperi)) {
					System.out.println("Vastustaja voitti :(");
				} else {
					System.out.println("Voitit !");
				}
			} else if (pelaajanVuoro.equals(kiviPaperiSakset.paperi)) {

				if (rngVuoro.equals(kiviPaperiSakset.sakset)) {
					System.out.println("Vastustaja voitti :(");
				} else {
					System.out.println("Voitit !");
				}
			} else if (pelaajanVuoro.equals(kiviPaperiSakset.sakset)) {

				if (rngVuoro.equals(kiviPaperiSakset.kivi)) {
					System.out.println("Vastustaja voitti :(");
				} else {
					System.out.println("Voitit !");
				}
			}

		}

	}

	public static String pelaajanVuoro() {
		Scanner syote = new Scanner(System.in);
		String kayttajanSyote = syote.nextLine();
		System.out.println("");
		return kayttajanSyote;
	}

	public static String rngVuoro() {
		Random rand = new Random();
		int rngNumero = rand.nextInt(3);
		String rngSyote = "";

		if (rngNumero == 0) {

			rngSyote = kiviPaperiSakset.kivi;

		} else if (rngNumero == 1) {

			rngSyote = kiviPaperiSakset.paperi;

		} else if (rngNumero == 2) {

			rngSyote = kiviPaperiSakset.sakset;
		}

		System.out.println("Vastustaja: " + rngSyote);
		return rngSyote;

	}

	// Tulostaa pelilaudan
	public static void piirräTaulu(char[][] Taulu) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(Taulu[i][j]);
			}
			System.out.println();
		}

	}

	public static char onVoittanut(char[][] Taulu) {

		for (int i = 0; i < 3; i++) {
			if (Taulu[i][0] == Taulu[i][1] && Taulu[i][1] == Taulu[i][2] && Taulu[i][0] != '-') {
				return Taulu[i][0];
			}
		}
		for (int j = 0; j < 3; j++) {
			if (Taulu[0][j] == Taulu[1][j] && Taulu[1][j] == Taulu[2][j] && Taulu[0][j] != '-') {
				return Taulu[0][j];
			}
		}
		if (Taulu[0][0] == Taulu[1][1] && Taulu[1][1] == Taulu[2][2] && Taulu[0][0] != '-') {
			return Taulu[0][0];
		}
		if (Taulu[2][0] == Taulu[1][1] && Taulu[1][1] == Taulu[0][2] && Taulu[2][0] != '-') {
			return Taulu[2][0];
		}
		return '-';
	}

	public static boolean Tasapeli(char[][] Taulu) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (Taulu[i][j] == '-') {
					return false;
				}
			}
		}
		return true;
	}
}
