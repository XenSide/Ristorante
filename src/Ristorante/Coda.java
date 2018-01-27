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

    import java.util.*;
    class Coda {

        private final ArrayList elementi;

        public Coda() {
            elementi = new ArrayList();
        }

        public void aggiungi(Object obj) {
            elementi.add(obj);
        }

        public Object togli() {
            Object obj = null;
            if (elementi.size() > 0) {
                obj = elementi.get(0);
                elementi.remove(0);
            }
            return obj;
        }
        
        public Object togli(int i){ //XenSide: Override per poter cancellare uno specifico ordine.
            Object obj=null;
            if (elementi.size()>i){
            obj = elementi.get(i);
            elementi.remove(i);
            return obj;
            }else{
                System.err.println("ERRORE 1: Questa ordinazione non è esistente");
                return obj=null; //Aiuta a riconoscere l'errore
            }
        }

        public boolean vuota() {
            return elementi.isEmpty();
        }

        public int size() {
            return elementi.size();
        }
    }
