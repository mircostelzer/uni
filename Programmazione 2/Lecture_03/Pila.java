// cos'e` questo 'package'? lo vediamo dopo
package Lecture_03;

// definiamo una classe con un modificatore di visibilta`: public
// si deve chiamare come il file
// vedremo che ci sono anche classi private
@SuppressWarnings("ALL")
public class Pila {
    // una classe contiene campi (variabili di istanza o attributi), e metodi
    // OGNI campo e metodo ha un modificatore di visibilta`: public / private / package / protected
    //  package e protected -> li vediamo tra un po'
    // i campi definiscono i loro tipi
    //  ogni tipo ha un valore base di inizializzazione!
    // i metodi hanno una firma, come le funzioni

    private int size;
    protected int marker;
    protected int[] contenuto;

    public boolean piena() {
        // usiamo "." e non "->" per accedere alle variabili di istanza
        return this.size == this.marker;
        // this == riferimento all'oggetto attuale
        // ma cos'e` un oggetto?
        // SLIDE: classi (attributi / metodi) e oggetti
        // e` un paradigma nuovo, una idea che non avete ancora visto
        // SLIDE: null, puntatori
        // SLIDE: che tipi ha Java
        // implementiamo la pila: costruttori
    }

    // anche i metodi e i costruttori hanno modificatori
    // il costruttore si chiama come la classe
    public Pila(int initialSize) {
        // andiamo a vedere nel main come viene usato
        size = initialSize;
        marker = 0;
        contenuto = new int[initialSize];
    }
    // possiamo avere costruttori con firma diversa
    public Pila(){
        // final si usa per le costanti, tutte maiuscole, e per altro che vedremo
        final int DEFAULT_SIZE = 10;
        size = DEFAULT_SIZE;
        marker = 0;
        contenuto = new int[DEFAULT_SIZE];
    }

    //possiamo avere metodi privati
    private void cresci(int delta){
        System.out.println("entro in cresci");
        size+=delta;
        // Array: questo e` un array di tipi base
        // SLIDE + DRAW: array di oggetti, come vengono allocati in memoria?
        int[] temp = new int[size];
        // MENTIMETER: posso dichiarare un array di tipo int*?
        // int* temp2 = new int[size];

        for (int k=0; k<marker ; k++){
            temp[k] = contenuto[k];
        }
        // parliamo dell'allocazione degli array di oggetti -> lecture03 allocazione_Array

        // Una differenza colossale col C/C++, non dobbiamo fare memory management
        //  non dobbiamo fare delete contenuto
        // SLIDE: creazione, distruzione, GC
        contenuto = temp;
    }

    // copia: recap di notazione:
    //      parsing della firma: tipo di ritorno, tipo degli argomenti
    //  public, this, dot-notation
    public Pila copia(){
        Pila to = new Pila(this.size);
        for (int k=0; k<marker; k++){
            to.contenuto[k] = contenuto[k];
        }
        to.marker = marker;
        return to;
    }

    public int estrai(){
        // anche Java ha le asserzioni
        // SLIDE: equivalente a
        assert(marker>0);

        // Ok, cos'e` questo System? -- ensure break --
        // SLIDE: system una libreria globale
        // Come posso avere classi e oggetti globali?
        // -> Lecture 03, explain_statics

        // Convenzioni di nomi:
        //  Maiuscola -> classe
        //  minuscola -> oggetto
        //  parentesi alla fine (), + argomenti -> metodo
        // MENTIMETER: cosa stiamo facendo qui?
        System.gc();
        // MENTIMETER: cosa stiamo facendo qui?
        System.out.println("estraggo");

        int indx = marker;
        marker --;
        return contenuto[indx];
    }

    // finiamo di analizzare la Pila in Java
    public void stampastato(){
        System.out.println("==================");
        System.out.println("size ="+size);
        System.out.println("marker ="+marker);
        for (int k=0; k<marker; k++){
            System.out.println("[" + contenuto[k] + "]");
        }
        System.out.println("==================");
    }

    // SLIDE: costanti
    public void inserisci(int k){
        final int GROWTH_SIZE = 5;
        if (this.piena()){
            this.cresci(GROWTH_SIZE);
        }
        contenuto[marker] = k;
        marker++;
    }
    // SLIDE: paragone: i globali in Java VS i globali in C

    // torniamo in cima, e parliamo dell'ultima cosa: package
    // cos'e` un package
    // cosa e` la visibilita` package
    // SLIDE: package
    // SLIDE java.lang
}