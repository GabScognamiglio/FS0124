//generazione griglia calendario

//oggi che giorno è?
const now = new Date();
const getMonth = now.getMonth(); //variabile globale, usata inpiù function

//sappiamo in che mese siamo, quanti giorni ha il mese? dobbiamo anche creare un array del mese, che conterrà tanti array quanti sono i giorni del mese. Il numero di giorni quindi genererà la griglia visiva e l'array.

const appointments = [];

const monthNames = [
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
const printCurrentMonthInh1 = () => {
    const title = document.querySelector('h1');
    const monthIndex = now.getMonth(); // da 0 a 11. 0 gennaio, 11 dicembre
    const currentMonth = monthNames[monthIndex] //dall'indice mese preso sopra, mi do il nome italiano del mese
    title.innerText = currentMonth;
}

printCurrentMonthInh1();

//calcolare numero giorni del mese trovato, per generare la griglia e l'array
//mi serve prndere il primo giorno del mese successivo al mese trovato e poi ottenere il giorno prima, che sarà l'ultimo giorno del mese in corso; il numero deell'ultimo giorno del mese corrente corrisponderà al numero di giorni totali

const daysInThisMonth = () => {
    const getYear = now.getFullYear();
    const lastDayInTheMonth = new Date(getYear, getMonth + 1, 0); //prendo l'ultimo giorno del mese (anno, mese prossimo, giorno 0 che non esiste, quindi mi da l'ultimo del mese corrente)
    console.log(lastDayInTheMonth);
    const numberOfTheDay = lastDayInTheMonth.getDate();
    return numberOfTheDay;
}
daysInThisMonth();


//devo eliminare la classe .selected se presente, altrimenti rimangono selezionati più giorni
const unselectAllDays = () => {
    const previousSelected = document.querySelector('.selected');
    if (previousSelected) {
        previousSelected.classList.remove('selected')
    }
}
//funzione per gestire new meetingday
const changeMeetingDaySection = (indexOfTheDay) => {
    const rightSpan = document.getElementById('newMeetingDay');
    rightSpan.classList.add('hasDay');
    rightSpan.innerText = indexOfTheDay + 1;
}

const showAppointments = (indexOfTheDay) => {
    const appointmentsForThisDay = appointments[indexOfTheDay];
    const appointmentsList = document.querySelector('#appointments ul');
    appointmentsList.innerHTML = '';
    appointmentsForThisDay.forEach((appointment) => {
        const newLi = document.createElement('li');
        newLi.innerText = appointment;
        appointmentsList.appendChild(newLi);


    });
    const appointmentDiv = document.getElementById('appointments');
    appointmentDiv.style.display = 'block'
}

//creazione griglia con funzionalità 
const createDays = (numberOfDays) => {
    const calendarDiv = document.getElementById('calendar');
    //ciclo numero giorni, creo e appendo div nel contenitore padre 'calendar'
    for (let i = 0; i < numberOfDays; i++) {
        const dayCellDiv = document.createElement('div');
        dayCellDiv.classList.add('day');
        dayCellDiv.addEventListener('click', function () {
            unselectAllDays();
            dayCellDiv.classList.add('selected');
            changeMeetingDaySection(i);
            if (appointments[i].length > 0) {
                showAppointments(i);
            }
            else {
                const appointmentDiv = document.getElementById('appointments');
                appointmentDiv.style.display = 'none'
            }
        })

        //creo div singoli giorni
        //1.scrivo il numero del giorno
        const cellValue = document.createElement('h3');
        cellValue.innerText = i + 1;
        dayCellDiv.appendChild(cellValue);
        //2.appendo il div del singolo giorno al calendario
        calendarDiv.appendChild(dayCellDiv);
        //3.popolo l'array con l'array corrispondente al singolo giorno
        appointments.push([])

    }
    console.log(appointments)
}

createDays(daysInThisMonth());

const handleFormSubmit = (e) => {
    e.preventDefault();
    //leggere giorno selezionato
    const selectedDay = document.getElementById('newMeetingDay').innerText;
    //leggere ora selezionata
    const meetingTime = document.getElementById('newMeetingTime').value;
    //leggere testo impegno
    const meetingName = document.getElementById('newMeetingName').value;
    //in un unica stringa scrivo orario e testo dell'impegno
    const meetingString = `${meetingTime} - ${meetingName}`;
    const indiceGiorno = parseInt(selectedDay) - 1;
    appointments[indiceGiorno].push(meetingString);

    const dot = document.createElement('span');
    dot.classList.add('dot');
    //trovo cella giorno cliccato
    const selectedCell = document.querySelector('.selected');
    //se il giorno ha già il pallino, non lo devo aggiugnere
    if (!selectedCell.querySelector('.dot')) {
        selectedCell.appendChild(dot);
    }
    //mostra giorni
    showAppointments(indiceGiorno);
}

//avviamo il tutto creando un event listener sul submit del form
const meetingForm= document.querySelector('form');
meetingForm.addEventListener('submit', handleFormSubmit);