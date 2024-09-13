package Model;

import javafx.scene.shape.Shape;

/**
 * La classe astratta Ostacolo rappresenta un ostacolo con una forma specifica.
 * Questa classe è progettata per essere estesa da altre classi che definiscono tipi specifici di ostacoli.
 */
public abstract class Ostacolo {
    /**
     * La forma dell'ostacolo.
     */
    protected Shape shape;

    /**
     * Costruttore di default per la classe Ostacolo.
     */
    public Ostacolo() {
    }

    /**
     * Restituisce la forma dell'ostacolo.
     *
     * @return la forma dell'ostacolo
     */
    public Shape getShape() {
        return shape;
    }
}
