package Model;

import java.util.Objects;

/**
 * Questa classe rappresenta un record astratto con tre campi.
 */
public abstract class Record {
    private String field1;
    private String field2;
    private Integer field3;

    /**
     * Costruttore per creare un nuovo record con tre campi.
     *
     * @param field1 Il valore del primo campo.
     * @param field2 Il valore del secondo campo.
     * @param field3 Il valore del terzo campo.
     */
    public Record(String field1, String field2, Integer field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    /**
     * Restituisce il valore del primo campo.
     *
     * @return Il valore del primo campo.
     */
    public String getField1() {
        return field1;
    }

    /**
     * Restituisce il valore del secondo campo.
     *
     * @return Il valore del secondo campo.
     */
    public String getField2() {
        return field2;
    }

    /**
     * Restituisce il valore del terzo campo.
     *
     * @return Il valore del terzo campo.
     */
    public Integer getField3() {
        return field3;
    }

    /**
     * Confronta questo record con un altro record per verificarne l'uguaglianza.
     *
     * @param r Il record con cui confrontare questo record.
     * @return True se i record sono uguali, altrimenti False.
     */
    public boolean equals(Record r){
        return this.field1.equals(r.getField1()) && this.field2.equals(r.getField2()) && Objects.equals(this.field3, r.getField3());
    }

    /**
     * Restituisce una rappresentazione testuale di questo record.
     *
     * @return Una stringa che rappresenta questo record.
     */
    @Override
    public String toString() {
        return field1 + " " + field2 + " " + field3;
    }
}
