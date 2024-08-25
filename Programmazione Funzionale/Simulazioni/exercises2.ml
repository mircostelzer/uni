exception InvalidNumber;

fun harmonic(1) = 1.0
| harmonic(n) = if (n<=0) then raise InvalidNumber else (1.0/(real(n)) + harmonic(n-1));

harmonic(3);

harmonic(1);

harmonic(~2);

fun count(string, char) =
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
