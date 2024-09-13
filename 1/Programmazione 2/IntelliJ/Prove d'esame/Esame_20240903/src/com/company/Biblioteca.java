package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementazione di un archivio e di un <code>main</code> di test della classe
 */
public class Biblioteca {

    List<Pubblicazione> pubblicazioni = new ArrayList<>();

    /**
     * Costruttore della classe <code>Biblioteca</code> con inizializzazione di dati di esempio.
     */
    public Biblioteca() {
        add(new Libro("Moby Dick", 1851, "Melville", 720, true));
        add(new Film("1984",1984, "Orwell",113,  true ));
        add(new EBook("Moby Dick", 2016, "Melville", 720, "EPUB", true));
        add(new Libro("1984", 1949, "Orwell",328, false));
        add(new Libro("Moby Dick", 1851, "Melville", 720, false));
    }

    /**
     * Metodo per l'aggiunta di una pubblicazione all'archivio
     * @param pubblicazione la pubblicazione da aggiungere all'archivio
     */
    public void add(Pubblicazione pubblicazione) {
        pubblicazioni.add(pubblicazione);
    }

    /**
     * Metodo per recuperare una pubblicazione dall'archivio
     * @param index indice nel'archivio della pubblicazione da restituire
     * @return la pubblicazione richiesta
     */
    public Pubblicazione get(int index) {
        return pubblicazioni.get(index);
    }

    /**
     * Restituisce il numero di pubblicazioni archiviate
     *
     * @return numero di pubblicazioni in archivio
     */
    public int size() {
        return pubblicazioni.size();
    }

    /**
     * Metodo per stampare in console tutte le pubblicazioni archiviate
     */
    public void printAll() {
        for(Pubblicazione p : pubblicazioni) {
            System.out.println(p);
        }
    }

    /**
     * Metodo per testare le funzionalità della libreria
     * @param args argomenti da riga di commando
     */
    public static void main(String args[]) {
        Biblioteca bib = new Biblioteca();

        System.out.println("-------------TUTTI------------------------");
        bib.printAll();

        System.out.println("\n-------------Prestiti 1------------------------");
        System.out.format("Prestito 1 %b%n", bib.pubblicazioni.get(0).richiediPrestito(5));
        System.out.format("Prestito 2 %b%n", bib.pubblicazioni.get(1).richiediPrestito(5));
        System.out.format("Prestito 4 %b%n", bib.pubblicazioni.get(3).richiediPrestito(5));

        System.out.println();
        bib.printAll();

        System.out.println("\n-------------Prestiti 2------------------------");
        System.out.format("Prestito 2 %b%n", bib.pubblicazioni.get(1).richiediPrestito(20));
        System.out.format("Prestito 3 %b%n", bib.pubblicazioni.get(2).richiediPrestito(20));

        System.out.println();
        bib.printAll();

        System.out.println("\n-------------Ordinati per titolo/anno-----------------------");
        bib.pubblicazioni.sort(null);

        bib.printAll();

        System.out.println("\n-------------Ordinati per id e restituiti-----------------------");
        bib.pubblicazioni.sort(new ComparatorByNumeroArchivio());
        for(Pubblicazione p: bib.pubblicazioni)
            p.restituisci();

        bib.printAll();
    }
}
