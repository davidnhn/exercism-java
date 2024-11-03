% Define the 'chatty' fact
chatty(gustavo).
chatty(valeria).

% Define the 'likes' fact
likes(esteban, malena).
likes(malena, esteban).
likes(gustavo, valeria).

% Define the 'pairing' rule
pairing(Personne1, Personne2) :- 
    (likes(Personne1, Personne2), likes(Personne2, Personne1));
    (chatty(Personne1); chatty(Personne2)).
    
% Define the 'seating' rule
seating(Personne1, Personne2, Personne3, Personne4, Personne5) :-
    pairing(Personne1, Personne2),
    pairing(Personne2, Personne3),
    pairing(Personne3, Personne4),
    pairing(Personne4, Personne5),
    pairing(Personne5, Personne1).