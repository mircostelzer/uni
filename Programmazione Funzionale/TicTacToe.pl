:- dynamic o/1.
:- dynamic x/1.
x(_).
o(a).
ordered_line(1, 2, 3).
ordered_line(4, 5, 6).
ordered_line(7, 8, 9).
ordered_line(1, 4, 7).
ordered_line(2, 5, 8).
ordered_line(3, 6, 9).
ordered_line(1, 5, 9).
ordered_line(3, 5, 7).
line(A, B, C) :- ordered_line(A, B, C).
line(A, B, C) :- ordered_line(A, C, B).
line(A, B, C) :- ordered_line(B, A, C).
line(A, B, C) :- ordered_line(B, C, A).
line(A, B, C) :- ordered_line(C, A, B).
line(A, B, C) :- ordered_line(C, B, A).
move(A) :- good(A), empty(A).
full(A) :- x(A).
full(A) :- o(A).
empty(A) :- not(full(A)).

win(A) :- x(B), x(C), line(A, B, C).
block_win(A) :- o(B), o(C), line(A, B, C).
split(A) :- x(B), x(C), different(B, C),
line(A, B, D), line(A, C, E), empty(D), empty(E).
same(A, A).
different(A, B) :- not(same(A, B)).
strong_build(A) :- x(B), line(A, B, C), empty(C), not(risky(C)).
risky(C) :- o(D), line(C, D, E), empty(E).
weak_build(A) :- x(B), line(A, B, C), empty(C),
not(double_risky(C)).
double_risky(C) :- o(D), o(E), different(D, E), line(C, D, F),
line(C, E, G), empty(F), empty(G).
% strategies:
good(A) :- win(A).
good(A) :- split(A).
good(A) :- block_win(A).
good(A) :- weak_build(A).
good(A) :- strong_build(A).
good(5).
good(1).
good(3).
good(7).
good(9).
good(2).
good(4).
good(6).
good(8).

all_full :- full(1), full(2), full(3), full(4), full(5), full(6),
full(7), full(8), full(9).
done :- line(A,B,C), x(A), x(B), x(C), write('I won'), nl.
done :- all_full, write('Draw'), nl.
% User's move
getmove :- repeat, write('Please enter a move: '), read(X), empty(X),
asserta(o(X)).
makemove :- move(X), !, asserta(x(X)).
makemove :- all_full.
% Computer's move
respond :- line(A,B,C), o(A), o(B), o(C),
printboard, write('You won.'), nl. %Shouldn't ever happen!
respond :- makemove, printboard, done.
printsquare(N) :- o(N), write( o ).
printsquare(N) :- x(N), write( x ).
printsquare(N) :- empty(N), write(‘ ‘).
printboard :- printsquare(1), printsquare(2), printsquare(3), nl,
printsquare(4), printsquare(5), printsquare(6), nl,
printsquare(7), printsquare(8), printsquare(9), nl.

% Clear everything to start a new game.
clear :- retractall(x(_)), retractall(o(_)),
write('Board:'), nl,
write(' 1 '), write(' 2 '),write(' 3 '), nl,
write(' 4 '), write(' 5 '),write(' 6 '), nl,
write(' 7 '), write(' 8 '),write(' 9 '), nl,
write('You will be o, computer will be x. '), nl,
write('Enter moves by giving a number (1-9) followed by a period.'),nl,
nl.
% main goal:
play :- clear, repeat, getmove, respond.