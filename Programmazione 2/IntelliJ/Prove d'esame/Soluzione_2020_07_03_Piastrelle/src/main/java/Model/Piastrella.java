package Model;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

/**
 * La classe Piastrella rappresenta una piastrella con specifici attributi e funzionalità per
 * la gestione del colore e altre proprietà.
 */
public class Piastrella extends StackPane {
    private final int LATO_PIASTRELLA = 130;
    private String codice;
    private String materiale;
    private double prezzo;
    private double lunghezzaLato;
    private Boolean sceltaColore;

    private Colori coloriDisponibili;
    private int indiceColoreBase;

    /**
     * Costruttore della classe Piastrella.
     *
     * @param codice        Codice della piastrella.
     * @param materiale     Materiale della piastrella.
     * @param prezzo        Prezzo della piastrella.
     * @param lunghezzaLato Lunghezza del lato della piastrella.
     * @param sceltaColore  Se è disponibile la scelta del colore.
     */
    public Piastrella(String codice, String materiale, double prezzo, double lunghezzaLato, boolean sceltaColore) {
        super();
        coloriDisponibili = new Colori();
        this.codice = codice;
        this.materiale = materiale;
        this.prezzo = prezzo;
        this.lunghezzaLato = lunghezzaLato;
        this.sceltaColore = sceltaColore;

        if(sceltaColore) {
            indiceColoreBase = 0;
            impostaEventoSuper();
        }

        Rectangle r = new Rectangle(LATO_PIASTRELLA, LATO_PIASTRELLA);
        r.setFill(coloriDisponibili.get(0));
        super.getChildren().add(r);
    }

    /**
     * Restituisce i colori disponibili.
     *
     * @return I colori disponibili.
     */
    public Colori getColoriDisponibili() {
        return coloriDisponibili;
    }

    /**
     * Restituisce se è possibile scegliere il colore.
     *
     * @return true se è possibile scegliere il colore, false altrimenti.
     */
    public Boolean getSceltaColore() {
        return sceltaColore;
    }

    /**
     * Restituisce la lunghezza del lato della piastrella.
     *
     * @return La lunghezza del lato della piastrella.
     */
    public double getLunghezzaLato() {
        return lunghezzaLato;
    }

    /**
     * Incrementa l'indice e lo reimposta a 0 se raggiunge 6.
     *
     * @param indice L'indice da incrementare.
     * @return L'indice incrementato.
     */
    public int incrementaIndice(int indice){
        indice++;
        if(indice == 6)
            indice = 0;
        return indice;
    }

    /**
     * Imposta l'evento di click sulla piastrella per cambiare il colore.
     */
    private void impostaEventoSuper(){
        super.setOnMouseClicked(event -> {
            Rectangle r = (Rectangle) (super.getChildren().get(0));
            indiceColoreBase = incrementaIndice(indiceColoreBase);
            r.setFill(coloriDisponibili.get(indiceColoreBase));
            event.consume();
        });
    }

    /**
     * Restituisce una stringa che indica se è possibile scegliere il colore.
     *
     * @return "SI" se è possibile scegliere il colore, "NO" altrimenti.
     */
    private String sceltaColore(){
        return (sceltaColore)? "SI" : "NO";
    }

    /**
     * Restituisce una rappresentazione in stringa della piastrella.
     *
     * @return Una stringa che rappresenta la piastrella.
     */
    @Override
    public String toString() {
        return  "Codice: " + codice + "\n" +
                "materiale: " + materiale + "\n" +
                "costo: " + prezzo + " EUR" + "\n" +
                "dimensione: " + lunghezzaLato + " cm" + "\n" +
                "scelta colore: " + sceltaColore();
    }
}
