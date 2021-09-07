/* 1. Zadatak: */
SELECT * FROM profesori
WHERE godine > 45;


/* 2. Zadatak: */
SELECT ime, prezime FROM ucenici 
WHERE godine > 15 AND prosek > 6.5;


/* 3. Zadatak: */
SELECT godine FROM ucenici
ORDER BY godine DESC;


/* 4. Zadatak: */
SELECT * FROM profesori
WHERE predmet = 'Informatika';


/* 5. Zadatak: */
SELECT ucenikid, ime, prezime FROM ucenici
WHERE LENGTH (ime) = 6;
