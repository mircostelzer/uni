package Model;

import Model.Quests.*;

import java.util.ArrayList;
import java.util.Comparator;

public class QuestDB {
    private ArrayList<Quest> mainQuests;
    private ArrayList<Quest> dlcQuests;
    private ArrayList<Quest> contractQuests;
    private ArrayList<Quest> secondaryQuests;

    /**
     * crea 4 liste che contengono le quest del testo
     */
    public QuestDB() {
        mainQuests = new ArrayList<>();
        dlcQuests = new ArrayList<>();
        contractQuests = new ArrayList<>();
        secondaryQuests = new ArrayList<>();

        MainQuest lilacAndGooseberries = new MainQuest("Lilac and Gooseberries", 2, "White Orchard", null);
        MainQuest theNilfGaardianConnection = new MainQuest("The Nilfgaardian Connection", 3, "Velen", lilacAndGooseberries);
        MainQuest pyresOfNovigrad = new MainQuest("Pyres of Novigrad", 5, "Novigrad", theNilfGaardianConnection);

        mainQuests.add(lilacAndGooseberries);
        mainQuests.add(theNilfGaardianConnection);
        mainQuests.add(pyresOfNovigrad);

        secondaryQuests.add(new SecondaryQuest("A Favor for a Friend", 2, 10, new NPC("Keira Metz")));
        secondaryQuests.add(new SecondaryQuest("The Last Wish", 6, 30, new NPC("Bloody Baron")));

        ArrayList<Mostro> a1 = new ArrayList<>();
        a1.add(Mostro.Drowners);
        a1.add(Mostro.Foglet);

        ArrayList<Mostro> a2 = new ArrayList<>();
        a2.add(Mostro.Drowners);

        ArrayList<Mostro> a3 = new ArrayList<>();
        a3.add(Mostro.Wolves);
        a3.add(Mostro.Drowners);

        contractQuests.add(new ContractQuest        ("Swamp Thing",     12, 40, a1));
        contractQuests.add(new ContractTreasureQuest("Cast of Wrecks",  4,  50, a2, "Novigrad"));
        contractQuests.add(new ContractTreasureQuest("Dirty Funds",     1,  20, a3, "Velen"));

        DLCQuest captureTheCastle = new DLCQuest(   "Capture the Castle",   9, "Toussiant", null,   theNilfGaardianConnection);
        DLCQuest envoysWineboys = new DLCQuest(     "Envoys, Wineboys",     8, "Velen",     captureTheCastle, theNilfGaardianConnection);

        dlcQuests.add(envoysWineboys);
        dlcQuests.add(captureTheCastle);
    }

    /**
     * ordina la lista passata da parametro per nome
     * @param q
     */
    public void sortByNome(ArrayList<Quest> q){
        Quest a = q.get(0);
        if(a == null){
            AlertDisplayer.displayErrorAlert("Non c'è niente da ordinare");
        } else if(a instanceof DLCQuest){
            dlcQuests.sort(Comparator.comparing(Quest :: getNome));
        } else if(a instanceof MainQuest){
            mainQuests.sort(Comparator.comparing(Quest :: getNome));
        } else if(a instanceof ContractQuest){
            contractQuests.sort(Comparator.comparing(Quest :: getNome));
        } else if(a instanceof SecondaryQuest)
            secondaryQuests.sort(Comparator.comparing(Quest :: getNome));
    }

    /**
     * ordina la lista passata da parametro per ricompensa in ordine decrescente
     * in caso di ricompensa uguale ordina per nome
     * @param q
     */
    public void sortByRicompensa(ArrayList<Quest> q){
        Quest a = q.get(0);
        if(a == null){
            AlertDisplayer.displayErrorAlert("Non c'è niente da ordinare");
        } else if(a instanceof DLCQuest){
            dlcQuests.sort(Comparator.comparing(Quest :: getRicompensa).reversed().thenComparing(Quest :: getNome));
        } else if(a instanceof MainQuest){
            mainQuests.sort(Comparator.comparing(Quest :: getRicompensa).reversed().thenComparing(Quest :: getNome));
        } else if(a instanceof ContractQuest){
            contractQuests.sort(Comparator.comparing(Quest :: getRicompensa).reversed().thenComparing(Quest :: getNome));
        } else if(a instanceof SecondaryQuest)
            secondaryQuests.sort(Comparator.comparing(Quest :: getRicompensa).reversed().thenComparing(Quest :: getNome));
    }

    public ArrayList<Quest> getMainQuests() {
        return mainQuests;
    }

    public ArrayList<Quest> getDlcQuests() {
        return dlcQuests;
    }

    public ArrayList<Quest> getContractQuests() {
        return contractQuests;
    }

    public ArrayList<Quest> getSecondaryQuests() {
        return secondaryQuests;
    }
}
