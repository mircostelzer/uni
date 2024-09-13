datatype Expr = X
| Y
| Avg of Expr * Expr
| Mul of Expr * Expr;

fun compute X a b = a
| compute Y a b = b
| compute (Avg(e1, e2)) a b = (a+b) div 2
| compute (Mul(e1, e2)) a b = a*b;