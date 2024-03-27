package Prova;

import java.util.Scanner;

public class Prova {

    public static void main(String[] args) {
            FrazioneEgizia f = new FrazioneEgizia();
            Scanner scan = new Scanner(System.in);
            f.nr = scan.nextInt();
            f.dr = scan.nextInt();
            f.StampaFrazioneEgizia(f.nr, f.dr);
        }
    }