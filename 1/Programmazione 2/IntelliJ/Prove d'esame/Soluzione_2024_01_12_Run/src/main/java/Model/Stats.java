package Model;

import javafx.scene.text.Text;

/**
 * La classe Stats estende Text e gestisce il punteggio e le vite del giocatore,
 * aggiornando il testo visualizzato con le informazioni correnti.
 */
public class Stats extends Text {
    private int punteggio;
    private int vite;

    /**
     * Costruttore della classe Stats.
     * Inizializza il punteggio a 0 e le vite a 3, aggiornando il testo visualizzato.
     */
    public Stats() {
        super();
        punteggio = 0;
        vite = 3;
        setStatsText();
    }

    /**
     * Imposta il testo visualizzato con il punteggio e le vite correnti.
     */
    public void setStatsText() {
        super.setText(toString());
    }

    /**
     * Applica una penalità al punteggio sottraendo 500 punti.
     * Aggiorna il testo visualizzato.
     */
    public void penalitaPunteggio() {
        punteggio -= 500;
        setStatsText();
    }

    /**
     * Aggiunge un bonus al punteggio incrementandolo di 100 punti.
     * Aggiorna il testo visualizzato.
     */
    public void bonusPunteggio() {
        punteggio += 100;
        setStatsText();
    }

    /**
     * Decrementa il numero di vite di 1.
     * Aggiorna il testo visualizzato.
     */
    public void setVite() {
        vite--;
        setStatsText();
    }

    /**
     * Restituisce il numero di vite rimanenti.
     *
     * @return il numero di vite rimanenti
     */
    public int getVite() {
        return vite;
    }

    /**
     * Restituisce il punteggio corrente.
     *
     * @return il punteggio corrente
     */
    public int getPunteggio() {
        return punteggio;
    }

    /**
     * Restituisce una rappresentazione in formato stringa delle statistiche,
     * inclusi il punteggio e le vite.
     *
     * @return una stringa rappresentante il punteggio e le vite
     */
    @Override
    public String toString() {
        return "Punteggio: " + punteggio + "\t" + "Vite: " + vite;
    }
}
