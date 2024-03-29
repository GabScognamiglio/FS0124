/*
REGOLE
- Tutte le risposte devono essere scritte in JavaScript
- Puoi usare Google / StackOverflow ma solo quanto ritieni di aver bisogno di qualcosa che non è stato spiegato a lezione
- Puoi testare il tuo codice in un file separato, o de-commentando un esercizio alla volta
- Per visualizzare l'output, lancia il file HTML a cui è collegato e apri la console dagli strumenti di sviluppo del browser. 
- Utilizza dei console.log() per testare le tue variabili e/o i risultati delle espressioni che stai creando.
*/

/* ESERCIZIO 1
    Dato il seguente array, scrivi del codice per stampare ogni elemento dell'array in console.
*/
const pets = ['dog', 'cat', 'hamster', 'redfish']
function stampaPets() {
  for (let i = 0; i < pets.length; i++) {
    console.log(pets[i])
  }
}
console.log('***ESERCIZIO 1***')
stampaPets()

/* ESERCIZIO 2
    Scrivi del codice per ordinare alfabeticamente gli elementi dell'array "pets".
*/
console.log('***ESERCIZIO 2***')

pets.sort()
console.log(pets)

/* ESERCIZIO 3
    Scrivi del codice per stampare nuovamente in console gli elementi dell'array "pets", questa volta in ordine invertito.
*/
console.log('***ESERCIZIO 3***')

function reversePets() {
  pets.reverse()
  console.log(pets)
}

reversePets()

/* ESERCIZIO 4
    Scrivi del codice per spostare il primo elemento dall'array "pets" in ultima posizione.
*/
console.log('***ESERCIZIO 4***')

function firstLast() {
  let primoPet = pets.splice(0, 1)
  pets.push(primoPet[0])
  console.log(pets)

}

firstLast()
/* ESERCIZIO 5
    Dato il seguente array di oggetti, scrivi del codice per aggiungere ad ognuno di essi una proprietà "licensePlate" con valore a tua scelta.
*/
const cars = [
  {
    brand: 'Ford',
    model: 'Fiesta',
    color: 'red',
    trims: ['titanium', 'st', 'active'],
  },
  {
    brand: 'Peugeot',
    model: '208',
    color: 'blue',
    trims: ['allure', 'GT'],
  },
  {
    brand: 'Volkswagen',
    model: 'Polo',
    color: 'black',
    trims: ['life', 'style', 'r-line'],
  },
]

console.log('***ESERCIZIO 5***')

for (let i = 0; i < cars.length; i++) {
  if (cars[i].brand === 'Ford') {
    cars[i].licensePlate = 'aa000bb'
  }
  else if (cars[i].brand === 'Peugeot') {
    cars[i].licensePlate = 'cc111dd'
  }
  else {
    cars[i].licensePlate = 'ee222ff'
  }
}
console.log(cars)
/* ESERCIZIO 6
    Scrivi del codice per aggiungere un nuovo oggetto in ultima posizione nell'array "cars", rispettando la struttura degli altri elementi.
    Successivamente, rimuovi l'ultimo elemento della proprietà "trims" da ogni auto.
*/
console.log('***ESERCIZIO 6***')

let newCar = { brand: 'Opel', model: 'Karl', color: 'Dark Gray', trims: ['base', 'nJoy', 'Cosmo'], licensePlate: 'ff555gg' }

function aggiungiCar(c) {
  cars.push(c)
  console.log(cars)
}

aggiungiCar(newCar)

function deleteTrim() {
  for (i = 0; i < cars.length; i++) {
    cars[i].trims.splice(-1, 1)
  }
  console.log(cars)
}
deleteTrim()


/* ESERCIZIO 7
    Scrivi del codice per salvare il primo elemento della proprietà "trims" di ogni auto nel nuovo array "justTrims", sotto definito.
*/
console.log('***ESERCIZIO 7***')

const justTrims = []

for (i = 0; i < cars.length; i++) {
  justTrims.push(cars[i].trims.slice(0, 1))
}

console.log(justTrims)

/* ESERCIZIO 8
    Cicla l'array "cars" e costruisci un if/else statament per mostrare due diversi messaggi in console. Se la prima lettera della proprietà
    "color" ha valore "b", mostra in console "Fizz". Altrimenti, mostra in console "Buzz".
*/
console.log('***ESERCIZIO 8***')

function fizzBuzz() {
  for (i = 0; i < cars.length; i++) {
    if (cars[i].color.charAt(0) === 'b') {
      console.log('Fizz')
    }
    else {
      console.log('Buzz')
    }
  }
}

fizzBuzz()
/* ESERCIZIO 9
    Utilizza un ciclo while per stampare in console i valori del seguente array numerico fino al raggiungimento del numero 32.
*/
const numericArray = [
  6, 90, 45, 75, 84, 98, 35, 74, 31, 2, 8, 23, 100, 32, 66, 313, 321, 105,
]

console.log('***ESERCIZIO 9***')

let g = 0

while (g < numericArray.length) {
  console.log(numericArray[g])

  if (numericArray[g] === 32) {
    break;
  }
  g++
}


/* ESERCIZIO 10
    Partendo dall'array fornito e utilizzando un costrutto switch, genera un nuovo array composto dalle posizioni di ogni carattere all'interno
    dell'alfabeto italiano.
    es. [f, b, e] --> [6, 2, 5]
*/
const charactersArray = ['g', 'n', 'u', 'z', 'd']

console.log('***ESERCIZIO 10***')

let ordAlf = []
for (let i = 0; i < charactersArray.length; i++) {


  switch (charactersArray[i]) {
    case 'a':
      ordAlf.push(1);
      break;
    case 'b':
      ordAlf.push(2);
      break;
    case 'c':
      ordAlf.push(3);
      break;
    case 'd':
      ordAlf.push(4);
      break;
    case 'e':
      ordAlf.push(5);
      break;
    case 'f':
      ordAlf.push(6);
      break;
    case 'g':
      ordAlf.push(7);
      break;
    case 'h':
      ordAlf.push(8);
      break;
    case 'i':
      ordAlf.push(9);
      break;
    case 'l':
      ordAlf.push(10);
      break;
    case 'm':
      ordAlf.push(11);
      break;
    case 'n':
      ordAlf.push(12);
      break;
    case 'o':
      ordAlf.push(13);
      break;
    case 'p':
      ordAlf.push(14);
      break;
    case 'q':
      ordAlf.push(15);
      break;
    case 'r':
      ordAlf.push(16);
      break;
    case 's':
      ordAlf.push(17);
      break;
    case 't':
      ordAlf.push(18);
      break;
    case 'u':
      ordAlf.push(19);
      break;
    case 'v':
      ordAlf.push(20);
      break;
    case 'z':
      ordAlf.push(21);
      break;

  }
}
console.log(ordAlf)
