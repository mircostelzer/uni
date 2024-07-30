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
    type 'a set = 'a list;
    val emptySet = nil;
    fun member _ nil = false
    | member x (y::ys) = (x=y) orelse (member x ys);
    fun insert x L = if (member x L) then L else x::L;
    fun remove _ nil = nil
    | remove x (y::ys) = if x=y
        then ys else y::(remove x ys);

end:> SET;

val s = Set.emptySet;
val a = Set.member 2 s;
val b = Set.insert 1 s;
val c = Set.member 1 b;
val d = Set.remove 1 b;
val e = Set.member 1 d;

signature TREE =
sig
    datatype 'a T = Lf | Br of 'a * 'a T * 'a T
    val count: 'a T -> int
    val depth: 'a T -> int
    val mirror: 'a T -> 'a T
end;

structure tree =
struct
    datatype 'a T =
    Lf | Br of 'a * 'a T * 'a T;
    fun count(Lf) = 0
    | count(Br(a,b,c)) = 1 + count(b) + count(c);
    fun depth(Lf) = 0
    | depth(Br(a, b, c)) = if (count(b)>count(c)) then count(b) else count(c);
    fun mirror(Lf) = Lf
    | mirror(Br(a, b, c)) = Br(a, mirror(c), mirror(b));

end :> TREE;
