datatype FOR = For of int * (int -> int);

fun eval(For(1, f)) = f
| eval(For(n, f)) = f o (eval(For(n-1, f)));

val f = fn x => x * 2;

eval(For(3, f));

val g = eval (For(3, f));

g 5;