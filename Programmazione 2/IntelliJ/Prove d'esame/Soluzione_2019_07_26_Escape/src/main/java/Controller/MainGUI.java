package Controller;

import Model.Coordinate;
import Model.Pallina;
import Model.Palline.Enemy;
import Model.Palline.Nemici.Bubbler;
import Model.Palline.Nemici.Striker;
import Model.Palline.Nemici.Wanderer;
import Model.Palline.User;
import View.StatsStage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe che gestisce l'interfaccia principale del gioco.
 * Si occupa di creare e gestire le entità di gioco, come il giocatore e i nemici.
 */
public class MainGUI extends Pane {
    private StatsStage statsStage;
    private User user;
    private ArrayList<Bubbler> bubblers;
    private ArrayList<Wanderer> wanderers;
    private ArrayList<Striker> strikers;

    private static boolean loose;
    private static int GENERAL_INDEX;

    /**
     * Costruttore della classe MainGUI.
     * Inizializza il gioco creando il giocatore e alcuni nemici.
     */
    public MainGUI() {
        super();
        loose = false;
        GENERAL_INDEX = 0;
        statsStage = new StatsStage();

        Random r = new Random();
        user = new User();
        user.setCenterX(r.nextInt(481));
        user.setCenterY(r.nextInt(481));

        bubblers = new ArrayList<>();
        wanderers = new ArrayList<>();
        strikers = new ArrayList<>();

        super.getChildren().add(user);
        aggiungiNemico(new Bubbler());
        aggiungiNemico(new Wanderer());
        aggiungiNemico(new Striker());
    }

    /**
     * Restituisce la finestra delle statistiche.
     *
     * @return la finestra delle statistiche.
     */
    public StatsStage getStatsStage() {
        return statsStage;
    }

    /**
     * Restituisce l'indice generale.
     *
     * @return l'indice generale.
     */
    public static int getGeneralIndex() {
        return GENERAL_INDEX;
    }

    /**
     * Restituisce una lista con tutti i nemici.
     *
     * @return una lista con tutti i nemici.
     */
    public ArrayList<Enemy> getAllEnemies(){
        ArrayList<Enemy> nemici = new ArrayList<>();
        nemici.addAll(bubblers);
        nemici.addAll(wanderers);
        nemici.addAll(strikers);
        return nemici;
    }

    /**
     * Restituisce il giocatore.
     *
     * @return il giocatore.
     */
    public User getUser() {
        return user;
    }

    /**
     * Restituisce lo stato di perdita del giocatore.
     *
     * @return true se il giocatore ha perso, false altrimenti.
     */
    public static boolean isLoose() {
        return loose;
    }

    /**
     * Incrementa l'indice generale di uno.
     */
    public static void incrementGeneralIndex() {
        GENERAL_INDEX++;
    }

    /**
     * Crea un nemico casuale tra Striker, Wanderer e Bubbler.
     *
     * @return un nemico casuale.
     */
    public Enemy creaNemicoCasuale(){
        Random r = new Random();
        return switch (r.nextInt(3)) {
            case 0 -> new Striker();
            case 1 -> new Wanderer();
            case 2 -> new Bubbler();
            default -> null;
        };
    }

    /**
     * Aggiunge un nemico alla lista e lo posiziona in una posizione casuale sulla mappa.
     *
     * @param nemico il nemico da aggiungere.
     */
    public void aggiungiNemico(Enemy nemico){
        if(nemico instanceof Striker s)
            strikers.add(s);
        if(nemico instanceof Bubbler b)
            bubblers.add(b);
        if(nemico instanceof Wanderer w)
            wanderers.add(w);

        Coordinate c = creaCoordinateSpawn();

        nemico.setCenterX(c.getX());
        nemico.setCenterY(c.getY());

        super.getChildren().add(nemico);
    }

    /**
     * Cambia la direzione dei nemici di tipo Wanderer e Bubbler.
     */
    public void cambiaDirezione(){
        for(Wanderer wanderer : wanderers){
            wanderer.cambiaDirezione();
        }

        for(Bubbler bubbler : bubblers){
            bubbler.cambiaDirezione();
        }
    }

    /**
     * Muove tutti i nemici nella loro direzione attuale.
     */
    public void muoviNemici(){
        for(Enemy enemy : getAllEnemies()){
            enemy.muovi();
        }
    }

    /**
     * Crea delle coordinate casuali per il spawn dei nemici,
     * assicurandosi che non siano troppo vicini al giocatore.
     *
     * @return delle coordinate casuali per il spawn.
     */
    private Coordinate creaCoordinateSpawn(){
        Random r = new Random();
        double spawnX, spawnY;

        do{
            spawnX = r.nextDouble(481); //481 cosi spawnano all'interno della mappa e non metà fuori
            spawnY = r.nextDouble(481);
        } while(spawnX < user.getCenterX() + 45 && spawnY < user.getCenterY() + 45); //45 considerando raggioUser+raggioEnemy+5 di distacco iniziale

        return new Coordinate(spawnX, spawnY);
    }

    /**
     * Verifica se il giocatore ha perso.
     * Se il giocatore collide con un nemico, imposta lo stato di perdita e cambia il colore del nemico e del giocatore a rosso.
     */
    public void checkLoose(){
        Enemy nemicoCollisione = null;
        for(Enemy nemico : getAllEnemies()){
            double distance = Math.sqrt(Math.pow(user.getCenterX() - nemico.getCenterX(), 2) + Math.pow(user.getCenterY() - nemico.getCenterY(), 2));
            if(distance < user.getRadius() + nemico.getRadius()){
                loose = true;
                nemicoCollisione = nemico;
            }
        }
        if(loose){
            nemicoCollisione.setFill(Color.RED);
            user.setFill(Color.RED);
        }
    }

    /**
     * Riposiziona le palline che escono dai bordi della mappa, riportandole dal lato opposto.
     */
    public void riposizionaPalline(){
        ArrayList<Pallina> entita = new ArrayList<>();
        entita.addAll(getAllEnemies());
        entita.add(user);

        for(Pallina pallina : entita){
            if(pallina.getCenterX() < 0)
                pallina.setCenterX(500);
            else if(pallina.getCenterX() > 500)
                pallina.setCenterX(0);
            if(pallina.getCenterY() < 0)
                pallina.setCenterY(500);
            else if(pallina.getCenterY() > 500)
                pallina.setCenterY(0);
        }
    }
}