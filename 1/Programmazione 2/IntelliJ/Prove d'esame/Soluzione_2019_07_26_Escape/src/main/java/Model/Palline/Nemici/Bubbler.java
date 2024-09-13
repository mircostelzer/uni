package Model.Palline.Nemici;

import javafx.scene.paint.Color;

import java.util.Random;

/**
 * Classe che rappresenta una pallina nemica "Bubbler".
 * Estende la classe Wanderer e aggiunge un comportamento di aumento del raggio.
 */
public class Bubbler extends Wanderer {

    /**
     * Costruttore di default della classe Bubbler.
     * Inizializza la pallina Bubbler con il colore azzurro.
     */
    public Bubbler() {
        super(Color.LIGHTBLUE);
    }

    /**
     * Muove la pallina nella direzione attuale e aumenta casualmente il raggio.
     * Override del metodo muovi della classe Wanderer.
     */
    @Override
    public void muovi() {
        super.muovi();
        aumentaRaggio();
    }

    /**
     * Aumenta casualmente il raggio della pallina.
     * C'è una probabilità di 1 su 10 che il raggio aumenti del 20%.
     */
    private void aumentaRaggio(){
        Random r = new Random();
        if(r.nextInt(10) == 0)
            setRadius(getRadius() + getRadius()*0.2);
    }
}
