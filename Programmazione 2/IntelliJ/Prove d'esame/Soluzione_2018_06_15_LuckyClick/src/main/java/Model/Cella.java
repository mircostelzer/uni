package Model;

import Controller.MainGUI;
import View.StatsPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * La classe astratta Cella rappresenta una singola cella del gioco.
 * Ogni cella ha un colore nascosto, un contenuto e uno stato (coperto o scoperto).
 */
public abstract class Cella extends StackPane {
    private MainGUI mg; // Riferimento al controller principale dell'applicazione
    private boolean isCoperta; // Stato della cella (coperta o scoperta)
    private String contenuto; // Contenuto della cella

    /**
     * Costruttore per la classe Cella.
     *
     * @param mg              Il controller principale dell'applicazione
     * @param coloreNascosto  Il colore nascosto della cella
     */
    public Cella(MainGUI mg, Color coloreNascosto) {
        super();

        // Inizializzazione delle variabili di istanza
        this.mg = mg;
        this.isCoperta = true;

        // Creazione e configurazione del rettangolo rappresentante la cella
        Rectangle r = new Rectangle(50, 50);
        r.setFill(Color.YELLOW);
        r.setStroke(Color.BLACK);

        // Impostazione del colore nascosto e delle azioni di click sulla cella
        setCont();
        setSuperAction(coloreNascosto);

        // Aggiunta del rettangolo alla StackPane
        super.getChildren().add(r);
    }

    // Metodo astratto per attivare la cella
    public abstract void attivaCella();

    // Metodo astratto per impostare il contenuto della cella
    public abstract void setCont();

    /**
     * Restituisce il controller principale dell'applicazione.
     *
     * @return Il controller principale dell'applicazione
     */
    public MainGUI getMg() {
        return mg;
    }

    /**
     * Restituisce il contenuto della cella.
     *
     * @return Il contenuto della cella
     */
    public String getContenuto() {
        return contenuto;
    }

    /**
     * Imposta il contenuto della cella.
     *
     * @param contenuto Il nuovo contenuto della cella
     */
    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    // Metodo per scoprire la cella
    public void scopriCella(Color coloreNascosto){
        if(isCoperta){
            super.getChildren().clear();

            Rectangle r = new Rectangle(50, 50);
            r.setFill(coloreNascosto);
            r.setStroke(Color.BLACK);

            Text t = new Text(contenuto);

            super.getChildren().addAll(r, t);

            isCoperta = false;

            attivaCella();
        }
    }

    /**
     * Imposta l'azione del mouse sulla cella.
     *
     * @param coloreNascosto Il colore nascosto della cella
     */
    private void setSuperAction(Color coloreNascosto){
        super.setOnMouseClicked(event -> {
            if(!mg.getStatsPane().isGameOver() && isCoperta){
                StatsPane sp = mg.getStatsPane();
                int nuovoNumeroTentativi = sp.getTentativi() - 1;
                sp.setTentativi(nuovoNumeroTentativi);
                scopriCella(coloreNascosto);
            }
        });
    }
}
