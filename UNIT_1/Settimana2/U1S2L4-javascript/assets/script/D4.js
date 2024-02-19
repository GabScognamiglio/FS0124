/* ESERCIZIO 1
 Scrivi una funzione di nome "area", che riceve due parametri (l1, l2) e calcola l'area del rettangolo associato.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
console.log('***ESERCIZIO 1***')
function area(l1, l2) {
    let areaRet;

    areaRet = l1 * l2
    console.log(areaRet)
}

area(7, 5)


/* ESERCIZIO 2
 Scrivi una funzione di nome "crazySum", che riceve due numeri interi come parametri.
 La funzione deve ritornare la somma dei due parametri, ma se il valore dei due parametri è il medesimo deve invece tornare
 la loro somma moltiplicata per tre.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
console.log('***ESERCIZIO 2***')

function crazySum(num1, num2) {
    if (num1 === num2) {
        return (num1 + num2) * 3
    }
    return num1 + num2
}

console.log(crazySum(5, 5))

/* ESERCIZIO 3
 Scrivi una funzione di nome "crazyDiff" che calcola la differenza assoluta tra un numero fornito come parametro e 19.
 Deve inoltre tornare la differenza assoluta moltiplicata per tre qualora il numero fornito sia maggiore di 19.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
console.log('***ESERCIZIO 3***')

function crazyDiff(num1) {
    if (num1 > 19) {
        let abDif3 = Math.abs(num1 - 19) * 3
        return abDif3
    }
    let abDif = Math.abs(num1 - 19)
    return abDif
}

console.log(crazyDiff(20))
/* ESERCIZIO 4
 Scrivi una funzione di nome "boundary" che accetta un numero intero n come parametro, e ritorna true se n è compreso tra 20 e 100 (incluso) oppure
 se n è uguale a 400.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
console.log('***ESERCIZIO 4***')

function boundary(n) {
    if (typeof (n) !== 'number') {
        return 'valore non valido';
    }
    else if (n >= 20 && n <= 100 || n === 400) {
        return true;
    }
    else {
        return false;
    }

}

console.log(boundary(50))

/* ESERCIZIO 5
 Scrivi una funzione di nome "epify" che accetta una stringa come parametro.
 La funzione deve aggiungere la parola "EPICODE" all'inizio della stringa fornita, ma se la stringa fornita comincia già con "EPICODE" allora deve
 ritornare la stringa originale senza alterarla.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
console.log('***ESERCIZIO 5***')

function epify(lett) {
    if (typeof (lett) !== 'string') {
        return 'valore non valido';
    }
    else if (lett === 'EPICODE') {
        return lett;
    }
    else {
        let epic = 'EPICODE'
        return epic.concat(' ' + lett)
    }
}

console.log(epify('school'))

/* ESERCIZIO 6
 Scrivi una funzione di nome "check3and7" che accetta un numero positivo come parametro. La funzione deve controllare che il parametro sia un multiplo
 di 3 o di 7. (Suggerimento: usa l'operatore modulo)
*/

/* SCRIVI QUI LA TUA RISPOSTA */
console.log('***ESERCIZIO 6***')

function check3and7(n) {
    if (typeof (n) !== 'number' || n < 0) {
        return 'valore non valido'
    }
    else if (n % 3 === 0 && n % 7 === 0) {
        return (n + ' è multiplo di 3 e di 7')
    }
    else if (n % 3 === 0) {
        return (n + ' è multiplo di 3')
    }
    else if (n % 7 === 0) {
        return (n + ' è multiplo di 7')
    }
    else { return (n + ' non è nè multiplo di 3 nè multiplo di 7') }

}

console.log(check3and7(21))
/* ESERCIZIO 7
 Scrivi una funzione di nome "reverseString", il cui scopo è invertire una stringa fornita come parametro (es. "EPICODE" --> "EDOCIPE")
*/


/* SCRIVI QUI LA TUA RISPOSTA */
console.log('***ESERCIZIO 7***')

function reverseString(stringa) {
    if (typeof (stringa) !== 'string') {
        return 'valore non valido'
    }
    else {
        let stringaInv = stringa.split('').reverse().join('')
        return stringaInv
    }
}
console.log(reverseString('gabriele'))

/* ESERCIZIO 8
 Scrivi una funzione di nome "upperFirst", che riceve come parametro una stringa formata da diverse parole.
 La funzione deve rendere maiuscola la prima lettera di ogni parola contenuta nella stringa.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
console.log('***ESERCIZIO 8***')

function upperFirst(word) {
    if (typeof (word) !== 'string') {
        return 'valore non valido'
    }
    else {
        let parole = word.split('')
        
    }
}
/* ESERCIZIO 9
 Scrivi una funzione di nome "cutString", che riceve come parametro una stringa. La funzione deve creare una nuova stringa senza il primo e l'ultimo carattere
 della stringa originale.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
console.log('***ESERCIZIO 9***')

function cutString(word) {
    if (typeof (word) !== 'string') {
        return 'valore non valido'
    }
    else {
        let cutStr = word.slice(1, -1)
        return cutStr
    }
}
console.log(cutString('orario'))    //niente, risultato non trovato

/* ESERCIZIO 10
 Scrivi una funzione di nome "giveMeRandom", che accetta come parametro un numero n e ritorna un'array contenente n numeri casuali inclusi tra 0 e 10.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
console.log('***ESERCIZIO 10***')

function giveMeRandom(n){
    for (let i=0; i<n; i++){
        console.log (Math.floor(Math.random()*11))
    }
}
giveMeRandom(7)