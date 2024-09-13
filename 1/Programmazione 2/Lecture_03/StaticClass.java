package Lecture_03;

public class StaticClass {
    // campo int static
    // non dobbiamo per forza inizializzare questi valori
    public static int a_static_int_field;
    // campo int non static
    public int val;
    // campo static di tipo Persona, e` un Oggetto
    // se non inizializziamo, che valore avra`? come 'arrp' di qualche minuto fa ...
    // questo invece viene inizializzato ad un valore preciso
    public static Persona a_static_Obj_field = new Persona("Statico");

    // metodo static
    public static int a_static_method(Persona p){
        return p.eta;
    }
    // metodo non static
    public int get_sum(){
        return this.val + StaticClass.a_static_int_field;
    }
}
