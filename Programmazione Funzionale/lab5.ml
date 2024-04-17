fun insertAll(_, nil) = nil
| insertAll(a, x::xs) = (a::x)::insertAll(a, xs);

fun powerSet(nil) = [nil]
| powerSet(s::S) = powerSet(S)@insertAll(s, powerSet(S));

powerSet([1, 2, 3]);

val thousandth = fn x:real =>
let 
val x = x*x*x*x*x
val x = x*x*x*x
val x = x*x*x*x;
in 
x*x
end;

thousandth(2.0);

fun powerSet(nil) = [nil]
| powerSet(s::S) = 
let 
val P = powerSet(S)
in
P@insertAll(s, P)
end;

powerSet([1, 2, 3]);

fun maxList(nil) = 0.0
| maxList([x:real]) = x
| maxList(x::y::zs) =
let
val m = maxList(zs)
in
if x>m then x else if y>m then y else m
end;

maxList([3.0, 8.2, 2.1, 1.0, 4.3, 5.0]);

fun doubleExp(x:real, 0) = x
| doubleExp(x, i) = 
let 
    val y = doubleExp(x, i-1)
in 
    y*y
end;

fun sumPairs(nil) = (0,0)
| sumPairs((x, y)::L) = 
let
    val(z1, z2) = sumPairs(L)
in
    (x+z1, y+z2)
end;

sumPairs([(1, 3), (2, 5)]);

fun sumList(nil) = (0, 0)
| sumList(x::nil) = (x, 0)
| sumList(x::y::L) =
let
    val(z1, z2) = sumList(L)
in 
    (x+z1, y+z2)
end;

sumList([1,2,3,4]);

