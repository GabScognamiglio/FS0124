var User = /** @class */ (function () {
    function User(_nome, _cognome, _credito, _numeroChiamate) {
        this.nome = _nome;
        this.cognome = _cognome;
        this.credito = _credito;
        this.numeroChiamate = _numeroChiamate;
    }
    User.prototype.ricarica = function (soldi) {
        this.credito += soldi;
        return "Ricarica di ".concat(soldi, " \u20AC effettuata!");
    };
    User.prototype.chiamata = function (minuti) {
        this.credito -= (minuti * 0.2);
        this.numeroChiamate += minuti;
        return "Durata chiamata: ".concat(minuti, "; I minuti in chiamata totali sono: ").concat(this.numeroChiamate);
    };
    User.prototype.chiama404 = function () {
        return "Credito residuo: ".concat(this.credito, "\u20AC");
    };
    User.prototype.getNumeroChiamate = function () {
        return "I minuti in chiamata totali sono: ".concat(this.numeroChiamate);
    };
    User.prototype.azzeraChiamate = function () {
        this.numeroChiamate = 0;
    };
    return User;
}());
var gab = new User('Gabriele', 'Scognamiglio', 10, 0);
var aggiornaCredito = document.getElementById('aggiornaCredito');
var aggiornaChiamate = document.getElementById('aggiornaChiamate');
var azzeraChiamate = document.getElementById('azzeraChiamate');
var chiama = document.getElementById('chiama');
var terminaChiamata = document.getElementById('terminaChiamata');
var timer = document.getElementById('timer');
var inputRicarica = document.getElementById('inputRicarica');
var btnRicarica = document.getElementById('btnRicarica');
var nome = document.getElementById('nome');
var cognome = document.getElementById('cognome');
var credito = document.getElementById('credito');
var minChiamate = document.getElementById('minChiamate');
var tempo = 0;
var intervallo;
window.addEventListener('load', init);
function init() {
    nome.innerText = gab.nome;
    cognome.innerText = gab.cognome;
    credito.innerText = gab.chiama404();
    minChiamate.innerText = "".concat(gab.numeroChiamate);
}
btnRicarica.addEventListener('click', function (e) {
    e.preventDefault();
    gab.ricarica(parseInt(inputRicarica.value));
    inputRicarica.value = '';
});
aggiornaCredito.addEventListener('click', function (e) {
    e.preventDefault();
    credito.innerText = gab.chiama404();
});
aggiornaChiamate.addEventListener('click', function (e) {
    e.preventDefault();
    minChiamate.innerText = "".concat(gab.numeroChiamate);
});
function timerino() {
    tempo++;
    timer.innerText = "".concat(tempo);
}
chiama.addEventListener('click', function () {
    if (tempo !== 0) {
        return;
    }
    else {
        intervallo = setInterval(timerino, 1000);
    }
});
terminaChiamata.addEventListener('click', function () {
    clearInterval(intervallo);
    gab.chiamata(tempo);
    tempo = 0;
    timer.innerText = '';
});
azzeraChiamate.addEventListener('click', function () {
    gab.azzeraChiamate();
    minChiamate.innerText = "".concat(gab.numeroChiamate);
});
