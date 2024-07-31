(* funzione per leggere il file *)
fun readFile nomefile =
        let    
            val fileStream = TextIO.openIn nomefile (* apro il file in lettura*)
            (* funzione ricorsiva per leggere le righe del file *)
            fun leggiriga acc =
                    (* usiamo NONE e SOME che indicano la presenza o assenza di in qualsiasi valore*)
                    case TextIO.inputLine fileStream of
                        (* se non c'è nessun valore chiudiamo il file e restituiamo una lista con tutte le righe del file*)
                        NONE => (TextIO.closeIn fileStream; List.rev acc)
                        (* facciamo explode e implode per normalizzare la lista e togliere eventuali caratteri di escape*)
                    |   SOME linea => leggiriga (String.implode (String.explode linea) :: acc)
        in
            leggiriga []
        end

(* funzione per estrarre i numeri dalle linee del file *)
fun estrainumeri linea =
        let
            val numeri = String.explode linea
            (* trasformiamo la stringa in una lista di caratteri 
               e definiamo una funzione per controllare se un carattere è un numero *)
            fun isnumero c = Char.isDigit c
            (* prendiamo il primo e l'ultimo numero della stringa *)
            val primonum = List.find isnumero numeri
            val ultimonum = List.find isnumero (List.rev numeri)
        in
            case (primonum, ultimonum) of
                (* Se nella lista ci sono numeri combina le due cifre, altrimenti restituisce 0 *)
                (* Char.ord converte un carattere cifra nel suo valore numerico ascii *)
                (* Char.ord #"0" = 48 e va sottratto perchè così ci restituisce il valore numerico corrispondente al carattere *)
                (* esempio: #"1" = 49, #"2" = 50, #"3" = 51, ecc. ecc. *)
                (SOME p, SOME u) => 10 * (Char.ord p - Char.ord #"0") + (Char.ord u - Char.ord #"0")
            |   _ => 0
        end

(* funzione per invertire l'array fino a un certo punto i*)
(*arr è la lista che vogliamo invertire, i è l'indice fino a dove vogliamo invertirla (incluso)*)
fun reverse(arr, i) =
        (* il primo parametro è la lista, il secondo l'indice e il terzo è la lista in cui salviamo i risultati parziali*)
        let
            fun rev ([], _, res) = res
                (*nel caso base gestiamo la lista vuota*)
                | rev (lst, 0, res) = res @ lst
                (*nel caso in cui l'indice è 0 restituiamo la lista accumulata con la lista rimanente concatenate*)
                | rev (x::xs, n, res) = rev(xs, n-1, x::res)
                (*chiamata ricorsiva:
                  qui x::xs è la lista con primo e i restanti elementi, 
                  chiama ricorsivamente i restanti elementi oltre il primo
                  e il primo viene inserito nella lista accumulata, n-1 decrementa l'indice
                  perchè abbiamo eseguito una operazione*)
        in
            rev(arr, i+1, [])
            (* la chiamiamo con i+1 perchè così l'indice viene incluso*)
        end

(* trovo indice del massimo di array fino ad un certo limite*)
fun indicemax (arr, n) =
        (*ricorsivamente passiamo la lista e teniamo traccia dell'elemento maggiore e del suo indice*)
        let
            fun indicemaxaus([], _, _, maxIdx) = maxIdx
                (*caso base, se la lista è vuota ritorna l'indice*)
                | indicemaxaus(x::xs, currIdx, currMax, maxIdx) =
                    (* currIdx è l'indice corrente, currMax è il valore massimo trovato fin'ora e maxIdx è il suo indice*)
                    if currIdx >= n then maxIdx
                        (*se l'indice corrente è maggiore o uguale a n che è il nostro indice limite ci fermiamo e restituiamo l'indice del valore massimo*)
                    else 
                        if x > currMax then
                            indicemaxaus(xs, currIdx + 1, x, currIdx)
                            (*altrimenti se l'elemento corrente è maggiore del valore massimo trovato fin'ora richiamiamo la funzione aggiornando l'indice corrente e la x come valori massimi*)
                        else
                            indicemaxaus(xs, currIdx + 1, currMax, maxIdx)
                            (*altrimenti scorriamo la lista e passiamo al prossimo indice*)
        in
            indicemaxaus(arr, 0, hd arr, 0)
            (*chiamiamo la funzione ausiliaria sulla nostra lista partendo da zero*)
        end

(* pancake sort *)
fun pancakeSort arr =
        let
            fun sortaus (arr, currSize) =
                    (* funzione ausiliaria che prende la lista e la sua lunghezza attuale *)
                    if currSize <= 1 then arr
                        (*se la lunghezza è <= 1 restituiamo la lista che è ora ordinata*)
                    else
                        let
                            val maxIdx = indicemax (arr, currSize)
                            (*usiamo la funzione scritta prima che ci da l'indice del valore massimo*)
                            val arr1 = reverse(arr, maxIdx)
                            (*invertiamo la lista fino all'indice massimo che finisce in cima*)
                            val arr2 = reverse(arr1, currSize - 1)
                            (* invertiamo di nuovo la lista in modo che il valore massimo finisca alla fine *)
                        in
                            sortaus (arr2, currSize - 1)
                            (*richiamiamo la funzione ricorsivamente con la lista con l'ultimo elemento ordinato e la lunghezza decrementata in modo da non considerarlo e ordinare il resto*)
                        end
        in
            sortaus (arr, length arr)
            (*chiamiamo la funzione ausiliaria con la lista e la sua lunghezza*)
        end

(* funzione solve principale *)
fun solve nomefile =
        let
            val linee = readFile nomefile
            (* leggiamo il file e salviamo le righe in una lista*)
            val numeri = map estrainumeri linee
            (* estraiamo i numeri dalle righe del file*)
            val numeriordinati = pancakeSort numeri
            (* ordiniamo i numeri con pancake sort *)
        in
            numeriordinati
        end

val sol = solve "test.txt";