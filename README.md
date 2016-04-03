# MailSender
 
1. Dane są dwie tablice P i Q zawierające S nieujemnych liczb całkowitych. Łącznie tablice reprezentują S liczb rzeczywistych, gdzie P to część całkowita
a Q podzielona przez 1_000_000 stanowi część ułamkową: R[N] = P[N] + Q[N] / 1_000_000.

Przykład:

tablice P i Q

    P[0] = 1   Q[0] = 0
    P[1] = 1   Q[1] = 500_000
    P[2] = 2   Q[2] = 0
    P[3] = 2   Q[3] = 50_000
    P[4] = 3   Q[4] = 40_000
    P[5] = 4   Q[5] = 700_000

reprezentujące liczby rzeczywiste

    R[0] = 1.0
    R[1] = 1.5
    R[2] = 2.0
    R[3] = 2.05
    R[4] = 3.04
    R[5] = 4.7

Parę indeksów (M, N) nazywamy "parą dobraną" gdy 0 <= M < N < S i R[M] * R[N] >= R[M] + R[N]

Dla podanego wyżej przykładu mamy:

    (1, 4), ponieważ 1.5 * 3.04 = 4.56 >= 4.54 = 1.5 + 3.04
    (1, 5), ponieważ 1.5 * 4.7 = 7.05 >= 6.2 = 1.5 + 4.7
    (2, 3), ponieważ 2.0 * 2.05 = 4.1 >= 4.05 = 2.0 + 2.05
    (2, 4), ponieważ 2.0 * 3.04 = 6.08 >= 5.04 = 2.0 + 3.04
    (2, 5), ponieważ 2.0 * 4.7 = 9.4 >= 6.7 = 2.0 + 4.7
    (3, 4), ponieważ 2.05 * 3.04 = 6.23 >= 5.09 = 2.05 + 3.04
    (3, 5), ponieważ 2.05 * 4.7 = 9.63 >= 6.75 = 2.05 + 4.7
    (4, 5), ponieważ 3.04 * 4.7 = 14.29 >= 7.74 = 3.04 + 4.7

Napisze funkcję 

    class MatchedPair { public int matchedPair(int[] P, int[] Q); }

która dla tablic P i Q (zerowy indeks), z których każda zawiera S nieujemnych zwróci liczbę "par dobranych". 
Dla przykładu opisanego powyżej funkcja powinna zwrócić 8.

Wejście:

- S jest liczbą całkowitą w przedziale 0-100_000
- każda liczba w tablicy P jest całkowita w przedziale 0-1_000
- każda liczba w tablicy Q jest całkowita w przedziale 0-999_999
- liczby rzeczywiste R utworzone z połączenia tablic są posortowane w porządku niemalejącym.

Zaproponuj rozwiązanie. 

2.
Dana jest baza danych BD z jedną tabelą T. 
W tabeli T znajduje się N rekordów. 
Tabela T reprezentuje informacje o graczu - date, email. date + email = klucz główny
Do bazy podłączonych jest M aplikacji, które cyklicznie, co jakiś zdefiniowany czas pobierają rekordy z tabeli T i 
wysyłają po kolei pod każdy adres z odpowiedzi informacje z przypomnieniem o zalogowaniu się do gry. 
Każda aplikacja może jednorazowo pobrać maksymalnie 100 rekordów.

Zadanie polega na takim zaimplementowaniu aplikacji aby mając M aplikacji które odpytują bazę danych nie dopuścić 
do wysyłania więcej niż jednego powiadomienia do konkretnego gracza.

Technologie:

- Java
- Spring
- MySQL


