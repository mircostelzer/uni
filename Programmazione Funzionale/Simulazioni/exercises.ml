fun createList(n, m) =
if m <= n then nil else
let
    val diff = m-n
    fun listM(a, 0, res) = res
    | listM(a, l, res) =  listM(a-1, l-1, a::res);
in
    n::listM(m-1, diff-1, [m])
end;

createList(4, 4);

val raddoppia = map (fn n => 2*n);

raddoppia [1, 2, 3, 4];

fun ordinata(nil) = true
| ordinata([x]) = true
| ordinata(x::y::ys) = if x<=y then ordinata(y::ys) else false;

ordinata([1, 2, 6, 4, 5]);

fun test(nil, _) = 0
| test(x::xs, F) = if F(x) then 1+test(xs, F) else test(xs, F);

test([2, 4, 1, 5, 7, 12], fn x => x<5);

fun palindrome(nil) = true
| palindrome(L) = 
let
    fun reverse(nil) = nil
    | reverse(x::xs) = reverse(xs)@[x];
in
    L=reverse(L)
end;

palindrome([1, 2, 3, 2, 1]);

(* Si supponga che il tipo di dato datatype evento = entra of string * int | esce of string * int sia utilizzato 
per memorizzare gli ingressi e le uscite di persone da un edificio (la coppia ricevuta come parametri dai due 
costruttori contiene una stringa che indica il nome di una persona ed un intero che indica l'ora di ingresso o uscita). *)

datatype evento = entra of string * int | esce of string * int;

fun split(nil) = (nil,nil)
| split([a]) = ([a],nil)
| split (a::b::cs) =
let
val (M,N) = split (cs)
in
(a::M,b::N)
end;

fun merge (nil,M) = M
| merge (L,nil) = L
| merge (L as entra(name1, time1)::xs, M as entra(name2, time2)::ys) =
if time1<time2 then entra(name1, time1)::merge(xs,M)
else entra(name2, time2)::merge (L,ys)
| merge (L as entra(name1, time1)::xs, M as esce(name2, time2)::ys) =
if time1<time2 then entra(name1, time1)::merge(xs,M)
else esce(name2, time2)::merge (L,ys)
| merge (L as esce(name1, time1)::xs, M as entra(name2, time2)::ys) =
if time1<time2 then esce(name1, time1)::merge(xs,M)
else entra(name2, time2)::merge (L,ys)
| merge (L as esce(name1, time1)::xs, M as esce(name2, time2)::ys) =
if time1<time2 then esce(name1, time1)::merge(xs,M)
else esce(name2, time2)::merge (L,ys)


fun mergeSort (nil) = nil
| mergeSort([a]) = [a]
| mergeSort (L) =
let
val (M,N) = split L;
val M = mergeSort (M);
val N = mergeSort (N)
in
merge (M,N)
end;

val L = [entra("Mirco", 8), entra("Filippo", 7), esce("Mirco", 13), entra("Andrea", 12)];
mergeSort(L);

fun controlla(nil) = true
| controlla([entra(name, time)]) = true
| controlla([esce(name, time)]) = false
| controlla(x::xs) = 
let
