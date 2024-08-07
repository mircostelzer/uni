package Model;

public abstract class Quest {
    private String nome; //nome della quest
    private int livelloMinimo; //livello minimo per completare una quest
    private double ricompensa; //ricompensa soldi, double perché dividerò per 2
    private int aumentoLivello; //numero di livelli da aumentare al completamento della quest
    private boolean completa; //per capire se una quest è stata completata

    public Quest(String nome, int livelloMinimo, double ricompensa) {
        this.nome = nome;
        this.livelloMinimo = livelloMinimo;
        this.ricompensa = ricompensa;
        aumentoLivello = 1;
        completa = false;
    }

    public String getNome() {
        return nome;
    }

    public int getLivelloMinimo() {
        return livelloMinimo;
    }

    public double getRicompensa() {
        return ricompensa;
    }

    public int getAumentoLivello() {
        return aumentoLivello;
    }

    public void setAumentoLivello(int aumentoLivello) {
        this.aumentoLivello = aumentoLivello;
    }

    public boolean isCompleta() {
        return completa;
    }

    public void setCompleta() {
        completa = true;
    }

    @Override
    public String toString() {
        return  nome + "(" + ricompensa +")";
    }
}
