package Model.Piastrelle.PiastrelleParticolari;

import Model.Piastrelle.PiastrellaParticolare;
import javafx.scene.shape.Circle;

/**
 * La classe PiastrellaConCerchio rappresenta una piastrella particolare che contiene un cerchio al suo interno.
 */
public class PiastrellaConCerchio extends PiastrellaParticolare {
    /**
     * Costruttore della classe PiastrellaConCerchio.
     *
     * @param codice        Codice della piastrella.
     * @param materiale     Materiale della piastrella.
     * @param prezzo        Prezzo della piastrella.
     * @param lunghezzaLato Lunghezza del lato della piastrella.
     * @param sceltaColore  Se è disponibile la scelta del colore.
     */
    public PiastrellaConCerchio(String codice, String materiale, double prezzo, double lunghezzaLato, boolean sceltaColore) {
        super(codice, materiale, prezzo, lunghezzaLato, sceltaColore);
    }

    /**
     * Implementa il metodo astratto per impostare la forma contenuta come un cerchio.
     */
    @Override
    public void impostaFormaContenuta() {
        Circle c = new Circle(getLatoFiguraInterna());
        setFormaContenuta(c);
    }
}
