fun getWord1 (infile,NONE) = nil
| getWord1 (infile, SOME c) = 
if (c = #" " orelse c = #"\n") then nil else 
c::getWord1(infile,TextIO.input1 infile);

fun getWord (infile) = getWord1(infile,TextIO.input1 (infile));

fun getList1 (infile, NONE) = nil
| getList1 (infile, SOME c) = 
[implode(getWord (infile))] @ getList1 (infile, TextIO.lookahead infile);

fun getList (infile) = getList1(infile, TextIO.lookahead infile);


(* --------------------------------------- *)


fun sizeList(nil) = 0
| sizeList(x::xs) = 1 + sizeList(xs);

fun sublist_left(nil, _) = nil
| sublist_left(L, 0) = nil
| sublist_left(x::xs, k) = x::sublist_left(xs, k-1);

fun sublist_right(nil, _) = nil
| sublist_right(L, 0) = L
| sublist_right(x::xs, k) = sublist_right(xs, k-1);
(* deletes first k element from the list *)


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


(* --------------------------- *)

fun maxInd(nil, max, ind_max, curr_ind) = ind_max
| maxInd(x::xs, max, ind_max, curr_ind) = if x>max
then maxInd(xs, x, curr_ind, curr_ind + 1) else maxInd(xs, max, ind_max, curr_ind + 1);

fun pancake_sort(nil, _, _) = nil
| pancake_sort(L, n,  1) = L
| pancake_sort(L, n, curr_size) = 
let
    val max_i = maxInd(sublist_left(L, curr_size), 0, 0, 0)
    val L1 = reverseList(sublist_left(L, max_i+1))@sublist_right(L, max_i+1)
    val L2 = reverseList(sublist_left(L1, curr_size))@sublist_right(L1, curr_size)
in
    pancake_sort(L2, n, curr_size-1)
end;

fun pancake_sort1(L) = pancake_sort(L, sizeList(L), sizeList(L));



fun solve(string) = 
let
    val infile = TextIO.openIn "test.txt"
    val stringList = getList(infile)
    val numList = getNumList(stringList)
    val close = TextIO.closeIn infile
in
    pancake_sort1(numList)
end;

solve("test.txt");