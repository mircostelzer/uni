package Lecture_03;


public class Lecture_03 {
    // compariamo la definizione di classe Pila in java
    // con quella in C++, cosa c'e` in comune e cosa cambia
    // cosa cambia sintatticamente ma mantiene la stessa semantica

    // valutiamo alcune delle differenze sintattiche per poi
    // parlare delle differenze sostanziali dovute al paradigma OO
    public static void main(String[] args){
        // replichiamo il main del C++ in Java
        pila();
        // intermezzo: allocazione degli array
        allocazione_Array();

        explain_statics();
    }
    private static void pila(){
        Pila s = new Pila(5);
        // questo codice e` come quello in C++, modulo sintassi di Java
        System.out.print("s");
        // differenza tra sintassi dei linguaggi, e la loro semantica
        // cosa scriviamo VS come si comporta il linguaggio?
        // lo vedete anche in FP: il comportamento e` diverso da C/Java
        s.stampastato();
        for(int k=1; k<10; k++){
            s.inserisci(k);
        }
        System.out.print("s");
        s.stampastato();
        Pila w = s.copia();
        System.out.print("w");
        w.stampastato();
        for (int k=0; k<8 ; k++) {
            System.out.println(s.estrai());
        }
        System.out.print("s");
        s.stampastato();

        for(int k=0; k<15; k++){
            System.out.println(w.estrai());
        }
        System.out.print("w");
        w.stampastato();
    }

    private static void allocazione_Array(){
        // creiamo un array di persone (nelle slides, arrp si chiama person)
        Persona[] arrp;
        // MENTIMETER: Dato che Persona[] e` un tipo puntatore, che valore ha arrp ora?
        arrp = new Persona[20];
        // SLIDE+DRAW memory layout
        arrp[0] = new Persona("Marco");
        // SLIDE+DRAW memory layout
        arrp[0] = new Persona("Lorenzo");
        // SLIDE+DRAW memory layout
    }
    // back to Pila -> cresci

    private static void explain_statics(){
        // guardiamo alla StaticClass
        StaticClass a = new StaticClass();
        StaticClass b = new StaticClass();
        // il codice nella slide e` incorretto, non puo` fare a.x, deve fare C.x
        StaticClass.a_static_int_field =5;
        a.val = 1;
        b.val = StaticClass.a_static_int_field + 2;
        // MENTIMETER quanto vale b.val ?

        // SLIDE + DRAW: memory layout of a, b and their classes
        // SLIDE: restrizioni di accesso
        // torniamo alla Pila
    }
}
