import java.util.Scanner;
import java.util.Random;

public class kiviPaperiSakset {

    public static final String kivi = "kivi";
    public static final String paperi = "paperi";
    public static final String sakset = "sakset";

    public static void main(String[] args) {

        System.out.println("Tervetuloa kivi, paperi, sakset -peliin!");
        System.out.println("kdjfsalkjdaslkfjdka");
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


}