datatype naturale = zero | successivo of naturale;

val rec somma = fn zero => (fn n => n)
| successivo a => (fn n => successivo (somma a n));

val rec prodotto = fn zero => (fn n => zero)
| successivo a => (fn n => (somma n (prodotto a n)));