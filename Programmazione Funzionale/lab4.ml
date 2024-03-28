fun merge (nil,M) = M
| merge (L,nil) = L
| merge (L as x::xs, M as y::ys) =
if x<y then x::merge(xs,M)
else y::merge (L,ys);

fun merge (nil,M) = M
| merge (L,nil) = L
| merge (x::xs, y::ys) =
if x<y then x::merge(xs, y::ys)
else y::merge (x::xs, y::ys);

fun fact (0) = 1
| fact (n) = n * fact(n-1);

fun cycle1 (nil) = nil
| cycle1 (x::xs) = xs @ [x]; 

fun cycle_i (L, 0) = L
| cycle_i (L, i) = cycle_i(cycle1(L), i-1);

fun dup (nil) = nil
| dup (x::xs) = x::x::dup(xs);

fun pow (_, 0) = 1.0
| pow (x, i) = x*pow(x, i-1);

fun max([x:real]) = x
| max (x::xs) = if x>max(xs) then x else max(xs);  

fun flip (nil) = nil
| flip ([x]) = [x]
| flip (x::y::zs) = y::x::flip(zs);

fun del (nil, _) = nil
| del (L, 0) = L
| del (x::xs, 1) = xs
| del (x::xs, i) = x::del(xs, i-1); 

fun square (0) = 0
| square (n)