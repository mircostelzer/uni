package View;

import Controller.MainGUI;
import Model.Gioco;
import Model.Mano;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 * La classe PlayerPane rappresenta il pannello dei controlli per il giocatore.
 * Contiene pulsanti per eseguire azioni come pescare carte dall'avversario, cercare coppie e pescare dal mazzo.
 */
public class PlayerPane extends HBox {
    private Mano current; // Mano del giocatore corrente
    private Mano avversario; // Mano dell'avversario

    private Text nome; // Etichetta del nome del giocatore
    private Button pescaDallAvversario; // Pulsante per pescare dall'avversario
    private Button cercaCoppie; // Pulsante per cercare le coppie
    private Button pescaDalMazzo; // Pulsante per pescare dal mazzo

    /**
     * Costruttore per la classe PlayerPane.
     *
     * @param mg               MainGUI associata al pannello
     * @param giocatoreCorrente La mano del giocatore corrente
     * @param avversario        La mano dell'avversario
     */
    public PlayerPane(MainGUI mg, Mano giocatoreCorrente, Mano avversario) {
        super();

        Gioco g = mg.getGioco();
        current = giocatoreCorrente;
        this.avversario = avversario;

        nome = new Text(giocatoreCorrente.getGiocatore());
        pescaDallAvversario = new Button("Pesca dall'avversario");
        cercaCoppie = new Button("Cerca le coppie");
        pescaDalMazzo = new Button("Pesca dal mazzo");

        pescaDallAvversario.setDisable(true);
        cercaCoppie.setDisable(true);
        pescaDalMazzo.setDisable(true);

        setPescaDallAvversarioAction(mg, g);
        setCercaCoppieAction(mg, g);
        setPescaDalMazzo(mg, g);

        super.getChildren().addAll(nome, pescaDallAvversario, cercaCoppie, pescaDalMazzo);
        super.setSpacing(10);
    }

    /**
     * Restituisce il pulsante per pescare dall'avversario.
     *
     * @return Il pulsante per pescare dall'avversario
     */
    public Button getPescaDallAvversario() {
        return pescaDallAvversario;
    }

    // METODI PRIVATI

    /**
     * Imposta l'azione del pulsante "Pesca dall'avversario".
     *
     * @param mg La MainGUI associata
     * @param g  Il Gioco associato
     */
    private void setPescaDallAvversarioAction(MainGUI mg, Gioco g) {
        pescaDallAvversario.setOnAction(event -> {
            System.out.println(current.getGiocatore() + " PESCO DALL'AVVERSARIO:");
            g.pescaDallAvversario(current, avversario);

            aggiornaMani(mg);
            stampaMani();

            if (checkWin(avversario))
                displayAlert(mg, avversario);
            else {
                pescaDallAvversario.setDisable(true);
                cercaCoppie.setDisable(false);
            }
        });
    }

    /**
     * Imposta l'azione del pulsante "Cerca coppie".
     *
     * @param mg La MainGUI associata
     * @param g  Il Gioco associato
     */
    private void setCercaCoppieAction(MainGUI mg, Gioco g) {
        cercaCoppie.setOnAction(event -> {
            System.out.println(current.getGiocatore() + " SCARTO LE COPPIE:");
            if (g.scartaCoppie(current)) {
                cercaCoppie.setDisable(true);
                mg.getOtherPlayer(this).pescaDallAvversario.setDisable(false);
                System.out.println(current.getGiocatore() + ": HO SCARTATO NON PESCO");

                aggiornaMani(mg);
                stampaMani();

                if (checkWin(current)) {
                    displayAlert(mg, current);
                } else
                    System.out.println("\nTURNO DI " + avversario.getGiocatore());
            } else {
                cercaCoppie.setDisable(true);
                pescaDalMazzo.setDisable(false);
                aggiornaMani(mg);
                stampaMani();
            }
        });
    }

    /**
     * Imposta l'azione del pulsante "Pesca dal mazzo".
     *
     * @param mg La MainGUI associata
     * @param g  Il Gioco associato
     */
    private void setPescaDalMazzo(MainGUI mg, Gioco g) {
        pescaDalMazzo.setOnAction(event -> {
            System.out.println(current.getGiocatore() + " NON HO SCARTATO, PESCO DAL MAZZO");
            g.pescaDalMazzo(current);

            aggiornaMani(mg);
            stampaMani();

            pescaDalMazzo.setDisable(true);
            mg.getOtherPlayer(this).pescaDallAvversario.setDisable(false);

            System.out.println("\nTURNO DI " + avversario.getGiocatore());
        });
    }

    /**
     * Aggiorna le mani dei giocatori nella GUI.
     *
     * @param mg La MainGUI associata
     */
    private void aggiornaMani(MainGUI mg) {
        mg.getAvversario(this).creaMano(avversario.getCarte());
        mg.getCurrent(this).creaMano(current.getCarte());
    }

    /**
     * Stampa le mani dei giocatori nella console.
     */
    private void stampaMani() {
        System.out.println(current.toString());
        System.out.println(avversario.toString());
    }

    /**
     * Mostra un messaggio di vittoria e disabilita i pulsanti.
     *
     * @param mg La MainGUI associata
     * @param m  La Mano del giocatore che ha vinto
     */
    private void displayAlert(MainGUI mg, Mano m) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("GAME OVER!");
        a.setContentText(m.getGiocatore() + " HA VINTO!");
        a.show();
        disabilitaBottoni();
        mg.getOtherPlayer(this).disabilitaBottoni();
        System.out.println(current.getGiocatore() + " HA VINTO!");
    }

    /**
     * Controlla se un giocatore ha vinto.
     *
     * @param m La Mano del giocatore da controllare
     * @return true se la mano del giocatore è vuota, altrimenti false
     */
    private boolean checkWin(Mano m) {
        return m.getCarte().isEmpty();
    }

    /**
     * Disabilita tutti i pulsanti nel pannello.
     */
    private void disabilitaBottoni() {
        pescaDalMazzo.setDisable(true);
        pescaDallAvversario.setDisable(true);
        cercaCoppie.setDisable(true);
    }
}
