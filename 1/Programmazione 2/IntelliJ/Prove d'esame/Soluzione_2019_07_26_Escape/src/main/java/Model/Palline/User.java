package Model.Palline;

import Model.Direzione;
import Model.Pallina;
import javafx.scene.paint.Color;

/**
 * Classe che rappresenta una pallina controllata dall'utente.
 * Estende la classe astratta Pallina.
 */
public class User extends Pallina {

    /**
     * Costruttore della classe User.
     * Inizializza la pallina dell'utente con il colore arancione.
     */
    public User() {
        super(Color.ORANGE);
    }

    /**
     * Muove la pallina dell'utente nella direzione specificata.
     *
     * @param direzione Direzione in cui muovere la pallina.
     */
    public void muoviInDirezione(Direzione direzione){
        if(direzione.equals(Direzione.SU)){
            setCenterY(getCenterY() - 10);
        } else if(direzione.equals(Direzione.GIU)){
            setCenterY(getCenterY() + 10);
        } else if(direzione.equals(Direzione.DESTRA)){
            setCenterX(getCenterX() + 10);
        } else if(direzione.equals(Direzione.SINISTRA)){
            setCenterX(getCenterX() - 10);
        } else if(direzione.equals(Direzione.ALTO_DESTRA)){
            setCenterX(getCenterX() + 10);
            setCenterY(getCenterY() - 10);
        } else if(direzione.equals(Direzione.ALTO_SINISTRA)){
            setCenterY(getCenterY() - 10);
            setCenterX(getCenterX() - 10);
        } else if(direzione.equals(Direzione.BASSO_DESTRA)){
            setCenterY(getCenterY() + 10);
            setCenterX(getCenterX() + 10);
        } else if (direzione.equals(Direzione.BASSO_SINISTRA)){
            setCenterY(getCenterY() + 10);
            setCenterX(getCenterX() - 10);
        }
    }
}
