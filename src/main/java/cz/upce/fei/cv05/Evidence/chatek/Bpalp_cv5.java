/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package cz.upce.fei.cv05.Evidence.chatek;
import java.util.Scanner;
/**
 *
 * @author user
 */
public class Bpalp_cv5 {
    
    public static void main(String[] args) {
        // Konstanty pro definovani jednotlivych operaci (pouze pro cisty kod)
        final int KONEC_PROGRAMU = 0;
        final int VYPIS_CHATEK = 1;
        final int VYPIS_KONKRETNI_CHATKU = 2;
        final int PRIDANI_NAVSTEVNIKU = 3;
        final int ODEBRANI_NAVSTEVNIKU = 4;
        final int CELKOVA_OBSAZENOST = 5;
        final int VYPIS_PRAZDNE_CHATKY = 6;

        final int VELIKOST_KEMPU = 5;
        final int MAX_VELIKOST_CHATKY = 10;

        Scanner scanner = new Scanner(System.in);

        // Definovani pole podle velikosti kempu (poctu chatek)
        int[] chatky = new int[VELIKOST_KEMPU];
        int operace;

        do {
            System.out.println("""
                    MENU:
                                        
                    1 - vypsani vsech chatek
                    2 - vypsani konkretni chatky
                    3 - Pridani navstevniku
                    4 - Odebrani navstevniku
                    5 - Celkova obsazenost kempu
                    6 - Vypis prazdne chatky
                    0 - Konec programu
                    """);

            // Ziskani operace od uzivatele
            System.out.print("Zadej volbu: ");
            operace = scanner.nextInt();

            switch (operace) {
                case VYPIS_CHATEK -> {

                    // Projdi cele pole od <0, VELIKOST) a vypis kazdy index
                    for (int i = 0; i < chatky.length; i++) {
                        System.out.println("Chatka [" + (i + 1) + "] = " + chatky[i]);
                    }
                }

                case VYPIS_KONKRETNI_CHATKU -> {

                    // Ziskani cisla chatky od uzivatele
                    System.out.print("Zadej cislo chatky: ");
                    // Odecteni 1 protoze uzivatel cisluje chatky o 1, ale program od 0
                    int cisloChatky = scanner.nextInt() - 1;

                    // Zaporne nebo cislo vetsi nez je pocet chatek je nevalidni vstup
                    if (cisloChatky < 0 || cisloChatky >= chatky.length) {
                        System.err.println("Tato chatka neexistuje");
                        continue; // Zacni novou iteraci cyklu
                    }

                    System.out.println("Chatka [" + (cisloChatky + 1) + "] = " + chatky[cisloChatky]);
                }

                case PRIDANI_NAVSTEVNIKU -> {

                    
                    System.out.print("Zadej cislo chatky: ");
                    
                    int cisloChatky = scanner.nextInt() - 1;

                    
                    if (cisloChatky < 0 || cisloChatky >= chatky.length) {
                        System.err.println("Tato chatka neexistuje");
                        continue; 
                    }

                    
                    System.out.print("Zadej pocet navstevniku: ");
                    int pocetNavstevniku = scanner.nextInt();

                    
                    if (pocetNavstevniku <= 0 || pocetNavstevniku > MAX_VELIKOST_CHATKY) {
                        System.err.println("Neplatna hodnota pro pocet navstevniku");
                        continue; 
                    }

                    
                    if ((chatky[cisloChatky] + pocetNavstevniku) > MAX_VELIKOST_CHATKY) {
                        System.err.println("Prekrocen maximalni pocet navstevniku chatky");
                        continue; 
                    }

                    
                    chatky[cisloChatky] = pocetNavstevniku + chatky[cisloChatky];
                }

                case ODEBRANI_NAVSTEVNIKU -> {
    System.out.print("Zadej cislo chatky: ");
    int cisloChatky = scanner.nextInt() - 1;

    if (cisloChatky < 0 || cisloChatky >= chatky.length) {
        System.err.println("Tato chatka neexistuje");
        continue; 
    }

    System.out.print("Zadej pocet navstevniku k odebrani: ");
    int pocetNavstevniku = scanner.nextInt();

    if (pocetNavstevniku <= 0) {
        System.err.println("Neplatna hodnota pro pocet navstevniku");
        continue; 
    }

    if (chatky[cisloChatky] - pocetNavstevniku < 0) {
        System.err.println("Nelze odebrat více návštěvníků, než kolik je ubytovaných");
        continue; 
    }

    chatky[cisloChatky] -= pocetNavstevniku;
}

                
                case CELKOVA_OBSAZENOST -> {
    int celkovyPocet = 0;
    for (int i : chatky) {
        celkovyPocet += i;
    }
    System.out.println("Celkovy pocet ubytovanych navstevniku: " + celkovyPocet);
}


                case VYPIS_PRAZDNE_CHATKY -> {
    System.out.println("Prazdne chatky:");
    boolean prazdne = true;
    for (int i = 0; i < chatky.length; i++) {
        if (chatky[i] == 0) {
            System.out.println("Chatka [" + (i + 1) + "] je prazdna.");
            prazdne = false;
        }
    }
    if (prazdne) {
        System.out.println("Zadne prazdne chatky.");
    }
}


                case KONEC_PROGRAMU -> {
                    System.out.println("Konec programu");
                }

                default -> {
                    System.err.println("Neplatna volba");
                }
            }
       } while (operace != 0);
    }
}