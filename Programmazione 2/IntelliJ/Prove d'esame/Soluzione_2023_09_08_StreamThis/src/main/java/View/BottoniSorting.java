package View;

import Controller.MainGUI;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * Questa classe gestisce i bottoni di ordinamento per nome, anno e tipo.
 */
public class BottoniSorting extends VBox {
    private Button nome;
    private Button anno;
    private Button tipo;

    /**
     * Costruisce una nuova istanza di BottoniSorting.
     *
     * @param mg L'istanza di MainGUI usata per gestire le azioni dei bottoni.
     */
    public BottoniSorting(MainGUI mg) {
        super();
        nome = new Button("Nome");
        anno = new Button("Anno");
        tipo = new Button("Tipo");

        setNomeAction(mg);
        setAnnoAction(mg);
        setTipoAction(mg);

        getChildren().addAll(new Text("Ordina Per:"), nome, anno, tipo);
        setSpacing(10);
    }

    /**
     * Imposta l'azione per il bottone di ordinamento per tipo.
     *
     * @param mg L'istanza di MainGUI usata per gestire l'azione del bottone.
     */
    private void setTipoAction(MainGUI mg) {
        tipo.setOnAction(event -> {
            mg.getTitoliDB().sortByType();
            MainGUI.resetGeneralIndex();
            mg.getTitoliPane().aggiornaTitoliPane();
        });
    }

    /**
     * Imposta l'azione per il bottone di ordinamento per anno.
     *
     * @param mg L'istanza di MainGUI usata per gestire l'azione del bottone.
     */
    private void setAnnoAction(MainGUI mg) {
        anno.setOnAction(event -> {
            mg.getTitoliDB().sortByAnno();
            MainGUI.resetGeneralIndex();
            mg.getTitoliPane().aggiornaTitoliPane();
        });
    }

    /**
     * Imposta l'azione per il bottone di ordinamento per nome.
     *
     * @param mg L'istanza di MainGUI usata per gestire l'azione del bottone.
     */
    private void setNomeAction(MainGUI mg) {
        nome.setOnAction(event -> {
            mg.getTitoliDB().sortByName();
            MainGUI.resetGeneralIndex();
            mg.getTitoliPane().aggiornaTitoliPane();
        });
    }
}
