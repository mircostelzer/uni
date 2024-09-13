(print(Real.toString(1.0E50));
print(Int.toString(123)) );

fun printlist(nil) = ()
| printlist(x::xs) = (print(Int.toString(x)); print("\n"); printlist(xs));

printlist([1, 2, 3, 5]);

fun fact(0) = 1
| fact(n) = n*fact(n-1);

fun binom(n, m) = 
let
val res = fact(n)div(fact(m)*fact(n-m))
in
(print(Int.toString(n));
print("\n");
print(Int.toString(m));
print("\n");
print(Int.toString(res))
)
end;

binom(4, 2);

fun pow (_, 0) = 1
| pow (x, i) = x*pow(x, i-1);

fun printPow(0) = ()
| printPow(n) =  
(print(str(#"X"));
print("\n");
printPow(n-1)
);

fun printPow1(n) = 
let
val res = pow(2, n)
in
printPow(res)
end;

printPow1(3);

fun print2N(0) = print("X")
| print2N(n) = 
(print2N(n-1);
print2N(n-1)
);

print2N(4);

fun getWord(fin, NONE) = nil
| getWord(fin, SOME c) = if c = #" " then nil else c::getWord(fin, TextIO.input1(fin)); 

fun getList(fin, NONE) = nil
| getList(fin, SOME c) =
let
    val word = implode(getWord(fin, TextIO.input1(fin)))
in
    word::getList(fin, TextIO.lookahead(fin))
end;

val fin = TextIO.openIn("IO.txt");

getList(fin, TextIO.lookahead(fin));