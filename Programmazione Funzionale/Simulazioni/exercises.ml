fun createList(n, m) =
if m <= n then nil else
let
    val diff = m-n
    fun listM(a, 0, res) = res
    | listM(a, l, res) =  listM(a-1, l-1, a::res);
in
    n::listM(m-1, diff-1, [m])
end;

createList(4, 4);

val raddoppia = map (fn n => 2*n);

raddoppia [1, 2, 3, 4];