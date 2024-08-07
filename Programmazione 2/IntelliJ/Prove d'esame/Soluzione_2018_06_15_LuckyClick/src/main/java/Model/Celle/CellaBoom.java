package Model.Celle;

import Model.Cella;
import Model.Coordinate;
import Controller.MainGUI;
import View.CellePane;
import javafx.scene.paint.Color;

/**
 * La classe CellaBoom rappresenta una cella speciale che causa un'esplosione quando viene attivata.
 * Quando viene attivata, tutte le celle nella stessa riga e nella stessa colonna vengono rivelate e attivate.
 */
public class CellaBoom extends Cella {
    private Coordinate c; // Coordinate della cella

    /**
     * Costruttore per la classe CellaBoom.
     *
     * @param mg Il controller principale dell'applicazione
     */
    public CellaBoom(MainGUI mg) {
        super(mg, Color.BLUE);
    }

    /**
     * Imposta le coordinate della cella.
     *
     * @param c Le coordinate della cella
     */
    public void setC(Coordinate c) {
        this.c = c;
    }

    /**
     * Metodo per rivelare una cella specifica.
     * Se la cella è una CellaBase, viene rivelata con il colore bianco.
     * Se la cella è una CellaDivisore, viene rivelata con il colore rosso.
     * Se la cella è una CellaMoltiplicatore, viene rivelata con il colore verde.
     * Se la cella è una CellaBoom, viene rivelata con il colore blu.
     *
     * @param cella La cella da rivelare
     */
    private void scopriCella(Cella cella){
        if(cella instanceof CellaBase)
            cella.scopriCella(Color.WHITE);
        else if(cella instanceof CellaDivisore)
            cella.scopriCella(Color.RED);
        else if(cella instanceof CellaMoltiplicatore)
            cella.scopriCella(Color.GREEN);
        else if(cella instanceof CellaBoom)
            cella.scopriCella(Color.BLUE);
    }

    /**
     * Metodo che attiva la cella quando viene scoperta.
     * Attiva tutte le celle nella stessa riga e nella stessa colonna della cella attuale.
     */
    @Override
    public void attivaCella() {
        CellePane cp = getMg().getCellePane();
        Cella cella;

        // Attiva tutte le celle della riga
        for (int i = 0; i < 10; i++) {
            cella = ((Cella)cp.getElementAt(c.getJ(), i));
            scopriCella(cella);
        }

        // Attiva tutte le celle della colonna
        for (int i = 0; i < 10; i++) {
            cella = ((Cella)cp.getElementAt(i, c.getX()));
            scopriCella(cella);
        }
    }

    /**
     * Metodo per impostare il contenuto della cella.
     * Il contenuto della cella è "BOOM!" per indicare che la cella è una cella esplosiva.
     */
    @Override
    public void setCont() {
        super.setContenuto("BOOM!");
    }
}
