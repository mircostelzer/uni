package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Questa classe rappresenta una lista di record.
 * Estende ArrayList e fornisce metodi aggiuntivi per manipolare e gestire la lista.
 */
public class ListaRecord extends ArrayList<Record> {

    /**
     * Costruttore per creare una nuova lista di record.
     */
    public ListaRecord() {
        super();
    }

    /**
     * Mescola casualmente gli elementi nella lista.
     */
    public void mescolaLista(){
        Collections.shuffle(this);
    }

    /**
     * Ordina la lista in base al secondo campo di ciascun record.
     */
    public void ordinaLista(){
        super.sort(Comparator.comparing(Record :: getField2));
    }

    /**
     * Ordina la lista in base al terzo campo di ciascun record.
     */
    public void ordinaListaPerTerzoField(){
        super.sort(Comparator.comparingInt(Record :: getField3));
    }

    /**
     * Verifica se un record è presente nella lista.
     *
     * @param r Il record da cercare.
     * @return True se il record è presente nella lista, altrimenti False.
     */
    public boolean isPresente(Record r){
        for (Record record : this){
            if(record.equals(r))
                return true;
        }
        return false;
    }

    /**
     * Restituisce una rappresentazione testuale della lista di record.
     *
     * @return Una stringa che rappresenta la lista di record.
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Record r : this){
            str.append(r.toString()).append("\n");
        }
        return str.toString();
    }
}
