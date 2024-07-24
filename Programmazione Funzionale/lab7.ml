exception shortList of int;

fun returnThird1(nil) = raise shortList(0)
| returnThird1([x]) = raise shortList(1)
| returnThird1([x, y]) = raise shortList(2) 
| returnThird1(x::y::z::zs) = z;  

fun returnThird(L) = returnThird1(L) handle
shortList(n) => (print("List is too short: "); n);

returnThird([1, 2]);

exception OutOfRange of int * int;

fun comb1(n,m)=
if n <= 0 then raise OutOfRange (n,m)
else if m<0 orelse m>n then raise OutOfRange (n,m)
else if m=0 orelse m=n then 1
else comb1 (n-1,m) + comb1 (n-1,m-1);

fun comb (n,m) = comb1 (n,m) handle
OutOfRange (0,0) => 1
| OutOfRange (n,m) => (
print ("out of range: n=");
print (Int.toString(n));
print (" m=");
print (Int.toString(m));
print ("\n");
0
);

exception NegNum of int;

fun fact1(0) = 1
| fact1(n) = if (n<0) then raise NegNum(n)
else n*fact1(n-1);

fun fact(n) = fact1(n) handle
NegNum(n) => (print("Invalid number"); print("\n"); 0);

fact(4);
fact(~2);