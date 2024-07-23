val infile = TextIO.openIn "test.txt";
fun getWord1 (infile,NONE) = nil
| getWord1 (infile, SOME c) = 
if (c = #" " orelse c = #"\n") then nil else 
c::getWord1(infile,TextIO.input1 infile);

fun getWord (infile) = getWord1(infile,TextIO.input1 (infile));

fun getList1 (infile, NONE) = nil
| getList1 (infile, SOME c) = 
[implode(getWord (infile))] @ getList1 (infile, TextIO.lookahead infile);

fun getList (infile) = getList1(infile, TextIO.lookahead infile);

val stringList = getList(infile);

TextIO.closeIn infile;


(* --------------------------------------- *)


fun sizeList(nil) = 0
| sizeList(x::xs) = 1 + sizeList(xs);

fun sublist_left(nil, _) = nil
| sublist_left(L, 0) = nil
| sublist_left(x::xs, k) = x::sublist_left(xs, k-1);

fun sublist_right(nil, _) = nil
| sublist_right(L, 0) = L
| sublist_right(x::xs, k) = sublist_right(xs, k-1);

fun reverseList(nil) = nil
|   reverseList(x::xs) = reverseList(xs)@[x]; 

fun charToInt(a) = ord(a)-ord(#"0");

fun getSingleNum(nil) = 0
| getSingleNum(x::xs) = 
if(charToInt(x) >= 0 andalso charToInt(x) <= 9) then charToInt(x) 
else getSingleNum(xs);


fun getNumList(nil) = nil
| getNumList(x::xs) =
let
    val first = getSingleNum(explode(x))
    val second = getSingleNum(reverseList(explode(x)))
in 
    first*10 + second :: getNumList(xs)

end;

val numList = getNumList(stringList);

reverseList(numList);


(* --------------------------- *)

fun maxInd1(nil, _, _, ind, _) = ind
| maxInd1(x::xs, i, k, ind, maxx) = 
if (i<=k) then
if(x>maxx) then maxInd1(xs, i+1, k, i, x)
else maxInd1(xs, i+1, k, ind, maxx)
else ind;

fun maxInd(L, k) = maxInd1(L, 0, k, 0, 0);

fun flip(nil, _) = nil
| flip(L, k) = (reverseList(sublist_left(L, k)))@sublist_right(L, k);

fun pancake_sort1(nil, _) = nil
| pancake_sort1(L, n) = 
if (n<=1) then L
else
let
    val max_i = maxInd(L, n-1)
in
    pancake_sort1(flip(flip(L, max_i), n-1), n-1)
end;

(* let 
    val max_ind = maxInd(L, n-1)
    val next_n = n-1
in
if (max_ind<>next_n) then 
    if (max_ind<>0) then pancake_sort1(flip(L, max_ind), next_n)
    else pancake_sort1(flip(L, next_n), next_n)
else pancake_sort1(L, next_n)
end; *)

fun pancake_sort(L) = pancake_sort1(L, sizeList(L));

pancake_sort(numList);