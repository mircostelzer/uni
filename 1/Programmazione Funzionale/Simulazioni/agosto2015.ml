fun elementi_pari(nil) = nil
| elementi_pari([x]) = nil
| elementi_pari(x::y::ys) = y::elementi_pari(ys);

elementi_pari([2]);