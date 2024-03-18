interface Phone {
    credito: number;
    numeroChiamate: number;
}

class User implements Phone {
    nome: string;
    cognome: string;
    credito: Phone["credito"];
    numeroChiamate: Phone["numeroChiamate"];

    constructor(_nome: string, _cognome: string, _credito: number, _numeroChiamate: number) {
        this.nome = _nome;
        this.cognome = _cognome;
        this.credito = _credito;
        this.numeroChiamate = _numeroChiamate;
    }

    ricarica(soldi: number) {
        this.credito += soldi;
        return `Ricarica di ${soldi} € effettuata!`;
    }

    chiamata(minuti: number) {
        this.credito -= (minuti * 0.2);
        this.numeroChiamate += minuti
        return `Durata chiamata: ${minuti}; I minuti in chiamata totali sono: ${this.numeroChiamate}`;
    }

    chiama404() {
        return `Il credito residuo è ${this.credito}€`;
    }

    getNumeroChiamate() {
        return `I minuti in chiamata totali sono: ${this.numeroChiamate}`;
    }

    azzeraChiamate() {
        this.numeroChiamate = 0
    }

}

let gab = new User('Gabriele', 'Scognamiglio', 10, 0)
// console.log(gab.chiamata(50));
// console.log(gab.chiamata(12));
// console.log(gab.ricarica(150));
// console.log(gab.getNumeroChiamate());
// console.log(gab.chiama404());

const aggiornaCredito = document.getElementById('aggiornaCredito') as HTMLElement;
const aggiornaChiamate = document.getElementById('aggiornaChiamate') as HTMLElement;
const azzeraChiamate = document.getElementById('azzeraChiamate') as HTMLButtonElement;
const chiama = document.getElementById('chiama') as HTMLButtonElement;
const terminaChiamata = document.getElementById('terminaChiamata') as HTMLButtonElement;
const timer = document.getElementById('timer') as HTMLElement;
const inputRicarica = document.getElementById('inputRicarica') as HTMLInputElement;
const btnRicarica = document.getElementById('btnRicarica') as HTMLButtonElement;
const nome = document.getElementById('nome') as HTMLElement;
const cognome = document.getElementById('cognome') as HTMLElement;
const credito = document.getElementById('credito') as HTMLElement;
const minChiamate = document.getElementById('minChiamate') as HTMLElement;


window.addEventListener('load', init);

function init(): void {
    nome.innerText = gab.nome;
    cognome.innerText = gab.cognome;
    credito.innerText = gab.chiama404();
    minChiamate.innerText = `${gab.numeroChiamate}`;

}

btnRicarica.addEventListener('click', function (e) {
    e.preventDefault();
    gab.ricarica(parseInt(inputRicarica.value))
    inputRicarica.value = ''
}
)

aggiornaCredito.addEventListener('click', function (e) {
    e.preventDefault();
    credito.innerText = gab.chiama404();
}
)

aggiornaChiamate.addEventListener('click', function (e) {
    e.preventDefault();
    minChiamate.innerText = `${gab.numeroChiamate}`;
}
)


let tempo = 0
let intervallo: number;
function timerino() {
    tempo++
    timer.innerText = `${tempo}`
}

chiama.addEventListener('click', function () {
    if (tempo !== 0) {
        return
    }
    else { intervallo = setInterval(timerino, 1000); }

});

terminaChiamata.addEventListener('click', function () {
    clearInterval(intervallo);
    gab.chiamata(tempo);
    tempo = 0
    timer.innerText = '';
})

azzeraChiamate.addEventListener('click', function () {
    gab.azzeraChiamate();
    minChiamate.innerText = `${gab.numeroChiamate}`;
})
