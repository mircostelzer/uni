package Model.Piastrelle;

import Model.Piastrella;
import javafx.scene.shape.Shape;

/**
 * La classe astratta PiastrellaParticolare rappresenta una piastrella con una forma particolare
 * contenuta al suo interno, che estende la classe Piastrella.
 */
public abstract class PiastrellaParticolare extends Piastrella {
    private Shape formaContenuta;
    private int indiceColoreInterno;

    /**
     * Costruttore della classe PiastrellaParticolare.
     *
     * @param codice        Codice della piastrella.
     * @param materiale     Materiale della piastrella.
     * @param prezzo        Prezzo della piastrella.
     * @param lunghezzaLato Lunghezza del lato della piastrella.
     * @param sceltaColore  Se è disponibile la scelta del colore.
     */
    public PiastrellaParticolare(String codice, String materiale, double prezzo, double lunghezzaLato, boolean sceltaColore) {
        super(codice, materiale, prezzo, lunghezzaLato, sceltaColore);
        impostaFormaContenuta();
        if(getSceltaColore()) {
            indiceColoreInterno = 1;
            setFormaInternaAction();
        }
        formaContenuta.setFill(getColoriDisponibili().get(1));
        super.getChildren().add(formaContenuta);
    }

    /**
     * Imposta la forma contenuta all'interno della piastrella.
     *
     * @param formaContenuta La forma da impostare.
     */
    public void setFormaContenuta(Shape formaContenuta) {
        this.formaContenuta = formaContenuta;
    }

    /**
     * Restituisce la lunghezza del lato della figura interna.
     *
     * @return La lunghezza del lato della figura interna.
     */
    public double getLatoFiguraInterna(){
        return getLunghezzaLato()/2;
    }

    /**
     * Metodo astratto per impostare la forma contenuta all'interno della piastrella.
     * Deve essere implementato dalle classi derivate.
     */
    public abstract void impostaFormaContenuta();

    /**
     * Imposta l'evento di click sulla forma contenuta per cambiare il colore.
     */
    private void setFormaInternaAction(){
        formaContenuta.setOnMouseClicked(event -> {
            indiceColoreInterno = incrementaIndice(indiceColoreInterno);
            formaContenuta.setFill(getColoriDisponibili().get(indiceColoreInterno));
            event.consume();
        });
    }
}
