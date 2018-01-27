/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ristorante;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author XenSide
 */
public class ProgBar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Coda codaOrdinazioni = new Coda();
        Ordine ord = null;
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);
        String tipoOrdine = null;
        int tavoloOrdine = 0;
        String contenutoOrdine = null;
        Boolean isDone = null;
        
        do {
            System.out.println("\nChe operazione vuoi effettuare? Scrivi:\n1.Aggiungere\n2.Rimuovere\n3.Visuallizare\n4.Esci");
            try {
                tipoOrdine = tastiera.readLine();
            } catch (IOException e) {
            }

            switch (tipoOrdine.toLowerCase()) {
                case "1":
                case "aggiungere":
                    boolean redo = true;
                    do {

                        do {
                            System.out.print("\nInserisci il numero del tavolo che sta effettuando l'ordine: ");
                            try {
                                tavoloOrdine = Integer.valueOf(tastiera.readLine());
                                isDone = true;
                            } catch (IOException | NumberFormatException e) {
                                System.err.println("ERRORE 196:Errore di Input");
                                isDone = false;
                            }
                        } while (!isDone);

                        do {
                            System.out.print("Inserisci il contenuto dell'ordine: ");
                            try {
                                contenutoOrdine = tastiera.readLine();
                                isDone = true;
                            } catch (IOException e) {
                                System.err.println("ERRORE 197:Errore di Input");
                                isDone = false;
                            }
                        } while (!isDone);

                        ord = new Ordine(tavoloOrdine, contenutoOrdine);
                        codaOrdinazioni.aggiungi(ord);
                        String altroOrdine = null;
                        do {
                            do {
                                System.out.print("\nVuoi effettuare un altro ordine? Scrivi Si o No: ");
                                altroOrdine = null;
                                try {
                                    altroOrdine = tastiera.readLine();
                                    isDone = true;
                                } catch (IOException e) {
                                    System.err.println("ERRORE 198:Errore di Input");
                                    isDone = false;
                                }
                            } while (!isDone);

                            switch (altroOrdine.toLowerCase()) {
                                case "1":
                                case "si":
                                    redo = true;
                                    isDone = true;
                                    break;
                                case "no":
                                case "2":
                                    redo = false;
                                    isDone = true;
                                    break;
                                default:
                                    System.err.println("ERRORE 199:Errore di Input");
                                    isDone = false;
                                    redo = false;
                            }
                        } while (!isDone);

                    } while (redo);
                    //menu = true;
                    isDone = false;
                    break;
                case "2":
                case "rimuovere":
                    if (!codaOrdinazioni.vuota()) {
                        do {

                            System.out.println("Che ordinazione vuoi rimuovere? Scrivi Ultima o Specifica");
                            String ordinazioneSwitch = null;
                            do {

                                try {
                                    ordinazioneSwitch = tastiera.readLine();
                                    isDone = true;
                                } catch (IOException e) {
                                    System.err.println("ERRORE 200: Errore di Input");
                                    isDone = false;
                                }

                            } while (!isDone);
                            switch (ordinazioneSwitch.toLowerCase()) {
                                case "1":
                                case "ultima":
                                    codaOrdinazioni.togli();
                                    System.out.println("Ordinazione rimossa");
                                    isDone = true;
                                    break;
                                case "2":
                                case "specifica":
                                    Integer remElem = null;
                                    do {
                                        do {
                                            System.out.print("Inserisci il numero dell'ordinazione che vuoi rimuovere: ");
                                            try {
                                                remElem = Integer.valueOf(tastiera.readLine());
                                                isDone = true;
                                            } catch (IOException e) {
                                                System.err.println("ERRORE 201");
                                                isDone = false;
                                            }
                                        } while (!isDone);

                                        Object obj = codaOrdinazioni.togli(remElem - 1);
                                        if (obj != null) {
                                            System.out.println("Ordinazione rimossa");
                                            isDone = true;
                                        } else {
                                            isDone = false;
                                        }
                                    } while (!isDone);
                                    break;
                                default:
                                    System.err.println("ERRORE 202");
                                    isDone = false;
                                    break;
                            }
                        } while (!isDone);

                    } else {
                        System.err.println("Errore 203: Non c'è nessuna ordinazione");
                        //menu = true;
                    }
                    //menu = true;
                    isDone = false;
                    break;
                case "3":
                case "visualizzare":
                    if (codaOrdinazioni.size()==0) {
                        System.err.println("Errore 204: Non c'è nessuna ordinazione");
                        isDone=false;
                    }else{
                    int d=codaOrdinazioni.size();
                    for (int i=0;i<d;i++){
                        System.out.println(codaOrdinazioni.togli());
                    }
                        System.out.println("Premi Enter per andare avanti");
                        try {
                            String banana=tastiera.readLine();
                        } catch (IOException e) {
                        }
                    }
                    isDone=false;
                    break;

                case "4":
                case "esci":
                    isDone = true;
                    break;
                default:
                    System.err.println("ERRORE 195:Errore di Input");
                    isDone = false;

            }
        } while (!isDone);
    }
}
