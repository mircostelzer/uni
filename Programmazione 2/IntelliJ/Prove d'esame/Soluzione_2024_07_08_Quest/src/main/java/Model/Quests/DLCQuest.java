package Model.Quests;

public class DLCQuest extends MainQuest{
    private MainQuest collegata;

    public DLCQuest(String nome, int livelloMinimo, String luogo, MainQuest precedente, MainQuest collegata) {
        super(nome, livelloMinimo, luogo, precedente);
        this.collegata = collegata;
    }

    public MainQuest getCollegata() {
        return collegata;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nDLC Req." + collegata.getNome();
    }
}
