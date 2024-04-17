fun getWord(fin, NONE) = nil
| getWord(fin, SOME c) = if c = #" " then nil else c::getWord(fin, TextIO.input1(fin)); 

fun getList(fin, NONE) = nil
| getList(fin, SOME c) =
let
    val word = implode(getWord(fin, TextIO.input1(fin)))
in
    word::getList(fin, TextIO.lookahead(fin))
end;

val fin = TextIO.openIn("IO.txt");

getList(fin, TextIO.lookahead(fin));