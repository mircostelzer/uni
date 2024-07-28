exception EmptyList;

fun lreduce _ nil = raise EmptyList
| lreduce F (x::xs) = foldr F x xs;

(* alternative *)

fun lreduce(F, nil) = raise EmptyList
| lreduce(F, [x]) = x
| lreduce(F, x::y::zs) = lreduce(F, F(x, y)::zs);

lreduce (fn(x, y) => x+y, [1, 2, 3]);

fun substring1 nil nil = true
| substring1 L1 nil = false
| substring1 nil L2 = false
| substring1 (x::xs) (y::ys) = if x=y then substring1 xs ys else false; 

fun substring S1 S2 =
let
    val L1 = explode(S1)
    val L2 = explode(S2)
in
    substring1 L1 L2
end;

substring "Ciaoc" "Ciao";