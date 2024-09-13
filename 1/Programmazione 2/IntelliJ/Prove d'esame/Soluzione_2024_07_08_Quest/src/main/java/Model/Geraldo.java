package Model;

public class Geraldo {
    private int livello;
    private double soldi;

    /**
     * istanzia livello a 2 e soldi a 0
     */
    public Geraldo() {
        livello = 2;
        soldi = 0;
    }

    public int getLivello() {
        return livello;
    }

    public double getSoldi() {
        return soldi;
    }

    public void setLivello(int livello) {
        this.livello = livello;
    }

    public void setSoldi(double soldi) {
        this.soldi = soldi;
    }

    @Override
    public String toString() {
        return "Geraldo.LV:" + livello + " GP:" + soldi;
    }
}
