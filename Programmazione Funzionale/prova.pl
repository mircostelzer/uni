mouse(mickey).
mouse(jerry).
cat(tom).
cat(felix).
taller(tom,felix).
taller(X,Y):-
cat(X), mouse(Y).

member(X, [X|T]).
member(X, [H|T]) :- member(X, T).
sorted([]).
sorted([X]).
sorted([A, B | T]) :- A =< B, sorted([B | T]).