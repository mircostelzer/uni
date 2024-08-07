package Model;

import Controller.MainGUI;
import Model.Tessere.TesseraInterface;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * Classe astratta che rappresenta una tessera del gioco. Estende StackPane e implementa TesseraInterface.
 */
public abstract class Tessera extends StackPane implements TesseraInterface {
    MainGUI mg;
    private String contenuto;
    private boolean isCoperta;

    /**
     * Costruttore della tessera.
     *
     * @param mg MainGUI a cui la tessera appartiene.
     */
    public Tessera(MainGUI mg) {
        super();
        this.mg = mg;
        isCoperta = true;
        impostaContenuto();

        setAction();

        super.getChildren().add(creaRettangolo());
    }

    /**
     * Restituisce l'istanza di MainGUI associata a questa tessera.
     *
     * @return Istanza di MainGUI associata a questa tessera.
     */
    public MainGUI getMg() {
        return mg;
    }

    /**
     * Restituisce il contenuto della tessera.
     *
     * @return Contenuto della tessera.
     */
    public String getContenuto() {
        return contenuto;
    }

    /**
     * Imposta il contenuto della tessera.
     *
     * @param contenuto Contenuto da assegnare alla tessera.
     */
    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    /**
     * Metodo astratto per impostare il contenuto della tessera.
     */
    public abstract void impostaContenuto();

    /**
     * Mostra il contenuto della tessera.
     */
    public void scopri(){
        isCoperta = false;
        Text t = new Text(contenuto);
        super.getChildren().add(t);
    }

    /**
     * Nasconde il contenuto della tessera.
     */
    public void nascondi(){
        isCoperta = true;
        super.getChildren().clear();
        super.getChildren().add(creaRettangolo());
    }

    private void setAction(){
        setOnMouseClicked(event -> {
            if(isCoperta)
                scopri();
            else
                nascondi();
        });
    }

    /**
     * Crea un rettangolo che rappresenta la grafica della tessera.
     *
     * @return Rettangolo che rappresenta la tessera.
     */
    public Rectangle creaRettangolo(){
        Rectangle r = new Rectangle(40, 40);
        r.setFill(Color.YELLOW);
        r.setStroke(Color.BLACK);
        return r;
    }

    /**
     * Restituisce una rappresentazione testuale della tessera.
     *
     * @return Rappresentazione testuale della tessera.
     */
    @Override
    public String toString() {
        return getContenuto();
    }
}
