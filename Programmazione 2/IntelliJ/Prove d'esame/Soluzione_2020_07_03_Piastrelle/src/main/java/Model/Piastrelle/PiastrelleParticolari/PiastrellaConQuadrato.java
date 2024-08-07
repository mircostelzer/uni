package Model.Piastrelle.PiastrelleParticolari;

import Model.Piastrelle.PiastrellaParticolare;
import javafx.scene.shape.Rectangle;

/**
 * La classe PiastrellaConQuadrato rappresenta una piastrella particolare che contiene un quadrato al suo interno.
 */
public class PiastrellaConQuadrato extends PiastrellaParticolare {
    /**
     * Costruttore della classe PiastrellaConQuadrato.
     *
     * @param codice        Codice della piastrella.
     * @param materiale     Materiale della piastrella.
     * @param prezzo        Prezzo della piastrella.
     * @param lunghezzaLato Lunghezza del lato della piastrella.
     * @param sceltaColore  Se è disponibile la scelta del colore.
     */
    public PiastrellaConQuadrato(String codice, String materiale, double prezzo, double lunghezzaLato, boolean sceltaColore) {
        super(codice, materiale, prezzo, lunghezzaLato, sceltaColore);
    }

    /**
     * Implementa il metodo astratto per impostare la forma contenuta come un quadrato.
     */
    @Override
    public void impostaFormaContenuta() {
        Rectangle r = new Rectangle(getLatoFiguraInterna(), getLatoFiguraInterna());
        setFormaContenuta(r);
    }
}
