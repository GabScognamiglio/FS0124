/* ESERCIZIO 1
 Scrivi un algoritmo per trovare il più grande tra due numeri interi.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
let num1 = 12
let num2 = 50

if (num1 > num2) { console.log(num1) }
else { console.log(num2) }
/* ESERCIZIO 2
  Scrivi un algoritmo che mostri "not equal" in console se un numero intero fornito è diverso da 5.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
let num3 = 16

if (num3 !== 5) { console.log('not equal') }

/* ESERCIZIO 3
  Scrivi un algoritmo che mostri "divisibile per 5" in console se un numero fornito è perfettamente divisibile per 5 (suggerimento: usa l'operatore modulo)
*/

/* SCRIVI QUI LA TUA RISPOSTA */
let num4 = 60
let resto = num4 % 5

if (resto === 0) { console.log('il resto è ' + resto + ' quindi ' + num4 + ' è divisibile per 5') }
else { console.log('numero non divisibile per 5') }

/* ESERCIZIO 4
  Scrivi un algoritmo per verificare che, dati due numeri interi, il valore di uno di essi sia 8 oppure se la loro addizione/sottrazione sia uguale a 8.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
let num5 = 5
let num6 = 3

if (num5 === 8 || num6 === 8) { console.log('uno dei due numeri è 8') }
else if (num5 + num6 === 8 || num5 - num6 === 8 || num6 - num5 === 8) { console.log('l\'addizione/sottrazione dei due numeri equivale a 8') }
else { console.log('nessuno dei due numeri equivale a 8, nè la loro sottrazione/addizione equivale a 8') }

/* ESERCIZIO 5
  Stai lavorando su un sito di e-commerce. Stai salvando il saldo totale del carrello dell'utente in una variabile "totalShoppingCart".
  C'è una promozione in corso: se il totale del carrello supera 50, l'utente ha diritto alla spedizione gratuita (altrimenti la spedizione ha un costo fisso pari a 10).
  Crea un algoritmo che determini l'ammontare totale che deve essere addebitato all'utente per il checkout.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
let totalShoppingCart = 100
let shippingCost = 10

if (totalShoppingCart <= 50) { console.log('il totale del carrello è ' + (totalShoppingCart + shippingCost) + ' euro, di cui ' + shippingCost + ' euro di spedizione') }
else { console.log('il totale del carrello è ' + totalShoppingCart + ', con spedizione gratuita!') }

/* ESERCIZIO 6
  Stai lavorando su un sito di e-commerce. Oggi è il Black Friday e viene applicato il 20% su ogni prodotto.
  Modifica la risposta precedente includendo questa nuova promozione nell'algoritmo, determinando come prima se le spedizioni sono gratuite oppure no e e calcolando il totale.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
let day = 'BlackFriday'
if (day === 'BlackFriday') { totalShoppingCart *= 0.8 }
console.log(totalShoppingCart)

if (totalShoppingCart <= 50) { console.log('il totale del carrello è ' + (totalShoppingCart + shippingCost) + ' euro, di cui ' + shippingCost + ' euro di spedizione') }
else { console.log('il totale del carrello è ' + totalShoppingCart + ', con spedizione gratuita!') }

/* ESERCIZIO 7
  Crea tre variabili, e assegna un valore numerico a ciascuna di esse.
  Utilizzando un blocco condizionale, crea un algoritmo per ordinarle secondo il loro valore, dal più alto al più basso.
  Alla fine mostra il risultato in console.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
let var1 = 16
let var2 = 95
let var3 = 5
console.log(var1, var2, var3)

if (var1 < var2 && var1 < var3) { console.log(var1) }
else if (var2 < var1 && var2 < var3) { console.log(var2) }  /*condizioni per far stampare la var più piccola*/
else { console.log(var3) }

if ((var1 < var2 && var1 > var3) || (var1 > var2 && var1 < var3)) { console.log(var1) }
else if ((var2 < var1 && var2 > var3) || (var2 > var1 && var2 < var3)) { console.log(var2) }   /*condizioni per far stampare la var di mezzo*/
else { console.log(var3) }

if (var1 > var2 && var1 > var3) { console.log(var1) }
else if (var2 > var1 && var2 > var3) { console.log(var2) }  /*condizioni per far stampare la var più grande*/
else { console.log(var3) }




/* ESERCIZIO 8
  Crea un algoritmo per verificare che un valore fornito sia un numero oppure no (suggerimento: cerca su un motore di ricerca "typeof").
*/

/* SCRIVI QUI LA TUA RISPOSTA */

/* ESERCIZIO 9
  Crea un algoritmo per controllare se un numero fornito sia pari o dispari (suggerimento: cerca l'operatore modulo su un motore di ricerca)
*/

/* SCRIVI QUI LA TUA RISPOSTA */

/* ESERCIZIO 10
  Modifica la logica del seguente algoritmo in modo che mostri in console il messaggio corretto in ogni circostanza.
  let val = 7
  if (val < 10) {
      console.log("Meno di 10");
    } else if (val < 5) {
      console.log("Meno di 5");
    } else {
      console.log("Uguale a 10 o maggiore");
    }
*/

/* SCRIVI QUI LA TUA RISPOSTA */

/* ESERCIZIO 11
  Fornito il seguente oggetto, scrivi del codice per aggiungere una proprietà "city", il cui valore sarà "Toronto".
*/

const me = {
  name: 'John',
  lastName: 'Doe',
  skills: ['javascript', 'html', 'css'],
}

/* SCRIVI QUI LA TUA RISPOSTA */

/* ESERCIZIO 12
  Lavorando sempre sull'oggetto precedentemente fornito, scrivi del codice per rimuovere la proprietà "lastName".
*/

/* SCRIVI QUI LA TUA RISPOSTA */

/* ESERCIZIO 13
  Lavorando sempre sull'oggetto precedentemente fornito, scrivi del codice per rimuovere l'ultimo elemento della proprietà "skills".
*/

/* SCRIVI QUI LA TUA RISPOSTA */

/* ESERCIZIO 14
  Scrivi del codice per creare un array inizialmente vuoto. Riempilo successivamente con i numeri da 1 a 10.
*/

/* SCRIVI QUI LA TUA RISPOSTA */

/* ESERCIZIO 15
  Scrivi del codice per sostituire l'ultimo elemento dell'array, ovvero il valore 10, con il valore 100.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
