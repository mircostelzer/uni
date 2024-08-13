datatype 'a tree = 
Empty | Node of 'a * 'a tree * 'a tree;

fun postOrder(Empty) = nil
| postOrder(Node(a, left, right)) = postOrder(left) @ postOrder(right) @ [a];

val t = Node ("ML",
Node ("as",
Node ("a",Empty,Empty),
Node ("in",Empty,Empty)
),
Node ("types",Empty,Empty)
);

postOrder(t);

fun inOrder(Empty) = nil
| inOrder(Node(a, left, right)) = inOrder(left) @ [a] @ inOrder(right);

type ('a, 'b) mapTree = ('a * 'b) tree;

val t1 = Node(("a", 1), Empty, Empty): (string, int) mapTree;

exception Missing;

fun lookup lt Empty a = raise Missing
| lookup lt (Node((b, c), left, right)) a = 
if lt(a, b) then lookup lt left a else 
if lt(b, a) then lookup lt right a else
c;

fun assign lt Empty a b = Node((a, b), Empty, Empty)
| assign lt (Node((d, c), left, right)) a b =
if lt(a, d) then Node((d, c), (assign lt left a b), right) else
if lt(d, a) then Node((d, c), left, (assign lt right a b)) else
Node((a, b), left, right);

fun insert lt Empty x = Node(x,Empty,Empty)
|insert lt (T as Node (y,left,right)) x =
if lt (x,y) then Node (y,(insert lt left x),right)
else if lt (y,x) then Node (y,left,(insert lt right x))
else T;

exception EmptyTree;

fun deletemin (Empty) = raise EmptyTree
| deletemin (Node(y,Empty,right)) = (y,right)
| deletemin (Node(w,left,right)) =
let val (y,L) = deletemin(left)
in (y,Node(w,L,right))
end;

fun delete lt Empty x = Empty
|delete lt (Node(y,left,right)) x =
if lt (x,y) then Node(y,(delete lt left x),right)
else if lt (y,x) then Node(y,left,(delete lt right x))
else
case (left,right) of
(Empty,r) => r |
(l,Empty) => l |
(l,r) =>
let val (z,r1) = deletemin(r)
in Node (z,l,r1)
end;

val f = lookup (op< : real*real->bool);

val g = insert (op< : real*real->bool);

val h = delete (op< : real*real->bool);