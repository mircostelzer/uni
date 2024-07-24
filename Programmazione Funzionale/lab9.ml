fun implode L = (foldr(op^) "" (map str L));

val implode = (foldr(op^) "") o (map(str));

implode([#"a", #"b", #"c"]);

type parola = string;
val a = "Hello": parola;

type 'a setOfSets = 'a list list;

type ('a, 'b) triple = ('a * 'a * 'b);

signature SET =
sig
    type 'a set
    val emptySet: 'a set
    val member: ''a -> ''a set -> bool
    val insert: ''a -> ''a set -> ''a set
    val remove: ''a -> ''a set -> ''a set
end;

structure Set = 
struct
    type 'a set = 'a list
    val emptySet = nil
end;