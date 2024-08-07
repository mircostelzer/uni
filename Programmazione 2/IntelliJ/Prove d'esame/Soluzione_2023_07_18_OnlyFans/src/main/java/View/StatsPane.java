package View;

import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 * Classe per visualizzare il pannello delle statistiche.
 */
public class StatsPane extends HBox {
    private int capitale;
    private int spesaMensile;
    private int mesiTrascorsi;

    private Text capitaleText;
    private Text spesaMensileText;
    private Text mesiTrascorsiText;

    /**
     * Costruttore per creare il pannello delle statistiche.
     */
    public StatsPane() {
        super();
        capitale = 100;
        spesaMensile = 0;
        mesiTrascorsi = 0;

        capitaleText = new Text("Capitale: " + capitale);
        spesaMensileText = new Text("Spesa Mensile: " + spesaMensile);
        mesiTrascorsiText = new Text("Mesi Trascorsi: " + mesiTrascorsi);

        super.getChildren().addAll(capitaleText, spesaMensileText, mesiTrascorsiText);
        setSpacing(5);
    }

    /**
     * Restituisce il capitale corrente.
     *
     * @return Il capitale corrente.
     */
    public int getCapitale() {
        return capitale;
    }

    /**
     * Restituisce la spesa mensile corrente.
     *
     * @return La spesa mensile corrente.
     */
    public int getSpesaMensile() {
        return spesaMensile;
    }

    /**
     * Incrementa il numero di mesi trascorsi e aggiorna il testo corrispondente.
     */
    public void incrementaMesiTrascorsi() {
        mesiTrascorsi++;
        mesiTrascorsiText.setText("Mesi Trascorsi: " + mesiTrascorsi);
    }

    /**
     * Aggiorna il capitale aggiungendo la somma specificata e aggiorna il testo corrispondente.
     *
     * @param somma La somma da aggiungere al capitale.
     */
    public void aggiornaCapitale(int somma) {
        capitale += somma;
        capitaleText.setText("Capitale: " + capitale);
    }

    /**
     * Aggiorna la spesa mensile aggiungendo la somma specificata e aggiorna il testo corrispondente.
     *
     * @param somma La somma da aggiungere alla spesa mensile.
     */
    public void aggiornaSpesaMensile(int somma) {
        spesaMensile += somma;
        spesaMensileText.setText("Spesa Mensile: " + spesaMensile);
    }
}
