//variabili global
const numeriEstratti = []
const tabellone = document.getElementById('tabellone')
const bottone = document.getElementById('estrai')
const ultimoEstratto = document.getElementById('ultimoEstratto')
const ricomincia = document.getElementById('ricomincia')
let numeroEstratto;


ricomincia.addEventListener('click', ricominciaGioco)

function ricominciaGioco(){
    window.location.reload()
}


//creazione griglione iniziale

const griglia = () => {
    for (let i = 1; i < 91; i++) {
        const cella = document.createElement('div');
        cella.setAttribute('class', 'celle')
        cella.innerHTML = i
        tabellone.appendChild(cella);
    }
}


griglia();

//IL B.O.T.T.O.N.E.
bottone.addEventListener('click', estraiNumero);


function estraiNumero() {
    ultimoEstratto.style.display = "inline-block";

    numeroEstratto = Math.floor(Math.random() * 90) + 1;
    if (numeriEstratti.includes(numeroEstratto)) {
        numeriEstratti.splice(numeriEstratti.length, 1)
        estraiNumero();
    }
    console.log(numeroEstratto);  //e intanto il c***o di numero lo genera! DAJE!
    numeriEstratti.push(numeroEstratto)
    ultimoEstratto.innerHTML = `L'ultimo numero estratto è: &nbsp; <span> ${numeroEstratto} </span>`
    console.log(numeriEstratti);
    evidenziaEstratti();

}


//evidenziare numeri usciti (e mo te vojo vede)

function evidenziaEstratti() {
    let celleEstratte = document.querySelectorAll('.celle');
    for (let i = 0; i < celleEstratte.length; i++) {
        if (numeriEstratti.includes(parseInt(celleEstratte[i].innerHTML))) {
            celleEstratte[i].classList.add('estratte');
        }
    }
}




