package Controller;

import Model.Palestra;
import View.CentralPane;
import javafx.scene.control.Button;

/**
 * Classe che gestisce i pulsanti dell'interfaccia grafica.
 */
public class Bottoni {
    private Button tutti;
    private Button studenti;
    private Button atleti;
    private Button perNome;
    private Button perEta;

    /**
     * Costruttore della classe Bottoni.
     *
     * @param cp Oggetto CentralPane per l'aggiornamento dell'interfaccia grafica.
     * @param p  Oggetto Palestra per l'accesso ai dati delle persone.
     */
    public Bottoni(CentralPane cp, Palestra p) {
        tutti = new Button("Tutti");
        studenti = new Button("Studenti");
        atleti = new Button("Atleti");
        setTuttiAction(cp, p);
        setStudentiAction(cp, p);
        setAtletiAction(cp, p);

        perNome = new Button("per nome");
        perEta = new Button("per eta");
        setPerNomeAction(cp, p);
        setPerEtaAction(cp, p);
    }

    /**
     * Restituisce il pulsante "Tutti".
     *
     * @return Pulsante "Tutti".
     */
    public Button getTutti() {
        return tutti;
    }

    /**
     * Restituisce il pulsante "Studenti".
     *
     * @return Pulsante "Studenti".
     */
    public Button getStudenti() {
        return studenti;
    }

    /**
     * Restituisce il pulsante "Atleti".
     *
     * @return Pulsante "Atleti".
     */
    public Button getAtleti() {
        return atleti;
    }

    /**
     * Restituisce il pulsante "per nome".
     *
     * @return Pulsante "per nome".
     */
    public Button getPerNome() {
        return perNome;
    }

    /**
     * Restituisce il pulsante "per eta".
     *
     * @return Pulsante "per eta".
     */
    public Button getPerEta() {
        return perEta;
    }

    /**
     * Imposta l'azione del pulsante "Tutti" per mostrare tutte le persone.
     *
     * @param cp Oggetto CentralPane per l'aggiornamento dell'interfaccia grafica.
     * @param p  Oggetto Palestra per l'accesso ai dati delle persone.
     */
    private void setTuttiAction(CentralPane cp, Palestra p) {
        tutti.setOnAction(event -> {
            cp.aggiornaTesto(p.stampa(p.getPersone()));
            MainGUI.setCurrentView(p.getPersone());
            tutti.setDisable(true);
            studenti.setDisable(false);
            atleti.setDisable(false);
        });
    }

    /**
     * Imposta l'azione del pulsante "Studenti" per mostrare solo gli studenti.
     *
     * @param cp Oggetto CentralPane per l'aggiornamento dell'interfaccia grafica.
     * @param p  Oggetto Palestra per l'accesso ai dati delle persone.
     */
    private void setStudentiAction(CentralPane cp, Palestra p) {
        studenti.setOnAction(event -> {
            cp.aggiornaTesto(p.stampa(p.getStudenti()));
            MainGUI.setCurrentView(p.getStudenti());
            tutti.setDisable(false);
            studenti.setDisable(true);
            atleti.setDisable(false);
        });
    }

    /**
     * Imposta l'azione del pulsante "Atleti" per mostrare solo gli atleti.
     *
     * @param cp Oggetto CentralPane per l'aggiornamento dell'interfaccia grafica.
     * @param p  Oggetto Palestra per l'accesso ai dati delle persone.
     */
    private void setAtletiAction(CentralPane cp, Palestra p) {
        atleti.setOnAction(event -> {
            cp.aggiornaTesto(p.stampa(p.getAtleti()));
            MainGUI.setCurrentView(p.getAtleti());
            tutti.setDisable(false);
            studenti.setDisable(false);
            atleti.setDisable(true);
        });
    }

    /**
     * Imposta l'azione del pulsante "per nome" per ordinare le persone per cognome.
     *
     * @param cp Oggetto CentralPane per l'aggiornamento dell'interfaccia grafica.
     * @param p  Oggetto Palestra per l'accesso ai dati delle persone.
     */
    private void setPerNomeAction(CentralPane cp, Palestra p) {
        perNome.setOnAction(event -> {
            p.sortBySurname(MainGUI.getCurrentView());
            p.sortBySurname(p.getPersone());
            p.sortBySurname(p.getAtleti());
            p.sortBySurname(p.getStudenti());
            cp.aggiornaTesto(p.stampa(MainGUI.getCurrentView()));
            perNome.setDisable(true);
            perEta.setDisable(false);
        });
    }

    /**
     * Imposta l'azione del pulsante "per eta" per ordinare le persone per anno di nascita.
     *
     * @param cp Oggetto CentralPane per l'aggiornamento dell'interfaccia grafica.
     * @param p  Oggetto Palestra per l'accesso ai dati delle persone.
     */
    private void setPerEtaAction(CentralPane cp, Palestra p) {
        perEta.setOnAction(event -> {
            p.sortByEta(MainGUI.getCurrentView());
            p.sortByEta(p.getPersone());
            p.sortByEta(p.getAtleti());
            p.sortByEta(p.getStudenti());
            cp.aggiornaTesto(p.stampa(MainGUI.getCurrentView()));
            perNome.setDisable(false);
            perEta.setDisable(true);
        });
    }
}
