((*
Scrivere una funzione Standard ML, chiamata prodotto, che ha tipo naturale -> naturale -> naturale, che calcola il prodotto di due numeri naturali.

Si noti che la funzione prodotto puo' usare la funzione somma nella sua implementazione.
*)

val rec prodotto = fn zero			=> (fn n => zero)
					| n1			=> (fn zero => zero)
					| successivo n2 => if n2 = zero then
											1
										else
											prodotto(somma n1 n1) (n2));
