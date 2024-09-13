package Model.Palline;

import Model.Direzione;
import Model.Pallina;
import javafx.scene.paint.Color;

import java.util.Random;

/**
 * Classe astratta che rappresenta una pallina nemica.
 * Estende la classe Pallina.
 */
public abstract class Enemy extends Pallina {
    private Direzione direzione;

    /**
     * Costruttore della classe Enemy.
     * Inizializza una pallina nemica con un determinato colore e crea una direzione casuale.
     *
     * @param colore Colore della pallina nemica.
     */
    public Enemy(Color colore) {
        super(colore);
        creaDirezione();
    }

    /**
     * Restituisce la direzione corrente della pallina nemica.
     *
     * @return Direzione corrente della pallina nemica.
     */
    public Direzione getDirezione() {
        return direzione;
    }

    /**
     * Crea una direzione casuale per la pallina nemica.
     */
    public void creaDirezione(){
        Random r = new Random();
        switch (r.nextInt(8)){
            case 0:
                direzione = Direzione.SU;
                break;
            case 1:
                direzione = Direzione.GIU;
                break;
            case 2:
                direzione = Direzione.DESTRA;
                break;
            case 3:
                direzione = Direzione.SINISTRA;
                break;
            case 4:
                direzione = Direzione.ALTO_DESTRA;
                break;
            case 5:
                direzione = Direzione.ALTO_SINISTRA;
                break;
            case 6:
                direzione = Direzione.BASSO_DESTRA;
                break;
            case 7:
                direzione = Direzione.BASSO_SINISTRA;
                break;
        }
    }

    /**
     * Muove la pallina nemica nella direzione corrente.
     */
    public void muovi(){
        if(getDirezione().equals(Direzione.SU)){
            setCenterY(getCenterY() - 10);
        } else if(getDirezione().equals(Direzione.GIU)){
            setCenterY(getCenterY() + 10);
        } else if(getDirezione().equals(Direzione.DESTRA)){
            setCenterX(getCenterX() + 10);
        } else if(getDirezione().equals(Direzione.SINISTRA)){
            setCenterX(getCenterX() - 10);
        } else if(getDirezione().equals(Direzione.ALTO_DESTRA)){
            setCenterX(getCenterX() + 10);
            setCenterY(getCenterY() - 10);
        } else if(getDirezione().equals(Direzione.ALTO_SINISTRA)){
            setCenterY(getCenterY() - 10);
            setCenterX(getCenterX() - 10);
        } else if(getDirezione().equals(Direzione.BASSO_DESTRA)){
            setCenterY(getCenterY() + 10);
            setCenterX(getCenterX() + 10);
        } else if (getDirezione().equals(Direzione.BASSO_SINISTRA)){
            setCenterY(getCenterY() + 10);
            setCenterX(getCenterX() - 10);
        }
    }
}
