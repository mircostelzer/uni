package Model;

import Controller.MainGUI;
import Model.Ostacoli.OstacoloBlock;
import Model.Ostacoli.OstacoloPenalty;
import View.Omino;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.Random;

/**
 * La classe CoordinateHelper gestisce la logica per la generazione delle coordinate
 * degli ostacoli e il controllo delle collisioni per il gioco.
 */
public class CoordinateHelper {
    private MainGUI mg;
    private Omino omino;
    private Stats stats;

    /**
     * Costruttore della classe CoordinateHelper.
     *
     * @param mg il pannello principale dell'interfaccia grafica
     * @param omino l'omino del gioco
     * @param stats le statistiche del gioco
     */
    public CoordinateHelper(MainGUI mg, Omino omino, Stats stats) {
        this.mg = mg;
        this.omino = omino;
        this.stats = stats;
    }

    /**
     * Trova coordinate valide per la generazione di un ostacolo di penalità.
     *
     * @return un oggetto Coordinate con le nuove coordinate
     */
    private Coordinate trovaCoordinatePenalty() {
        Random random = new Random();
        double newX, newY;
        do {
            newX = 10 + random.nextDouble() * (500 - 2 * 10);
            newY = 10 + random.nextDouble() * (200 - 2 * 10);
        } while (isColliding(newX, newY));

        return new Coordinate(newX, newY);
    }

    /**
     * Trova coordinate valide per la generazione di un ostacolo a blocco.
     *
     * @return un oggetto Coordinate con le nuove coordinate
     */
    private Coordinate trovaCoordinateBlock() {
        Random random = new Random();
        double newX, newY;
        do {
            newX = random.nextDouble() * (500 - 20);
            newY = random.nextDouble() * (200 - 20);
        } while (isCollidingSquare(newX, newY));
        return new Coordinate(newX, newY);
    }

    /**
     * Controlla se c'è una collisione tra l'omino e un quadrato alla posizione specificata.
     *
     * @param rectX la coordinata x del rettangolo
     * @param rectY la coordinata y del rettangolo
     * @return true se c'è una collisione, false altrimenti
     */
    private boolean isCollidingSquare(double rectX, double rectY) {
        double closestX = clamp(omino.getTesta().getCenterX(), rectX, rectX + 20);
        double closestY = clamp(omino.getTesta().getCenterY(), rectY, rectY + 20);

        double distanceX = omino.getTesta().getCenterX() - closestX;
        double distanceY = omino.getTesta().getCenterY() - closestY;

        double distanceSquared = (distanceX * distanceX) + (distanceY * distanceY);
        return distanceSquared < (omino.getTesta().getRadius() * omino.getTesta().getRadius());
    }

    /**
     * Restringe un valore entro un intervallo specificato.
     *
     * @param value il valore da restringere
     * @param min il valore minimo dell'intervallo
     * @param max il valore massimo dell'intervallo
     * @return il valore ristretto
     */
    private double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(max, value));
    }

    /**
     * Controlla se c'è una collisione tra l'omino e un punto specificato.
     *
     * @param newX la coordinata x del punto
     * @param newY la coordinata y del punto
     * @return true se c'è una collisione, false altrimenti
     */
    private boolean isColliding(double newX, double newY) {
        double distanza = Math.sqrt(Math.pow(omino.getTesta().getCenterX() - newX, 2) + Math.pow(omino.getTesta().getCenterY() - newY, 2));
        return distanza < (omino.getTesta().getRadius() + 10);
    }

    /**
     * Genera ostacoli nel pannello di gioco in posizioni valide.
     */
    public void spawnOstacoli() {
        for (int i = 0; i < 3; i++) {
            OstacoloBlock ob = new OstacoloBlock();
            Rectangle r = (Rectangle) ob.getShape();
            Coordinate c = trovaCoordinateBlock();
            r.setLayoutX(c.getX());
            r.setLayoutY(c.getY());

            OstacoloPenalty op = new OstacoloPenalty();
            Circle circle = (Circle) op.getShape();
            Coordinate k = trovaCoordinatePenalty();
            circle.setCenterX(k.getX());
            circle.setCenterY(k.getY());

            mg.getChildren().addAll(ob.getShape(), op.getShape());
            mg.getOstacoli().add(ob.getShape());
            mg.getOstacoli().add(op.getShape());
        }
    }

    /**
     * Controlla se c'è una collisione tra l'omino e uno degli ostacoli.
     *
     * @return l'ostacolo con cui l'omino ha colliso, o null se non c'è collisione
     */
    public Shape checkCollision() {
        for (Shape o : mg.getOstacoli()) {
            if (omino.getBoundsInParent().intersects(o.getBoundsInParent())) {
                return o;
            }
        }
        return null;
    }

    /**
     * Controlla se l'omino ha raggiunto il traguardo e visualizza un messaggio di vittoria se necessario.
     *
     * @return true se l'omino ha vinto, false altrimenti
     */
    public boolean checkWin() {
        boolean w = false;

        double playerX = omino.getLayoutX();
        double playerY = omino.getLayoutY();
        double finishLineX = mg.getTraguardo().getLayoutX();
        double finishLineY = mg.getTraguardo().getLayoutY();

        if (playerX >= finishLineX && playerY >= finishLineY && playerY <= finishLineY + 200) {
            AlertDisplayer.displayAlert(stats.getPunteggio());
            w = true;
        }

        return w;
    }
}
