package Prova;

public class FrazioneEgizia {
    protected int nr;
    protected int dr;

    public void StampaFrazioneEgizia(final int n, final int d) {
        if (n == 0 || d == 0) return;
        if (n%d == 0) {
            System.out.print("1/");
            System.out.print(n/d);
            return;
        }
        if (d%n == 0) {
            System.out.print("1/");
            System.out.print(d/n);
            return;
        }
        if (n > d) {
            System.out.print(n/d);
            System.out.print("+");
            StampaFrazioneEgizia(n%d, d);
        }
        else {
            int x = (d/n) + 1;
            System.out.println("1/");
            System.out.println(x);
            System.out.println(" ");
            StampaFrazioneEgizia((n*x) - d, d*x);
        }
    }
}
