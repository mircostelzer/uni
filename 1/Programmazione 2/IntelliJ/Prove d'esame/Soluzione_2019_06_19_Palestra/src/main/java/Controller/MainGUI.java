package Controller;

import Model.Palestra;
import Model.Persona;
import View.CentralPane;
import View.TopPane;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

/**
 * Classe che gestisce l'interfaccia grafica principale dell'applicazione.
 * Estende la classe javafx.scene.layout.AnchorPane.
 */
public class MainGUI extends AnchorPane {
    private Palestra palestra;
    private TopPane topPane;
    private CentralPane centralPane;
    private Button exit;
    private static ArrayList<Persona> currentView;

    /**
     * Costruttore della classe MainGUI.
     * Inizializza la GUI principale con i pulsanti, il pannello superiore e il pannello centrale.
     */
    public MainGUI() {
        super();

        palestra = new Palestra();
        currentView = new ArrayList<>(palestra.getPersone());
        centralPane = new CentralPane(palestra);
        Bottoni bottoni = new Bottoni(centralPane, palestra);
        topPane = new TopPane(bottoni);

        exit = new Button("Exit");
        exit.setOnAction(event -> Platform.exit());

        super.getChildren().addAll(exit, topPane, centralPane);

        AnchorPane.setBottomAnchor(exit, 5.0);
        AnchorPane.setRightAnchor(exit, 5.0);

        AnchorPane.setTopAnchor(topPane, 0.0);
        AnchorPane.setLeftAnchor(topPane, 0.0);

        AnchorPane.setTopAnchor(centralPane, 70.0);
        AnchorPane.setLeftAnchor(centralPane, 30.0);
    }

    /**
     * Restituisce la vista corrente delle persone visualizzate.
     *
     * @return ArrayList di Persona rappresentante la vista corrente.
     */
    public static ArrayList<Persona> getCurrentView() {
        return currentView;
    }

    /**
     * Imposta la vista corrente delle persone visualizzate.
     *
     * @param currentView ArrayList di Persona da impostare come vista corrente.
     */
    public static void setCurrentView(ArrayList<Persona> currentView) {
        MainGUI.currentView = new ArrayList<>(currentView);
    }
}
