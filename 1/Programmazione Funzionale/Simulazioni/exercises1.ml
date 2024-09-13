fun sommali n nil = n
| sommali n [x] = n
| sommali n (x::y::ys) = sommali (n+y) (ys);

sommali 2 [1];


fun f nil _ = nil
| f (x::xs) n = if (List.length(explode(x)) <= n) then x::(f xs n) else implode(tl(explode(x)))::(f xs n); 

f ["ciao", "hey", "Hello", "World"] 4;

fun countOccur(x, nil) = 0
| countOccur(x, y::ys) = if (x = y) then 1+countOccur(x, ys) else countOccur(x, ys);

fun contains(x, nil) = false
| contains(x, (a, b)::ys) = if (x = a) then true else contains(x, ys);

fun conta_duplicati1(nil, res) = res
| conta_duplicati1(x::xs, res) = if contains(x, res) then conta_duplicati1(xs, res) else conta_duplicati1(xs, (x, 1+countOccur(x, xs))::res);

fun conta_duplicati(L) = conta_duplicati1(L, nil);

conta_duplicati ["blu", "verde", "giallo", "verde", "rosso"];

fun removeLast(nil) = nil
| removeLast(x::nil) = nil
| removeLast(x::xs) = x::removeLast(xs);

fun suffixes("") = nil
| suffixes(string) = string::suffixes(implode(removeLast(explode(string))));

suffixes "hi world";
