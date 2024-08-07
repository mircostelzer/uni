package Controller;

import Model.Gioco;
import View.HandPane;
import View.PlayerPane;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * La classe MainGUI rappresenta l'interfaccia grafica principale del gioco.
 */
public class MainGUI extends BorderPane {
    private Gioco gioco;

    private PlayerPane giocatore1;
    private PlayerPane giocatore2;

    private HandPane mano1;
    private HandPane mano2;

    /**
     * Costruttore per la classe MainGUI.
     * Inizializza la GUI e il gioco associato.
     */
    public MainGUI() {
        super();

        gioco = new Gioco();

        giocatore1 = new PlayerPane(this, gioco.getMano1(), gioco.getMano2());
        giocatore2 = new PlayerPane(this, gioco.getMano2(), gioco.getMano1());
        mano1 = new HandPane(gioco.getMano1());
        mano2 = new HandPane(gioco.getMano2());
        giocatore1.getPescaDallAvversario().setDisable(false);

        AnchorPane ap = new AnchorPane(mano1, mano2);
        AnchorPane.setBottomAnchor(mano2, 0.0);
        AnchorPane.setLeftAnchor(mano2, 160.0);
        AnchorPane.setTopAnchor(mano1, 0.0);
        AnchorPane.setLeftAnchor(mano1, 160.0);

        super.setTop(giocatore2);
        super.setBottom(giocatore1);
        super.setCenter(ap);

        giocatore2.setPadding(new Insets(0, 0, 0, 50));
        giocatore1.setPadding(new Insets(0, 0, 0, 50));
    }

    /**
     * Restituisce l'altro giocatore rispetto a quello passato come argomento.
     *
     * @param giocatore Il giocatore di cui si vuole ottenere l'avversario
     * @return L'avversario del giocatore specificato
     */
    public PlayerPane getOtherPlayer(PlayerPane giocatore){
        if (giocatore == giocatore1)
            return giocatore2;
        else if (giocatore == giocatore2)
            return giocatore1;
        else
            return null;
    }

    /**
     * Restituisce la mano dell'avversario del giocatore specificato.
     *
     * @param giocatore Il giocatore di cui si vuole ottenere la mano dell'avversario
     * @return La mano dell'avversario del giocatore specificato
     */
    public HandPane getAvversario(PlayerPane giocatore) {
        if (giocatore == giocatore1)
            return mano2;
        else if (giocatore == giocatore2)
            return mano1;
        else
            return null;
    }

    /**
     * Restituisce la mano del giocatore specificato.
     *
     * @param giocatore Il giocatore di cui si vuole ottenere la mano
     * @return La mano del giocatore specificato
     */
    public HandPane getCurrent(PlayerPane giocatore){
        if (giocatore == giocatore1)
            return mano1;
        else if (giocatore == giocatore2)
            return mano2;
        else
            return null;
    }

    /**
     * Restituisce l'istanza del gioco associato.
     *
     * @return L'istanza del gioco associato
     */
    public Gioco getGioco() {
        return gioco;
    }
}
