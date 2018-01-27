/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ristorante;

/**
 *
 * @author XenSide
 */
public class Ordine {

    private final int tavolo; //cambiato da String a Int perché il numero di un tavolo non sarà mai altro che un numero intero e stiamo usando una struttura dati eterogenea.
    private final String ordine;

    public Ordine(int tav, String ord) {
        tavolo = tav;
        ordine = ord;
    }

    public void stampa() {
        System.out.println("Tavolo: " + tavolo);
        System.out.println("Ordine: " + ordine);
    }

    @Override
    public String toString(){
        return ("\nTavolo: "+tavolo+"\nOrdine: "+ordine);
    }
    
}
