fun fact(n) = 
if n = 0 orelse n = 1
    then 1
else n * fact(n-1);

fun cycle(i, L) = 
if i = 0 then L
else cycle(i-1, tl L @ [hd L]);

fun duplicate(L) = 
if L = nil then nil
else [hd(L), hd(L)] @ duplicate(tl L);

fun lenght(L) = 
if L = nil then 0
else 1 + lenght(tl L);

fun pow (x:real, i) =
if i = 0 then 1.0
else x * pow(x, i-1);

fun largest(L, m:string) =
if (L = nil) 
    then m
else if (hd(L)>m) 
        then largest(tl(L), hd(L))
    else largest(tl(L), m);