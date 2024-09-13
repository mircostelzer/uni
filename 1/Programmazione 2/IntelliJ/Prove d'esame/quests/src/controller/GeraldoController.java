package controller;

import model.Geraldo;
import view.GeraldoPane;

public class GeraldoController {

    private Geraldo g;
    private GeraldoPane gp;

    public GeraldoController(Geraldo g){
        this.g = g;
        this.gp = new GeraldoPane(g);
    }

    public Geraldo getG() { return g; }
    public GeraldoPane getGp() { return gp; }
}
