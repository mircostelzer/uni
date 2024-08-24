fun sum_single(0, 0, 0) = (0, 0)
| sum_single(0, 0, 1) = (1, 0)
| sum_single(0, 1, 0) = (1, 0)
| sum_single(0, 1, 1) = (0, 1)
| sum_single(1, 0, 0) = (1, 0)
| sum_single(1, 0, 1) = (0, 1)
| sum_single(1, 1, 0) = (0, 1)
| sum_single(1, 1, 1) = (1, 1)
| sum_single(_, _, _) = (0, 0)


fun sum_helper(nil, nil, 1) = [1]
| sum_helper(nil, nil, _) = nil
| sum_helper(x::xs, nil, carry) = 
let 
    val (res, c) = sum_single(x, 0, carry)
in 
    res::sum_helper(xs, nil, c)
end
| sum_helper(nil, y::ys, carry) = 
let 
    val (res, c) = sum_single(0, y, carry)
in 
    res::sum_helper(ys, nil, c)
end
| sum_helper(x::xs, y::ys, carry) =
let 
    val (res, c) = sum_single(x, y, carry)
in 
    res::sum_helper(xs, ys, c)
end;

fun sum_binary(L1, L2) = List.rev(sum_helper(List.rev(L1), List.rev(L2), 0));

sum_binary([],[]);

sum_binary([1,0],[1]); val it = [1, 1]: int list;

sum_binary([1,0,0,1],[1,1,0]); val it = [1, 1, 1, 1]: int list;

sum_binary([1],[1,1]); val it = [1, 0, 0]: int list;

sum_binary([1,1,0,0,1,1],[1,0,1,0]); val it = [1, 1, 1, 1, 0, 1]: int list;

sum_binary([1,0,0,1,1],[1,1,1,0,1]); val it = [1, 1, 0, 0, 0, 0]: int list;
