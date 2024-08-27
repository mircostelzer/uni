exception InvalidNumber;

fun harmonic(1) = 1.0
| harmonic(n) = if (n<=0) then raise InvalidNumber else (1.0/(real(n)) + harmonic(n-1));

harmonic(3);

harmonic(1);

harmonic(~2);

fun count (string, char) =
let
    fun count_aux(nil, _) = 0
    | count_aux(x::xs, c) = if (x = c) then 1+count_aux(xs, c) else count_aux(xs, c)
in
    count_aux(explode(string), char)
end;

count("pippo", #"p");

fun countf(file, char) =
let
    val infile = TextIO.openIn(file)
    val string = TextIO.input(infile)
    fun count_aux(nil, _) = 0
    | count_aux(x::xs, c) = if (x = c) then 1+count_aux(xs, c) else count_aux(xs, c)
in
    count_aux(explode(string), char)

end;

countf("test.txt", #"p");

fun repetition(_, 0) = nil
| repetition(a, n) = a::repetition(a, n-1);

repetition("hello", 3);

fun summul(_, nil) = 0
| summul(nil, _) = 0
| summul(x::xs, y::ys) = x*y+summul(xs, ys);

summul([1, 2, 3], [2, 3, 4]);
summul([4, 5], [1]);
summul([], []);

fun pow _ 0 = 1
| pow x n = x * (pow x (n-1));

fun powl(x, n) = if (n < 0) then nil else (pow x n)::powl(x, n-1);

powl(2, 3);

powl(3, 1);

powl(10, 0);

fun poly(n, L) = 
let
    val p = powl(n, List.length(L)-1)
in 
    summul(L, p)
end;

poly(2, [3, ~2, 0, 1]);

poly(3, [2]);

fun repeat(nil, _) = nil
| repeat(_, nil) = nil
| repeat(x::xs, y::ys) = 
let
    fun helper(x, 0) = nil
    | helper(x, n) = x::helper(x, n-1);
in
    helper(x, y)@repeat(xs, ys)
end;

repeat([1, 2, 3], [4, 0, 3]);

repeat([#"a", #"b", #"c"], [4, 1]);

fun splitup(nil) = (nil, nil)
| splitup(x::xs) =
let 
    val (M, N) = splitup(xs)
in
    if (x < 0) then (M, x::N) else (x::M, N)
end; 

splitup([1, ~2, 0, ~3, ~1]);

fun isSorted(nil) = true
| isSorted([a]) = true
| isSorted(x::y::ys) = if (x > y) then false else isSorted(y::ys); 

isSorted([1, 2, 2, 3]);

isSorted([1, 4, 3]);

isSorted([1, 2, 3, 2]);

datatype 'label tree = Node of 'label * 'label tree list;


fun sum(Node(x, tree)) = x + foldr (op+) 0 (map sum tree);
(* alternative *)
fun sum(Node(x, nil)) = x
| sum(Node(x, t::ts)) = sum(t) + sum(Node(x, ts));

val t = Node (1, [
Node (2,nil),
Node (3, [
Node (4,nil),
Node (5, [
Node (7,nil)
]),
Node (6,nil)
])
]);

sum(t);

fun isOn1(Node(x, nil), y) = (x=y)
| isOn1(Node(x, t), y) = if (x=y) then true else isOn2(t, y)
and
isOn2(nil, y) = false
| isOn2(Node(x, t)::tree, y) = isOn1(Node(x, t), y) orelse isOn2(tree, y);

fun isOn(Node(x, tree), y) = if (x=y) then true else isOn2(tree, y);
(* alternative *)
fun isOn (Node(x, nil)) y = (x=y)
| isOn (Node(x, t::ts)) y = (x=y) orelse isOn t x orelse isOn (Node(x, ts)) y;
(* alternative *)
fun isOn y (Node(x, L)) = (x=y) orelse foldr (fn (x, y) => x orelse y) false (map (isOn x) L);

isOn 5 t;

 