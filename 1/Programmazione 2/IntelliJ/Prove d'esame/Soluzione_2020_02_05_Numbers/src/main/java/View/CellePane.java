package View;

import Controller.MainGUI;
import Model.*;
import Model.CelleCentrali.CellaBlu;
import Model.CelleCentrali.CellaGrigia;
import Model.CelleLaterali.CellaRossa;
import Model.CelleLaterali.CellaVerde;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Random;

/**
 * La classe CellePane rappresenta una griglia personalizzata di celle.
 */
public class CellePane extends GridPane {
    private MainGUI mg;

    /**
     * Costruisce un nuovo oggetto CellePane con il controller MainGUI specificato.
     *
     * @param mg il controller MainGUI
     */
    public CellePane(MainGUI mg) {
        super();
        this.mg = mg;
        creaGriglia();
    }

    /**
     * Crea e popola la griglia di celle.
     */
    private void creaGriglia() {
        ArrayList<CellaLaterale> celleLaterali = new ArrayList<>(8);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Cella cella;
                if (i == 4 && j == 4) {
                    cella = new CellaVuota();
                } else if (j < 4 && i < 4) {
                    Random r = new Random();
                    if (r.nextBoolean())
                        cella = new CellaGrigia();
                    else
                        cella = new CellaBlu();
                } else if (j == 4) {
                    cella = new CellaVerde(this, i);
                    celleLaterali.add((CellaLaterale) cella);
                } else {
                    cella = new CellaRossa(this, j);
                    celleLaterali.add((CellaLaterale) cella);
                }
                super.add(cella, j, i);
            }
        }

        impostaContenutoLaterali(celleLaterali);
    }

    /**
     * Restituisce l'elemento nella posizione specificata nella griglia.
     *
     * @param x la coordinata x (colonna)
     * @param y la coordinata y (riga)
     * @return l'elemento nella posizione specificata, o null se non esiste
     */
    private Node getElementAt(int x, int y) {
        for (Node node : super.getChildren()) {
            Integer rowIndex = GridPane.getRowIndex(node);
            Integer colIndex = GridPane.getColumnIndex(node);

            if (rowIndex != null && colIndex != null && rowIndex == y && colIndex == x) {
                return node;
            }
        }
        return null;
    }

    /**
     * Restituisce il valore totale della riga specificata.
     *
     * @param row la riga di cui calcolare il valore
     * @return il valore totale della riga
     */
    public int getValoreRiga(int row) {
        int valoreRiga = 0;
        for (int i = 0; i < 4; i++)
            valoreRiga += ((Cella)getElementAt(i, row)).getContenuto();
        return valoreRiga;
    }

    /**
     * Restituisce il valore totale della colonna specificata.
     *
     * @param col la colonna di cui calcolare il valore
     * @return il valore totale della colonna
     */
    public int getValoreColonna(int col) {
        int valoreColonna = 0;
        for (int i = 0; i < 4; i++)
            valoreColonna += ((Cella) getElementAt(col, i)).getContenuto();
        return valoreColonna;
    }

    /**
     * Imposta il contenuto delle celle laterali.
     *
     * @param celleLaterali la lista delle celle laterali da impostare
     */
    private void impostaContenutoLaterali(ArrayList<CellaLaterale> celleLaterali) {
        for (CellaLaterale c : celleLaterali)
            c.impostaContenuto();
    }

    /**
     * Aggiorna il contenuto della colonna selezionata.
     */
    public void aggiornaColonna() {
        for (int i = 0; i < 4; i++) {
            ((CellaCentrale) getElementAt(MainGUI.getVal() - 1, i)).aggiornaValore();
        }
        aggiornaLaterali();
    }

    /**
     * Aggiorna il contenuto della riga selezionata.
     */
    public void aggiornaRiga() {
        for (int i = 0; i < 4; i++) {
            ((CellaCentrale) getElementAt(i, MainGUI.getVal() - 1)).aggiornaValore();
        }
        aggiornaLaterali();
    }

    /**
     * Aggiorna il contenuto delle celle laterali e verifica le condizioni di vittoria e sconfitta.
     */
    private void aggiornaLaterali() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if ((i == 4 || j == 4) && !(getElementAt(i, j) instanceof CellaVuota)) {
                    ((CellaLaterale) getElementAt(i, j)).impostaContenuto();
                }
            }
        }

        if (checkWin() && checkLoose()) {
            AlertDisplayer.displayAlertDraw();
            mg.getBottoni().disabilitaBottoni();
        } else if (checkWin()) {
            AlertDisplayer.displayAlertWin();
            mg.getBottoni().disabilitaBottoni();
        } else if (checkLoose()) {
            AlertDisplayer.displayAlertLoose();
            mg.getBottoni().disabilitaBottoni();
        }
    }

    /**
     * Verifica se la condizione di vittoria è soddisfatta.
     *
     * @return true se una delle celle verdi ha contenuto pari a 10, altrimenti false
     */
    private boolean checkWin() {
        for (int i = 0; i < 4; i++) {
            if (((CellaVerde) getElementAt(4, i)).getContenuto() == 10)
                return true;
        }
        return false;
    }

    /**
     * Verifica se la condizione di sconfitta è soddisfatta.
     *
     * @return true se una delle celle rosse ha contenuto pari a 10, altrimenti false
     */
    private boolean checkLoose() {
        for (int i = 0; i < 4; i++) {
            if (((CellaRossa) getElementAt(i, 4)).getContenuto() == 10)
                return true;
        }
        return false;
    }
}