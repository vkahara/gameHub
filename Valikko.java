import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

class Valikko{
    private static final Scanner Lukija = new Scanner(System.in);
    private static final Scanner Lukija2 = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Mitä peliä haluat pelata? 1 = Ristinolla, 2 = Blackjack, 3 = KPS");

        int Valinta = Lukija2.nextInt();
        if(Valinta == 1){
    
            //Luo 3x3 arrayn eli "pelilaudan"
        char[][] Taulu = new char[3][3];

        //Täyttää pelilaudan tyhjillä paikoilla (viivoilla tässä tapauksessa)
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++  ){
                Taulu[i][j] = '-';
            }
            
        }

        
        //Pyytää pelaajien nimet
        System.out.println("Syötä nimesi: Pelaaja 1");
        String p1 = Lukija.nextLine();
        System.out.println("Syötä nimesi: Pelaaja 2");
        String p2 = Lukija.nextLine();

        //Luodaan boolean muuttuja joka on true jos on pelaajan 1 vuoro ja false jos on pelaajan 2 vuoro
        boolean Pelaaja1 = true;

        boolean peliLoppu = false;

        while(!peliLoppu){
            piirräTaulu(Taulu);

            //Seurataan mitä symboolia käytetään pelin aikana
            char Symbooli = ' ';
            if (Pelaaja1){
                Symbooli = 'x';
            } else{
                Symbooli = 'o';
            }

            if(Pelaaja1){
                System.out.println("Pelaajan " + p1 + " vuoro");
            } else{
                System.out.println("Pelaajan " + p2 + " vuoro");
            }

            
            //Luodaan muuttujat rivi ja sarake mitkä edustavat paikkoja pelilaudalla
            int rivi = 0;
            int sarake = 0;

            

            



            while(true){
                System.out.println("Mille riville haluat asettaa merkin: 0, 1 vai 2");
                rivi = Lukija.nextInt();
                System.out.println("Mille sarakkeelle haluat asettaa merkin: 0, 1 vai 2");
                sarake = Lukija.nextInt();

                if(rivi < 0 ||sarake < 0 || rivi > 2 || sarake > 2 ) {
                    System.out.println("Rivi ja/tai sarake ovat kentän ulkopuolella.");
                }
                else if (Taulu[rivi][sarake] != '-') {
                    System.out.println("Siirto on jo tehty siihen paikkaan.");
                }
                else {
                    break;   
                }
            }

            Taulu[rivi][sarake] = Symbooli;

            if(onVoittanut(Taulu) == 'x') {
				System.out.println(p1 + " voitti!");
				peliLoppu = true;
			} else if(onVoittanut(Taulu) == 'o') {
				System.out.println(p2 + " voitti!");
				peliLoppu = true;
			} else {

				// Jos kumpikaan pelaaja ei ole voittanut tarkistetaan onko tasapeli
				if(Tasapeli(Taulu)) {
					System.out.println("Tasapeli!");
					peliLoppu = true;
				} else {
					//Vaihdetaan vuoroja
					Pelaaja1 = !Pelaaja1;
				}

			}
        }
    } else if (Valinta == 2){

    } else if (Valinta == 3){
        
    } 

       

    

    }
        

     //Tulostaa pelilaudan
     public static void piirräTaulu(char[][] Taulu){
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++  ){
                System.out.print(Taulu[i][j]);
            }
            System.out.println();
        }
    

}

public static char onVoittanut(char[][] Taulu){

    for(int i = 0; i < 3; i++){
        if(Taulu[i][0] == Taulu[i][1] && Taulu[i][1] == Taulu[i][2] && Taulu[i][0] != '-'){
            return Taulu[i][0];
        }
    }
    for(int j = 0; j < 3; j++){
        if(Taulu[0][j] == Taulu[1][j] && Taulu[1][j] == Taulu[2][j] && Taulu[0][j] != '-'){
            return Taulu[0][j];
        }
    }
    if(Taulu[0][0] == Taulu[1][1] && Taulu[1][1] == Taulu[2][2] && Taulu[0][0] != '-') {
        return Taulu[0][0];
    }
    if(Taulu[2][0] == Taulu[1][1] && Taulu[1][1] ==  Taulu[0][2] && Taulu[2][0] != '-') {
        return Taulu[2][0];
    }
    return '-';
}

public static boolean Tasapeli(char[][] Taulu){
    for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++){
            if(Taulu[i][j] == '-'){
                return false;
            }
        }
    }
    return true;
}
}    

              


     