package Model;

import Model.Piastrelle.PiastrelleParticolari.PiastrellaConCerchio;
import Model.Piastrelle.PiastrelleParticolari.PiastrellaConQuadrato;

import java.util.ArrayList;

/**
 * La classe Catalogo rappresenta un catalogo di piastrelle.
 * Contiene una lista di diverse piastrelle, comprese quelle con forme particolari.
 */
public class Catalogo {
    private ArrayList<Piastrella> piastrelle;

    /**
     * Costruttore della classe Catalogo.
     * Inizializza la lista di piastrelle con diverse piastrelle predefinite.
     */
    public Catalogo() {
        piastrelle = new ArrayList<>();

        piastrelle.add(new Piastrella           ("P1", "ceramica",  50.0,  50.0, false));
        piastrelle.add(new Piastrella           ("P2", "laminato",  20.0,  80.0, true));
        piastrelle.add(new Piastrella           ("P3", "terracotta",50.0,  40.0, true));
        piastrelle.add(new PiastrellaConQuadrato("B1", "laminato",  100.0, 40.0, false));
        piastrelle.add(new PiastrellaConCerchio ("B2", "ceramica",  120.0, 90.0, true));
        piastrelle.add(new PiastrellaConQuadrato("B3", "terracotta",140.0, 50.0, true));
    }

    /**
     * Restituisce la lista di piastrelle nel catalogo.
     *
     * @return Una lista di oggetti Piastrella.
     */
    public ArrayList<Piastrella> getPiastrelle() {
        return piastrelle;
    }
}
