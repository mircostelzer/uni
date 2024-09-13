package Model.Palline.Nemici;

import Model.Direzione;
import Model.Palline.Enemy;
import javafx.scene.paint.Color;

/**
 * Classe che rappresenta una pallina nemica vagante.
 * Estende la classe Enemy.
 */
public class Wanderer extends Enemy {

    /**
     * Costruttore di default della classe Wanderer.
     * Inizializza la pallina vagante con il colore blu scuro.
     */
    public Wanderer() {
        super(Color.DARKBLUE);
    }

    /**
     * Costruttore della classe Wanderer con un colore specificato.
     * Inizializza la pallina vagante con il colore specificato.
     *
     * @param colore Colore della pallina vagante.
     */
    public Wanderer(Color colore) {
        super(colore);
    }

    /**
     * Cambia la direzione della pallina vagante.
     * Assicura che la nuova direzione sia diversa dalla direzione iniziale.
     */
    public void cambiaDirezione(){
        Direzione direzioneIniziale = getDirezione();
        do{
            creaDirezione();
        }while(direzioneIniziale == getDirezione());
    }
}
