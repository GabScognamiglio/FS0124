//generazione griglia calendario

//oggi che giorno è?
const now= new Date();
const getMonth= now.getMonth(); //variabile globale, usata inpiù function

//sappiamo in che mese siamo, quanti giorni ha il mese? dobbiamo anche creare un array del mese, che conterrà tanti array quanti sono i giorni del mese. Il numero di giorni quindi genererà la griglia visiva e l'array.

const appointments=[];

const monthNames=[
    'Gennaio',
    'Febbraio',
    'Marzo',
    'Aprile',
    'Maggio',
    'Giugno',
    'Luglio',
    'Agosto',
    'Settembre',
    'Ottobre',
    'Novembre',
    'Dicembre'
]

//scriviamo il nome del mese nell'h1 dell'html
const printCurrentMonthInh1= ()=>{
    const title= document.querySelector('h1');
    const monthIndex= now.getMonth(); // da 0 a 11. 0 gennaio, 11 dicembre
    const currentMonth = monthNames[monthIndex] //dall'indice mese preso sopra, mi do il nome italiano del mese
    title.innerText=currentMonth;
}

printCurrentMonthInh1();

//calcolare numero giorni del mese trovato, per generare la griglia e l'array
//mi serve prndere il primo giorno del mese successivo al mese trovato e poi ottenere il giorno prima, che sarà l'ultimo giorno del mese in corso; il numero deell'ultimo giorno del mese corrente corrisponderà al numero di giorni totali

const daysInThisMonth= ()=>{
    const getYear= now.getFullYear();
    const lastDayInTheMonth=new Date(getYear, getMonth +1, 0); //prendo l'ultimo giorno del mese (anno, mese prossimo, giorno 0 che non esiste, quindi mi da l'ultimo del mese corrente)
    console.log(lastDayInTheMonth);
}
daysInThisMonth();