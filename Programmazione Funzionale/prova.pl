mouse(mickey).
mouse(jerry).
cat(tom).
cat(felix).
taller(tom,felix).
taller(X,Y):-
cat(X), mouse(Y).