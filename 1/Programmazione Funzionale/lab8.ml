fun simpleMap(F, nil) = []
| simpleMap(F, x::xs) = F(x)::simpleMap(F, xs);

simpleMap( fn x => x*x, [1.0,2.0,3.0]);

exception EmptyList;

fun reduce (F,nil) = raise EmptyList
| reduce (F,[a]) = a
| reduce (F,x::xs) = F(x, reduce(F,xs));

fun square (x:real) = x*x;
fun plus (x:real,y) = x+y;

fun variance (L) =
let
val n = real(length(L))
in
reduce (plus,simpleMap(square,L))/n - square
(reduce(plus,L)/n)
end;

fun filter (P,nil) = nil
| filter (P,x::xs) =
if P(x) then x::filter(P,xs)
else filter (P,xs);

fun replace1(n) = if n>0.0 then n else 0.0;
fun replace(F, nil) = nil
| replace(F, x::xs) = F(x)::replace(F, xs);

replace(replace1, [1.1, ~2.5, 4.2, 0.0, ~3.0]);

reduce(fn(a, b) => if a>b then a else b, [3, 6, 1, 9, 3, 2]);

filter(fn(x) => x>=0.0, [2.2, 3.8, ~1.0, ~4.2, 9.2]);

fun applyList nil _ = nil
| applyList (F::Fs) x = F(x)::(applyList Fs x);

fun curry F x1 x2 x3 = F(x1, x2, x3);

fun toReal (L) = map real L;
toReal([1, 2, 3]);

val andB = foldr (fn(x, y) => x andalso y) true;
andB [true, true, true];