(1.5, ("3", [4,5]));
[[1,2], nil, [3]];
[(2, 3.5), (4, 5.5), (6, 7.5)];
([#"a", #"b"], [nil, [1, 2, 3]]);
fun cube a:real = a*a*a;
fun min (a, b, c) = 
if a<b 
    then if a<c
            then a
        else c
else if b<c
        then b
    else c;

fun third a = hd(tl(tl a));
fun fact n = 
if (n = 0 orelse n = 1)
    then 1
else n * fact (n - 1);

fun third_rec (a:int list, c) = 
if (c - 1 = 0)
    then hd a
else third_rec (tl a, c - 1);

fun reverse (a, b, c) = (c, b, a);

fun third_char str = third (explode str);

fun circle a: 'a list = (tl a) @ [hd a];

fun max (a, b, c) = 
if a>b 
    then if a>c
            then a
        else c
else if b>c
        then b
    else c;

fun pair (a, b, c) = (min (a, b, c), max (a, b, c));

fun sort (a, b, c) = 
[  min(a, b, c),
    if (a = min(a, b, c))
        then if (b = max(a, b, c))
                then c
            else b
    else if (a = max(a, b, c))
            then if (b = min(a, b, c))
                    then c
                else b
        else a,
    max(a, b, c) ];

fun dec a:real = (real(round (a*10.0)))/10.0;

fun remove a: 'a list = (hd a) :: tl(tl a); 

val infile = TextIO.openIn("IO.txt");

val s = valOf(TextIO.inputLine(infile));